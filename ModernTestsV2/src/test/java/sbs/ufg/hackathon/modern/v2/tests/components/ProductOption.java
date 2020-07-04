package sbs.ufg.hackathon.modern.v2.tests.components;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import sbs.ufg.hackathon.modern.v2.framework.basePage.BaseComponent;
import sbs.ufg.hackathon.modern.v2.framework.excptions.FrameworkException;
import sbs.ufg.hackathon.modern.v2.framework.setup.TestTarget;

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

}
