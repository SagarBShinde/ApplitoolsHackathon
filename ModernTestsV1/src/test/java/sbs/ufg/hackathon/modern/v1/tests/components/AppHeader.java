package sbs.ufg.hackathon.modern.v1.tests.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import sbs.ufg.hackathon.modern.v1.framework.basePage.BaseComponent;

public class AppHeader extends BaseComponent {
	
	public AppHeader(WebDriver driver) {
		this.setDriver(driver);
	}

	@Override
	public void wait_till_load() {
		waitTilVisible(this.applitoolsLogo);
	}
	
	
	@FindBy(how = How.ID , using = "DIV__container__4")
	private WebElement AppHeaderContainer;
	
	@FindBy(how = How.ID , using = "logo")
	private WebElement applitoolsLogo;
	
	@FindBy(how = How.ID , using = "DIV__mainmenu__15")
	public WebElement mainMenu;
	
	@FindBy(how = How.ID , using = "LI__submenu__22")
	private WebElement homeMenu; 
	
	@FindBy(how = How.ID , using = "LI__megamenusu__24")
	private WebElement menMenu; 
	
	@FindBy(how = How.ID , using = "LI__megamenusu__26")
	private WebElement womenMenu; 
	
	@FindBy(how = How.ID , using = "LI__megamenusu__28")
	private WebElement runningMenu; 
	
	@FindBy(how = How.ID , using = "LI__megamenusu__30")
	private WebElement trainingMenu; 
	
		

}
