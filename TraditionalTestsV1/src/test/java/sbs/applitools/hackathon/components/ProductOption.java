package sbs.applitools.hackathon.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import sbs.applitools.hackathon.framework.basePage.BaseComponent;

public class ProductOption extends BaseComponent {
	
	public ProductOption(WebDriver driver) {
		this.setDriver(driver);
	}
	
	@FindBy(how = How.ID , using = "DIV__collg__86") 
	private WebElement ProductOptionContainer;
	
	@FindBy(how = How.ID , using = "SELECTselect-one__wide__93") 
	private WebElement size;
	
	@FindBy(how = How.ID , using = "quantity_1") 
	private WebElement quantity;
	
	@FindBy(how = How.ID , using = "A__btn__114") 
	private WebElement addToCart;
	
	@FindBy(how = How.ID , using = "old_price") 
	private WebElement originalPrice;
	
	@FindBy(how = How.ID , using = "new_price") 
	private WebElement salePrice;
	
	@FindBy(how = How.ID , using = "discount") 
	private WebElement discount;

	@Override
	public void wait_till_load() {
		waitTilVisible(addToCart);
		
	}

}
