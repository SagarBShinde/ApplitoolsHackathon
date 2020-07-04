package sbs.ufg.hackathon.traditional.v2.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import sbs.ufg.hackathon.traditional.v2.framework.basePage.BasePage;
import sbs.ufg.hackathon.traditional.v2.tests.components.AppHeader;
import sbs.ufg.hackathon.traditional.v2.tests.components.MainNavBar;
import sbs.ufg.hackathon.traditional.v2.tests.components.ProductInfo;
import sbs.ufg.hackathon.traditional.v2.tests.components.ProductMain;
import sbs.ufg.hackathon.traditional.v2.tests.components.ProductOption;

public class ProductDetailPage extends BasePage {

	public AppHeader appHeader;
	public MainNavBar mainNavBar;
	public ProductInfo productInfo;
	public ProductMain productMain;
	public ProductOption productOption;
	
	public ProductDetailPage(WebDriver driver) {
		this.driver = driver;
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
