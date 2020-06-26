package sbs.applitools.hackathon.components;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import sbs.applitools.hackathon.framework.basePage.BaseComponent;
import sbs.applitools.hackathon.framework.excptions.FrameworkException;
import sbs.applitools.hackathon.framework.setup.TestTarget;

public class ProductOption extends BaseComponent {
	
	public ProductOption(WebDriver driver) {
		this.setDriver(driver);
	}
	
	@FindBy(how = How.ID , using = "DIV__collg__86") 
	private WebElement ProductOptionContainer;
	
	@FindBy(how = How.ID , using = "SELECTselect-one__wide__93") 
	private WebElement sizeDropDown;
	
	@FindBy(how = How.ID , using = "quantity_1") 
	private WebElement quantityDropDown;
	
	@FindBy(how = How.ID , using = "A__btn__114") 
	private WebElement addToCartBtn;
	
	@FindBy(how = How.ID , using = "old_price") 
	private WebElement originalPrice;
	
	@FindBy(how = How.ID , using = "new_price") 
	private WebElement salePrice;
	
	@FindBy(how = How.ID , using = "discount") 
	private WebElement discount;

	@Override
	public void wait_till_load() {
		waitTilVisible(addToCartBtn);
		
	}
	
	public Map<String,String> checkSizeDropDown(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.sizeDropDown, "sizeDropDown");
	
	}
	
	public Map<String,String> checkQuantityDropDown(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.quantityDropDown, "quantityDropDown");
	
	}
	
	public Map<String,String> checkAddToCartBtn(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.addToCartBtn, "addToCartBtn");
	
	}
	
	public Map<String,String> checkOriginalPrice(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.originalPrice, "originalPrice");
	
	}
	
	public Map<String,String> checkSalePrice(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.salePrice, "salePrice");
	
	}
	
	public Map<String,String> checkDiscount(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.discount, "discount");
	
	}

}
