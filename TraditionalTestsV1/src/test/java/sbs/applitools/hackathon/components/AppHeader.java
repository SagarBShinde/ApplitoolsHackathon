package sbs.applitools.hackathon.components;

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

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import sbs.applitools.hackathon.framework.basePage.BaseComponent;
import sbs.applitools.hackathon.framework.excptions.FactoryException;
import sbs.applitools.hackathon.framework.excptions.FrameworkException;
import sbs.applitools.hackathon.framework.setup.TestTarget;
import sbs.applitools.hackathon.framework.utils.Utils;
import sbs.applitools.hackathon.framework.utils.VisualAttribute;

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
	

	
	
	public boolean validateSearchField(String PageName, TestTarget target) throws NoSuchFieldException, SecurityException, FrameworkException {
		
		FindBy f = this.getClass().getDeclaredField("applitoolsLogo").getAnnotation(FindBy.class);
		System.out.println("----------------------------------"+ f.using()+ "----" + f.how());
		VisualAttribute v = new VisualAttribute(PageName);
		Map<String,Object> expected_values = v.getExpectedVisualAttributes(this.getClass().getSimpleName(), "applitoolsLogo", target);
		Map<String,Object> actual_values = v.getActualVisualAttributes(expected_values, this.trainingMenu);
		System.out.println("expected values:" + Utils.mapToString(expected_values));
		System.out.println("actual values:" + Utils.mapToString(actual_values));
		Map<String,String> compare = VisualAttribute.compareAttributes(expected_values,actual_values);
		System.out.println("Comparision result:" + Utils.mapToString(compare));
		return applitoolsLogo.isDisplayed();
		
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
