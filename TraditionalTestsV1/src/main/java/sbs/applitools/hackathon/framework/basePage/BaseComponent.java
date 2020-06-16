package sbs.applitools.hackathon.framework.basePage;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class BaseComponent {
	
	public WebDriver driver;
	//private WebDriverWait wait = new WebDriverWait(this.driver, FrameworkConstants.MAX_EXPLICIT_WAIT);
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public <T extends BaseComponent> Map<String,String> validateVisualAttributesForElements(T component, String pageName, TestTarget target) throws FactoryException{
		
		System.out.println(component.getClass().getDeclaredFields().length);
		System.out.println(this.getClass().getDeclaredFields().length);
		Field[] elements = Arrays.stream(component.getClass().getDeclaredFields())
								.filter(el -> el.getType()== WebElement.class)
								.toArray(Field[]::new);
		
		System.out.println("--------------------------------------");
		System.out.println(elements.length);
		
		for(Field field:elements ) {			
			VisualAttribute v = new VisualAttribute(pageName);
			System.out.println(v.getExpectedVisualAttributes(this.getClass().getSimpleName(), field.getName(), target));
			
		}
		
		return null;		
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
		return element;
		
	}
	
	
	protected void scrollToElement(WebElement element) {
		
	}
	
	private WebDriverWait getWait() {
		
		if (getDriver()==null) {
			System.out.println("In the WebDriver wait driver is null");
		}
		WebDriverWait wait = new WebDriverWait(this.getDriver(), FrameworkConstants.MAX_EXPLICIT_WAIT);
		return wait;
	}
	
	private String getLocator(String elementName) {
		
		
		return null;	
		
	}
}
	
	
	
	
	
	
	
	
	

