package sbs.applitools.hackathon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import sbs.applitools.hackathon.components.AppHeader;
import sbs.applitools.hackathon.components.ProductSection;
import sbs.applitools.hackathon.framework.basePage.BasePage;

public class HomePage extends BasePage {
	
	public AppHeader appHeader;
	public ProductSection productSection;
	
	public HomePage(WebDriver driver) {
		System.out.println("********Inside the home page constructor*************");
		System.out.println("Is Driver null in the page"+ driver == null);
		this.driver = driver;
		this.appHeader = PageFactory.initElements(this.driver, AppHeader.class);
		this.productSection = PageFactory.initElements(this.driver, ProductSection.class);
	}
	
	
	
	

}
