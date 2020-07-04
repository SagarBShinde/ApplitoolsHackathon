package sbs.ufg.hackathon.traditional.v2.tests.components;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import sbs.ufg.hackathon.traditional.v2.framework.basePage.BaseComponent;
import sbs.ufg.hackathon.traditional.v2.framework.excptions.FactoryException;
import sbs.ufg.hackathon.traditional.v2.framework.excptions.FrameworkException;
import sbs.ufg.hackathon.traditional.v2.framework.setup.TestTarget;
import sbs.ufg.hackathon.traditional.v2.framework.utils.Utils;
import sbs.ufg.hackathon.traditional.v2.framework.utils.VisualAttribute;

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
	

	
	
	public Map<String, String> checkApplitoolsLogo (String pageName, TestTarget target) throws FrameworkException {
		return this.compareElementVisuals(pageName, target, this.applitoolsLogo, "applitoolsLogo");
		
	}
	
	
	public Map<String, String> checkMainMenu (String pageName, TestTarget target) throws FrameworkException {
		return this.compareElementVisuals(pageName, target, this.mainMenu, "mainMenu");
		
	}
	
	public Map<String, String> checkHomeMenu (String pageName, TestTarget target) throws FrameworkException {
		return this.compareElementVisuals(pageName, target, this.homeMenu, "homeMenu");
		
	}
	
	public Map<String, String>  checkMenMenu (String pageName, TestTarget target) throws FrameworkException {
		return this.compareElementVisuals(pageName, target, this.menMenu, "menMenu");
		
	}
	
	public Map<String, String> checkWomenMenu (String pageName, TestTarget target) throws FrameworkException {
		return this.compareElementVisuals(pageName, target, this.womenMenu, "womenMenu");
		
	}
	
	public Map<String, String> checkRunningMenu (String pageName, TestTarget target) throws FrameworkException {
		return this.compareElementVisuals(pageName, target, this.runningMenu, "runningMenu");
		
	}
	
	public Map<String, String> checkTrainningMenu (String pageName, TestTarget target) throws FrameworkException {
		return this.compareElementVisuals(pageName, target, this.trainingMenu, "trainingMenu");
		
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void getActualVisualAttributes(List<Map<String, Object>> expectedList) throws FactoryException {
		Iterator<Map<String, Object>> itr = expectedList.listIterator();
		while(itr.hasNext()) {
			Map<String,Object> expected_values = itr.next();
			Map<String,Object> actualAttribute = VisualAttribute.getActualVisualAttributes(expected_values, getElement((String)expected_values.get("element_name")));	
		}
		
	}


	private WebElement getElement(String element_name) throws FactoryException {
		System.out.println("Element Name is:"+ element_name);
		
		try {
			System.out.println(this.getClass().getDeclaredField(element_name).get(this).toString());
			return (WebElement) this.getClass().getDeclaredField(element_name).get(this);
		
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			throw new FactoryException(String.format("Could not access field with name",element_name));
		}
		
	}


	

		

}
