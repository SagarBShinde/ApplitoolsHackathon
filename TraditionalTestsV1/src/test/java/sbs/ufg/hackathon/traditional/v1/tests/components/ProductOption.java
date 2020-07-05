package sbs.ufg.hackathon.traditional.v1.tests.components;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import sbs.ufg.hackathon.traditional.v1.framework.basePage.BaseComponent;
import sbs.ufg.hackathon.traditional.v1.framework.excptions.FrameworkException;
import sbs.ufg.hackathon.traditional.v1.framework.setup.TestTarget;

public class ProductOption extends BaseComponent {
	
	public ProductOption(WebDriver driver) {
		this.setDriver(driver);
	}
	
	@FindBy(how = How.ID , using = "DIV__collg__86") 
	private WebElement ProductOptionContainer;
	
	@FindBy(how = How.XPATH , using = "//*[@class = 'nice-select wide']")
	private WebElement sizeDropDown;
	
	@FindBy(how = How.ID , using = "quantity_1") 
	private WebElement quantityInput;
	
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
	
	public String getSizeDropDownDefaultValue() {
		return this.driver.findElement(By.id("DIV__customsele__92")).findElement(By.xpath(".//span[@class='current']")).getText();
	}
	
	public String getQuantityInputDefaultValue() {
		return quantityInput.getAttribute("value").trim();
	}
	
	public Map<String,String> checkSizeDropDown(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.sizeDropDown, "sizeDropDown");
	
	}
	
	public Map<String,String> checkQuantityInput(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.quantityInput, "quantityInput");
	
	}
	
	public Map<String,String> checkAddToCartBtn(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.addToCartBtn, "addToCartBtn");
	
	}
	
	public Map<String,String> checkOriginalPrice(String pageName, TestTarget target) throws FrameworkException{
		String[] cssProperties = new String[] {"color","text-decoration-line"}; 
		return this.compareElementVisuals(pageName, target, this.originalPrice, "originalPrice", cssProperties);
	
	}
	
	public Map<String,String> checkSalePrice(String pageName, TestTarget target) throws FrameworkException{
		String[] cssProperties = new String[] {"color","text-decoration-line"}; 
		return this.compareElementVisuals(pageName, target, this.salePrice, "salePrice", cssProperties);
	
	}
	
	public Map<String,String> checkDiscount(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.discount, "discount");
	
	}

}
