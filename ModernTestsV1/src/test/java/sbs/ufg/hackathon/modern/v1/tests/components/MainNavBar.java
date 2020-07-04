package sbs.ufg.hackathon.modern.v1.tests.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import sbs.ufg.hackathon.modern.v1.framework.basePage.BaseComponent;

public class MainNavBar extends BaseComponent {
	
	public MainNavBar(WebDriver driver) {
		this.setDriver(driver);
	}
	
	
	@FindBy(how = How.ID, using = "DIV__container__37")
	private WebElement MainNabVarContainer;
	
	@FindBy(how = How.ID , using = "DIV__customsear__41")
	private WebElement searchBar;
	
	@FindBy(how = How.ID , using = "INPUTtext____42")
	private WebElement searchInput;
	
	@FindBy(how = How.ID , using = "BUTTONsubmit____43")
	private WebElement searchBtnWeb;
	
	@FindBy(how = How.ID , using = "UL__toptools__46")
	private WebElement customerToolSection;
	
	@FindBy(how = How.ID , using = "DIV__dropdowndr__55")
	private WebElement account;
	
	@FindBy(how = How.ID , using = "A__wishlist__52")
	private WebElement wishList;
	
	@FindBy(how = How.ID , using = "DIV__dropdowndr__48")
	private WebElement cart;

	@Override
	public void wait_till_load() {
		waitTilVisible(this.cart);
		
	}

}
