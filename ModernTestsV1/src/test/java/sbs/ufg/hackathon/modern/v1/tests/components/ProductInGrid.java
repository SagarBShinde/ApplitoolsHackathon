package sbs.ufg.hackathon.modern.v1.tests.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import sbs.ufg.hackathon.modern.v1.framework.basePage.BaseComponent;

//Product in grid in needs to be instantiated in the context of gridItem
// hence this component is peculiar

public class ProductInGrid extends BaseComponent {
	
	
	private WebElement offRibbon;
	private WebElement productImage;
	private WebElement countDown;
	private WebElement productName;
	private WebElement salePrice;
	private WebElement originalPrice;
	private WebElement wishList;
	private WebElement addToCompare;
	private WebElement addToCart;
	
	public ProductInGrid(WebDriver driver) {
		this.setDriver(driver);
	}
	
	
	
	public void instantiateProductElements(WebElement product) {
		this.offRibbon = product.findElement(By.xpath(".//*[contains(@id, 'SPAN__ribbonoff')]"));
		this.productImage = product.findElement(By.xpath(".//*[contains(@id, 'IMG__imgfluid')]"));
		this.countDown = product.findElement(By.xpath(".//*[contains(@id, 'DIV__countdown')]"));
		this.productName = product.findElement(By.xpath(".//*[contains(@id, 'H3____')]"));
		this.salePrice = product.findElement(By.xpath(".//*[contains(@id, 'SPAN__newprice')]"));
		this.originalPrice = product.findElement(By.xpath(".//*[contains(@id, 'SPAN__oldprice')]"));
		this.wishList = product.findElement(By.xpath(".//*[contains(@id, 'I__tiheart')]"));
		this.addToCompare = product.findElement(By.xpath(".//*[contains(@id, 'I__ticontrols')]"));
		this.addToCart = product.findElement(By.xpath(".//*[contains(@id, 'I__tishopping')]"));
	}
	

	@Override
	public void wait_till_load() {
		waitTilVisible(productName);
		
	}
	
	public WebElement getSelectedProduct() {
		return this.productImage;
	}
	

}


  
