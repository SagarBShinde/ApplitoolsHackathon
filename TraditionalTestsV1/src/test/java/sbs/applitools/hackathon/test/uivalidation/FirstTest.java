package sbs.applitools.hackathon.test.uivalidation;

import org.testng.annotations.Test;

import sbs.applitools.hackathon.framework.baseTest.BaseTest;
import sbs.applitools.hackathon.framework.dataProvider.TestTargetList;
import sbs.applitools.hackathon.framework.excptions.FactoryException;
import sbs.applitools.hackathon.framework.setup.TestTarget;
import sbs.applitools.hackathon.pages.HomePage;


@TestTargetList({"Default","Mobile_chrome"})
@Test
public class FirstTest extends BaseTest {
	 
	
	 public FirstTest(TestTarget target) {
		    this.testTarget = target;
		 }
		    
	public FirstTest() {
		    	
		}
	


	public void validateProductCount() throws NoSuchFieldException, SecurityException, FactoryException {
		System.out.println("Is Driver null in the test"+ this.getDriver() == null);
		HomePage homePage = new HomePage(this.getDriver());
		System.out.println(homePage.appHeader.getDriver() == null);
		//homePage.appHeader.click(homePage.appHeader.mainMenu);
		System.out.println(homePage.appHeader.mainMenu.getCssValue("color"));
		System.out.println(homePage.appHeader.mainMenu.getCssValue("width"));
		System.out.println("Search Display:" + homePage.appHeader.validateSearch());
		System.out.println("Products displayed are:"+ homePage.productSection.getGridItemCount());
		this.testTarget.visual_attribute_dir = ".//config/visual_attributes//laptop_chrome";
		homePage.appHeader.validateVisualAttributesForElements(homePage.appHeader, homePage.getClass().getSimpleName(), this.testTarget);
	
	}
	

//	public void validateProductCount2() {
//		System.out.println("Is Driver null in the test"+ this.getDriver() == null);
//		HomePage homePage = new HomePage(this.getDriver());
//		System.out.println(homePage.appHeader.getDriver() == null);
//		homePage.appHeader.click(homePage.appHeader.mainMenu);
//		System.out.println("Products displayed are:"+ homePage.productSection.getGridItemCount());
//	}
	
	
}
