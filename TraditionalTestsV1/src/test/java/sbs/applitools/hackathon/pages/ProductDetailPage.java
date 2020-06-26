package sbs.applitools.hackathon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import sbs.applitools.hackathon.components.AppHeader;
import sbs.applitools.hackathon.components.MainNavBar;
import sbs.applitools.hackathon.components.ProductInfo;
import sbs.applitools.hackathon.components.ProductMain;
import sbs.applitools.hackathon.components.ProductOption;
import sbs.applitools.hackathon.framework.basePage.BasePage;

public class ProductDetailPage extends BasePage {

	public AppHeader appHeader;
	public MainNavBar mainNavBar;
	public ProductInfo productInfo;
	public ProductMain productMain;
	public ProductOption productOption;
	
	public ProductDetailPage(WebDriver driver) {
		
		this.appHeader = PageFactory.initElements(this.driver, AppHeader.class);
		this.mainNavBar = PageFactory.initElements(this.driver, MainNavBar.class);
		this.productInfo = PageFactory.initElements(this.driver, ProductInfo.class);
		this.productMain = PageFactory.initElements(this.driver, ProductMain.class);
		this.productOption = PageFactory.initElements(this.driver, ProductOption.class);
		
	}
	
	
	
	@Override
	public void wait_til_load() {
		this.productMain.wait_till_load();
		
	}

}
