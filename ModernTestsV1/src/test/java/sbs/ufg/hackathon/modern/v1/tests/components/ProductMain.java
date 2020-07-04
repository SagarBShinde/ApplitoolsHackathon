package sbs.ufg.hackathon.modern.v1.tests.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import sbs.ufg.hackathon.modern.v1.framework.basePage.BaseComponent;

public class ProductMain extends BaseComponent {
	
	public ProductMain(WebDriver driver) {
		this.setDriver(driver);
	}
	

	@FindBy(how = How.ID , using = "DIV__containerm__65") 
	private WebElement ProductMainContainer;
	
	
	@FindBy(how = How.ID , using = "shoe_name") 
	private WebElement productName;
	
	@FindBy(how = How.ID , using = "shoe_img") 
	private WebElement productImage;

	@Override
	public void wait_till_load() {
		waitTilVisible(this.productName);
		waitTilVisible(this.productImage);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
