package sbs.applitools.hackathon.components;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import sbs.applitools.hackathon.framework.basePage.BaseComponent;

public class ProductSection extends BaseComponent {
	



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

}
