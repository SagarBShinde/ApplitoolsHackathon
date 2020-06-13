package sbs.applitools.hackathon.framework.basePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

import sbs.applitools.hackathon.framework.constants.FrameworkConstants;

public class BaseComponent {
	
	public WebDriver driver;
	//private WebDriverWait wait = new WebDriverWait(this.driver, FrameworkConstants.MAX_EXPLICIT_WAIT);
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void click(WebElement element) {
		getWait().until(elementToBeClickable(element))
		.click();
		System.out.println("********************Clicked on this element*******************************");
	}	
	
	public String getText(WebElement element) {
		return getWait().until(visibilityOf(element))
				.getText();
		
	}
	
	public void setText(WebElement element, String text){
		getWait().until(elementToBeClickable(element));
		element.clear();
		element.sendKeys(text);
		
	} 
	
	public String[] getDropDownOptions (WebElement dropDown) {
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
	
	
	public String getDefaultDropDownOption (WebElement dropDown) {
		Select dropDownBox = new Select(dropDown);
		return dropDownBox.getFirstSelectedOption().getText();
	}
	
	public String getDropDownOption (WebElement dropDown) {
		return null;
	}
	
	public void selectDropDownOption (WebElement dropDown, String OptionToSelect) {
		Select dropDownBox = new Select(dropDown);
		dropDownBox.deselectByVisibleText(OptionToSelect);
		
	}
	
	public Map<String, String> getVisualAttributes(WebElement element){
		return null;
	}
	
	public WebElement waitTilVisible(WebElement element) {
		return element;
		
	}
	
	
	public void scrollToElement(WebElement element) {
		
	}
	
	private WebDriverWait getWait() {
		
		if (getDriver()==null) {
			System.out.println("driver is null");
		}
		WebDriverWait wait = new WebDriverWait(this.getDriver(), FrameworkConstants.MAX_EXPLICIT_WAIT);
		return wait;
	}
}
	
	
	
	
	
	
	
	
	

