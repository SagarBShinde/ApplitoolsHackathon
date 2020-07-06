package sbs.ufg.hackathon.traditional.v1.tests.components;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import sbs.ufg.hackathon.traditional.v1.framework.basePage.BaseComponent;
import sbs.ufg.hackathon.traditional.v1.framework.excptions.FrameworkException;
import sbs.ufg.hackathon.traditional.v1.framework.setup.TestTarget;

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
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public String getProductName() {
		return this.productName.getText();
		
	}
	
	public Map<String,String> checkProductName(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.productName, "productName");
	
	}
	
	public Map<String,String> checkProductImage(String pageName, TestTarget target) throws FrameworkException{
		String[] cssProperties = new String[] { "background-image"};
		return this.compareElementVisuals(pageName, target, this.productImage, "productImage",cssProperties);
	
	}
	
	

	
}
