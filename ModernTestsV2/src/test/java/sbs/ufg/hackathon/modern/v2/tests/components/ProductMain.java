package sbs.ufg.hackathon.modern.v2.tests.components;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import sbs.ufg.hackathon.modern.v2.framework.basePage.BaseComponent;
import sbs.ufg.hackathon.modern.v2.framework.excptions.FrameworkException;
import sbs.ufg.hackathon.modern.v2.framework.setup.TestTarget;

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
	
	public Map<String,String> checkProductName(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.productName, "productName");
	
	}
	
	public Map<String,String> checkProductImage(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.productImage, "productImage");
	
	}
	
	

	
}
