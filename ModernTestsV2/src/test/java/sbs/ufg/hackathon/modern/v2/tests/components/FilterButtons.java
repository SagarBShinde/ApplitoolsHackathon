package sbs.ufg.hackathon.modern.v2.tests.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import sbs.ufg.hackathon.modern.v2.framework.basePage.BaseComponent;

public class FilterButtons extends BaseComponent {
	
	public FilterButtons(WebDriver driver) {
		this.setDriver(driver);
	}

	@FindBy(how = How.ID , using = "DIV__buttons__183")
	private WebElement FilterButtonsContainer ;
	
	@FindBy(how = How.ID , using = "filterBtn")
	private WebElement filterBtn;
	
	@FindBy(how = How.ID , using = "resetBtn")
	private WebElement resetBtn;
	
	
	
	@Override
	public void wait_till_load() {
		waitTilVisible(filterBtn);		
	}
	
	public void applyFilter() {
		scrollToElement(this.filterBtn);
		click(this.filterBtn);
		
	}
	

}
