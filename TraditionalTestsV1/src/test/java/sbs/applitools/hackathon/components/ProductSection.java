package sbs.applitools.hackathon.components;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import sbs.applitools.hackathon.framework.basePage.BaseComponent;
import sbs.applitools.hackathon.framework.excptions.FrameworkException;
import sbs.applitools.hackathon.framework.setup.TestTarget;

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
	private WebElement gridView; 
	
	@FindBy(how = How.ID , using = "I__tiviewgrid__202")
	private WebElement listView; 
	
	@FindBy(how = How.ID , using = "A__openfilter__206")
	private WebElement openFiilter; 
	
	@FindBy(how = How.ID , using = "product_grid")
	private WebElement productGrid; 
	
	@FindBy(how = How.CLASS_NAME , using = "grid_item")
	private List<WebElement> gridItems;
	
	
	public int getGridItemCount() {
		return gridItems.size();
		
	}
	
	public void viewProductDetail(int productIndex) {
		this.gridItems.get(productIndex).click();
		
	}

	@Override
	public void wait_till_load() {
		waitTilVisible(topProduct);
		
	}
	
	public WebElement getGridItem(int index) {
		return gridItems.get(index - 1);
	}
	
	public void hoverOnProduct(int productIndex ) {
		
		scrollToElement(this.gridItems.get(productIndex-1));
		waitTilVisible(this.gridItems.get(productIndex-1));
		hoverOverElement(gridItems.get(productIndex-1));
		
		
	}
	
	public Map<String,String> checkTopProduct(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.topProduct, "topProduct");
	
	}
	
	public Map<String,String> checkProductViewBar(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.productViewBar, "productViewBar");
	
	}
	
	public Map<String,String> checkSortDropDown(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.sortDropDown, "sortDropDown");
	
	}
	
	
	public Map<String,String> checkGridView(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.gridView, "gridView");
	
	}
	
	public Map<String,String> checkListView(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.listView, "listView");
	
	}
	
	public Map<String,String> checkOpenFiilter(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.openFiilter, "openFiilter");
	
	}
	
	public Map<String,String> checkProductGrid(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.productGrid, "productGrid");
	
	}


}
