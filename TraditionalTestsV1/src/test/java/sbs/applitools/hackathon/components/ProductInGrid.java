package sbs.applitools.hackathon.components;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import sbs.applitools.hackathon.framework.basePage.BaseComponent;
import sbs.applitools.hackathon.framework.excptions.FrameworkException;
import sbs.applitools.hackathon.framework.setup.TestTarget;

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
		this.offRibbon = product.findElement(By.xpath(".//contains[@id, 'SPAN__ribbonoff']"));
		this.productImage = product.findElement(By.xpath(".//contains[@id, 'IMG__imgfluid']"));
		this.countDown = product.findElement(By.xpath(".//contains[@id, 'DIV__countdown']"));
		this.productName = product.findElement(By.xpath(".//contains[@id, 'H3____']"));
		this.salePrice = product.findElement(By.xpath(".//contains[@id, 'SPAN__newprice']"));
		this.originalPrice = product.findElement(By.xpath(".//contains[@id, 'SPAN__oldprice']"));
		this.wishList = product.findElement(By.xpath(".//contains[@id, 'I__tiheart']"));
		this.addToCompare = product.findElement(By.xpath(".//contains[@id, 'I__ticontrols']"));
		this.addToCart = product.findElement(By.xpath(".//contains[@id, 'I__tishopping']"));
	}
	

	@Override
	public void wait_till_load() {
		waitTilVisible(productName);
		
	}
	
	public Map<String,String> checkOffRibbon(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.offRibbon, "offRibbon");
	
	}
	
	public Map<String,String> checkProductImage(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.productImage, "productImage");
	
	}
	
	public Map<String,String> checkCountDown(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.countDown, "countDown");
	
	}
	
	public Map<String,String> checkProductName(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.productName, "productName");
	
	}
	
	public Map<String,String> checkSalePrice(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.salePrice, "salePrice");
	
	}
	
	public Map<String,String> checkOriginalPrice(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.originalPrice, "originalPrice");
	
	}
	
	public Map<String,String> checkWishList(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.wishList, "wishList");
	
	}
	
	public Map<String,String> checkAddToCompare(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.addToCompare, "addToCompare");
	
	}
	
	public Map<String,String> checkAddToCart(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.addToCart, "addToCart");
	
	}


}
