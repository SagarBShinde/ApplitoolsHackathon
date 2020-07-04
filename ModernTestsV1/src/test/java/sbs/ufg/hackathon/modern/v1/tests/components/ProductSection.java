package sbs.ufg.hackathon.modern.v1.tests.components;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import sbs.ufg.hackathon.modern.v1.framework.basePage.BaseComponent;
import sbs.ufg.hackathon.modern.v1.tests.pages.ProductDetailPage;

public class ProductSection extends BaseComponent {
	
		
	public ProductSection(WebDriver driver) {
		this.setDriver(driver);
	}
	
	
	@FindBy(how = How.ID , using = "DIV__collg__186") 
	private WebElement productSectionContainer;

	@FindBy(how = How.ID , using = "DIV__topbanner__187") 
	private WebElement topProduct;
	
	@FindBy(how = How.ID , using = "UL__clearfix__191") 
	private WebElement productViewBar;
	
	@FindBy(how = How.ID , using = "sort") 
	private WebElement sortDropDown;
	
	@FindBy(how = How.ID , using = "I__tiviewgrid__202")
	private WebElement gridViewBtn; 
	
	@FindBy(how = How.ID , using = "I__tiviewlist__204")
	private WebElement listViewBtn; 
	
	@FindBy(how = How.ID , using = "A__openfilter__206")
	private WebElement openFilterBtn; 
	
	@FindBy(how = How.ID , using = "product_grid")
	private WebElement productGrid; 
	
	@FindBy(how = How.CLASS_NAME , using = "grid_item")
	private List<WebElement> gridItems;
	
	
	public int getGridItemCount() {
		return gridItems.size();
		
	}
	
	public ProductDetailPage viewProductDetail(int productIndex) {
		this.gridItems.get(productIndex-1).click();
		return new ProductDetailPage(this.driver);
		
	}

	@Override
	public void wait_till_load() {
		waitTilVisible(topProduct);
		waitTilVisible(gridItems.get(0));
		
	}
	
	public WebElement getGridItem(int index) {
		return gridItems.get(index - 1);
	}
	
	public ProductDetailPage selectItem(int index) {
		waitTilVisible(gridItems.get(index-1));
		gridItems.get(index - 1).click();
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		productDetailPage.wait_til_load();
		return productDetailPage;
	}
	
	public void hoverOnProduct(int productIndex ) {
		
		scrollToElement(this.gridItems.get(productIndex-1));
		waitTilVisible(this.gridItems.get(productIndex-1));
		hoverOverElement(gridItems.get(productIndex-1));
		
		
	}
	
	public void openFilter() {
		if(this.openFilterBtn.isDisplayed()) {
			this.openFilterBtn.click();
		}
	}


}
