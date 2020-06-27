package sbs.applitools.hackathon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import sbs.applitools.hackathon.components.AppHeader;
import sbs.applitools.hackathon.components.FilterButtons;
import sbs.applitools.hackathon.components.MainNavBar;
import sbs.applitools.hackathon.components.ProductInGrid;
import sbs.applitools.hackathon.components.ProductSection;
import sbs.applitools.hackathon.framework.basePage.BasePage;
import sbs.applitools.hackathon.productFilter.BrandsFilter;
import sbs.applitools.hackathon.productFilter.ColorFilter;
import sbs.applitools.hackathon.productFilter.PriceFilter;
import sbs.applitools.hackathon.productFilter.TypeFilter;

public class HomePage extends BasePage {
	
	
	public AppHeader appHeader;
	public MainNavBar mainNavBar;
	public ProductSection productSection;
	public ColorFilter colorFilter;
	public TypeFilter typeFilter;
	public BrandsFilter	brandFilter;
	public PriceFilter priceFilter;
	public FilterButtons filterButtons;
	public ProductInGrid product;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.appHeader = PageFactory.initElements(this.driver, AppHeader.class);
		this.mainNavBar = PageFactory.initElements(this.driver, MainNavBar.class);
		this.productSection = PageFactory.initElements(this.driver, ProductSection.class);
		this.brandFilter = PageFactory.initElements(this.driver, BrandsFilter.class);
		this.colorFilter = PageFactory.initElements(this.driver, ColorFilter.class);
		this.priceFilter = PageFactory.initElements(this.driver, PriceFilter.class);
		this.typeFilter = PageFactory.initElements(this.driver, TypeFilter.class);
		this.filterButtons = PageFactory.initElements(this.driver, FilterButtons.class);
		this.product = PageFactory.initElements(this.driver, ProductInGrid.class);
	}

	@Override
	public void wait_til_load() {
		this.appHeader.wait_till_load();
		
	}	
	
	

	
	

}
