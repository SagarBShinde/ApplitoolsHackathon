package sbs.applitools.hackathon.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import sbs.applitools.hackathon.framework.basePage.BaseComponent;

public class AppHeader extends BaseComponent {
	
	public AppHeader(WebDriver driver) {
		System.out.println("****** Setting Driver for the component*************");
		System.out.println("Is Driver null in the Appheader component"+ driver == null);
		this.setDriver(driver);
		
		// TODO Auto-generated constructor stub
	}

	@FindBy(how = How.ID , using = "logo")
	private WebElement applitoolsLogo;
	
	@FindBy(how = How.ID , using = "DIV__mainmenu__15")
	public WebElement mainMenu;
	
	@FindBy(how = How.ID , using = "LI__submenu__22")
	private WebElement homeMenu; 
	
	@FindBy(how = How.ID , using = "LI__submenu__24")
	private WebElement menMenu; 
	
	@FindBy(how = How.ID , using = "LI__submenu__26")
	private WebElement womenMenu; 
	
	@FindBy(how = How.ID , using = "LI__submenu__28")
	private WebElement runningMenu; 
	
	@FindBy(how = How.ID , using = "LI__submenu__30")
	private WebElement trainingMenu; 
	
	@FindBy(how = How.ID , using = "DIV__customsear__41")
	private WebElement searchBar;
	
	@FindBy(how = How.ID , using = "INPUTtext____42")
	private WebElement searchInput;
	
	@FindBy(how = How.ID , using = "BUTTONsubmit____43")
	private WebElement searchBtn;
	
	@FindBy(how = How.ID , using = "UL__toptools__46")
	private WebElement customerToolSection;
	
	@FindBy(how = How.ID , using = "DIV__dropdowndr__55")
	private WebElement account;
	
	@FindBy(how = How.ID , using = "A__wishlist__52")
	private WebElement wishList;
	
	@FindBy(how = How.ID , using = "DIV__dropdowndr__48")
	private WebElement cart;
		

}
