package sbs.ufg.hackathon.modern.v1.framework.basePage;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import sbs.ufg.hackathon.modern.v1.framework.constants.FrameworkConstants;
import sbs.ufg.hackathon.modern.v1.framework.excptions.FrameworkException;

public abstract class BaseComponent{
	
	private static final Logger LOG = LogManager.getLogger(BaseComponent.class);
	public WebDriver driver;
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public abstract void wait_till_load();
	
	
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
	//	getWait().until(ExpectedConditions.visibilityOf(element));	
		return element;
		
	}
	
	
	protected void scrollToElement(WebElement element) {
		((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView();", element);
	}
	
	protected void hoverOverElement(WebElement element) {
		Actions actions =  new Actions(this.driver);
		actions.moveToElement(element).perform();
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
	
	
	
	
	
	
	
	
	

