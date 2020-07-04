package sbs.ufg.hackathon.modern.v1.tests.components;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import sbs.ufg.hackathon.modern.v1.framework.basePage.BaseComponent;
import sbs.ufg.hackathon.modern.v1.framework.excptions.FactoryException;
import sbs.ufg.hackathon.modern.v1.framework.excptions.FrameworkException;
import sbs.ufg.hackathon.modern.v1.framework.setup.TestTarget;
import sbs.ufg.hackathon.modern.v1.framework.utils.VisualAttribute;

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
	
	public Map<String,String> checkfilterBtn(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.filterBtn, "filterBtn");
	
	}
	
	public Map<String,String> checkResetBtn(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.resetBtn, "resetBtn");
	
	}
	
	

}
