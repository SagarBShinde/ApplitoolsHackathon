package sbs.applitools.hackathon.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import sbs.applitools.hackathon.framework.basePage.BaseComponent;

public class ProductMain extends BaseComponent {
	
	public ProductMain(WebDriver driver) {
		this.setDriver(driver);
	}
	

	@FindBy(how = How.ID , using = "DIV__containerm__65") 
	private WebElement ProductMainContainer;
	
	
	@FindBy(how = How.ID , using = "shoe_name") 
	private WebElement name;
	
	@FindBy(how = How.ID , using = "shoe_img") 
	private WebElement image;

	@Override
	public void wait_till_load() {
		waitTilVisible(this.name);
		
	}

	
}
