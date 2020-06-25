package sbs.applitools.hackathon.framework.basePage;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

import sbs.applitools.hackathon.framework.constants.FrameworkConstants;
import sbs.applitools.hackathon.framework.excptions.FactoryException;
import sbs.applitools.hackathon.framework.excptions.FrameworkException;
import sbs.applitools.hackathon.framework.excptions.VisualAttributeException;
import sbs.applitools.hackathon.framework.setup.TestTarget;
import sbs.applitools.hackathon.framework.utils.VisualAttribute;

public abstract class BaseComponent extends RemoteWebElement{
	
	private static final Logger LOG = LogManager.getLogger(BaseComponent.class);
	public WebDriver driver;
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public abstract void wait_till_load();
	
	 public Map<String,String> compareElementVisuals(String pageName, TestTarget target, WebElement element, String elementName) throws FrameworkException{ 
		 	VisualAttribute v1 = new VisualAttribute(pageName);
			Map<String,Object> expected_values = v1.getExpectedVisualAttributes(this.getClass().getSimpleName(), elementName, target);
			Map<String,Object>actual_values = v1.getActualVisualAttributes(element);
			return VisualAttribute.compareAttributes(expected_values, actual_values);
	 }
	
	
	
	
	// Access the Visual Attribute JSON and returns the expected values for the visual attributes
	public <T extends BaseComponent> List<Map<String, Object>> getExpectedVisualAttributes(T component, String pageName, TestTarget target) throws IllegalArgumentException, IllegalAccessException, FrameworkException{
		
		LOG.debug(String.format("No of members in the %s component %d", component.getClass().getSimpleName(),component.getClass().getDeclaredFields().length));
		
		// Filter all the fields of the component which are WebElements
		Field[] elements = Arrays.stream(component.getClass().getDeclaredFields())
								.filter(el -> el.getType()== WebElement.class)
								.toArray(Field[]::new);
		
		LOG.debug(String.format("Number of WebElements after filtering %d", elements.length));
		List<Map<String, Object>> fieldsToValidate = new ArrayList<Map<String, Object>>();
		VisualAttribute v = new VisualAttribute(pageName);
		
		/* Iterate through the filtered fields and identify the fields which are present in the JSON and needs to be validated
		 	Fetch the expected attributes for that element.
		 	Get the actual attribute for that element and send them to compare method
		 	Create a comparison result map
		 */
		for(Field field:elements ) {			
			if (v.getExpectedVisualAttributes(this.getClass().getSimpleName(), field.getName(), target) != null) {
				fieldsToValidate.add(v.getExpectedVisualAttributes(this.getClass().getSimpleName(), field.getName(), target));
			}else {
				LOG.debug("Did not find expected attributes for the field %s", field.getName());
			}
		}
		LOG.debug(String.format("Total number of fields to validate: %s",fieldsToValidate.size()));
		
		
		return fieldsToValidate;
		
		
	}
	
	protected void click(WebElement element) {
		getWait().until(elementToBeClickable(element))
		.click();
	}	
	
	protected String getText(WebElement element) {
		return getWait().until(visibilityOf(element))
				.getText();
		
	}
	
	protected void setText(WebElement element, String text){
		getWait().until(elementToBeClickable(element));
		element.clear();
		element.sendKeys(text);
		
	} 
	
	protected String[] getDropDownOptions (WebElement dropDown) {
		Select dropDownBox = new Select(dropDown);
		List<WebElement> options = dropDownBox.getOptions();
		String[] optionArray= new String[options.size()];
		int i = 0;
		for(WebElement option: options) {
			optionArray[i] = option.getText();
			i++;
		}		
		return optionArray;		
	}
	
	
	protected String getDefaultDropDownOption (WebElement dropDown) {
		Select dropDownBox = new Select(dropDown);
		return dropDownBox.getFirstSelectedOption().getText();
	}
	
	protected String getDropDownOption (WebElement dropDown) {
		return null;
	}
	
	protected void selectDropDownOption (WebElement dropDown, String OptionToSelect) {
		Select dropDownBox = new Select(dropDown);
		dropDownBox.deselectByVisibleText(OptionToSelect);
		
	}
	
	protected Map<String, String> getVisualAttributes(WebElement element){
		return null;
	}
	
	protected WebElement waitTilVisible(WebElement element) {
		getWait().until(ExpectedConditions.visibilityOf(element));	
		return element;
		
	}
	
	
	protected void scrollToElement(WebElement element) {
		System.out.println(element == null);
		System.out.println(this.driver == null);
		((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView();", element);
	}
	
	private WebDriverWait getWait() {
		
		if (getDriver()==null) {
			System.out.println("In the WebDriver wait driver is null");
		}
		WebDriverWait wait = new WebDriverWait(this.getDriver(), FrameworkConstants.MAX_EXPLICIT_WAIT);
		return wait;
	}
	
	public String getLocator(String elementName) throws FrameworkException  {
		
		try {
			FindBy locator = this.getClass().getDeclaredField(elementName).getAnnotation(FindBy.class);
			return locator.using();
		
		} catch (NoSuchFieldException | SecurityException e) {
			LOG.error(String.format("Could not find field for #{elementName}", elementName));
			throw new FrameworkException(String.format("Could not find field for #{elementName} Error:#{error}", elementName, e.getStackTrace()));
		}
		
		
		
		
	}
}
	
	
	
	
	
	
	
	
	

