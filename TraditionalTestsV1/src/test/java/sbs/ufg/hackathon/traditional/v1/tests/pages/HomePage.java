package sbs.ufg.hackathon.traditional.v1.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import sbs.ufg.hackathon.traditional.v1.framework.basePage.BasePage;
import sbs.ufg.hackathon.traditional.v1.framework.excptions.FrameworkException;
import sbs.ufg.hackathon.traditional.v1.framework.utils.Utils;
import sbs.ufg.hackathon.traditional.v1.tests.components.AppHeader;
import sbs.ufg.hackathon.traditional.v1.tests.components.FilterButtons;
import sbs.ufg.hackathon.traditional.v1.tests.components.MainNavBar;
import sbs.ufg.hackathon.traditional.v1.tests.components.ProductInGrid;
import sbs.ufg.hackathon.traditional.v1.tests.components.ProductSection;
import sbs.ufg.hackathon.traditional.v1.tests.productFilter.BrandsFilter;
import sbs.ufg.hackathon.traditional.v1.tests.productFilter.ColorFilter;
import sbs.ufg.hackathon.traditional.v1.tests.productFilter.PriceFilter;
import sbs.ufg.hackathon.traditional.v1.tests.productFilter.TypeFilter;
import sbs.ufg.hackathon.traditional.v1.tests.pages.ProductDetailPage;

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
	
	public void applyColorFilter(String color) throws FrameworkException {
		this.productSection.openFilter();
		this.colorFilter.selectFilterOption(color);
		this.filterButtons.applyFilter();
	}
	
	public ProductDetailPage selectProductFromProductGrid(int productIndex) {
		this.productSection.viewProductDetail(productIndex -1);
		ProductDetailPage productDetailsPage = new ProductDetailPage(this.driver);
		productDetailsPage.wait_til_load();
		return productDetailsPage;
		
		
	}
	

	
	

}
