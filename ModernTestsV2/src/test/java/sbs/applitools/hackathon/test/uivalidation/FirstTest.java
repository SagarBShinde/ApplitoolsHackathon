package sbs.applitools.hackathon.test.uivalidation;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import sbs.applitools.hackathon.components.ProductInGrid;
import sbs.applitools.hackathon.framework.baseTest.BaseTest;
import sbs.applitools.hackathon.framework.excptions.FactoryException;
import sbs.applitools.hackathon.framework.setup.TestTarget;
import sbs.applitools.hackathon.framework.setup.TestTargetList;
import sbs.applitools.hackathon.pages.HomePage;


//@TestTargetList({"Default","Mobile_chrome"})
@Test
@TestTargetList({"Default"})
public class FirstTest extends BaseTest {
	 
	

	


//	public void validateProductCount() throws NoSuchFieldException, SecurityException, FactoryException, IllegalArgumentException, IllegalAccessException {
//		System.out.println("Is Driver null in the test"+ this.getDriver() == null);
//		HomePage homePage = new HomePage(this.getDriver());
//		System.out.println(homePage.appHeader.mainMenu.getCssValue("color"));
//		System.out.println(homePage.appHeader.mainMenu.getCssValue("width"));
//		this.testTarget.visual_attribute_dir = ".//config/visual_attributes//laptop_chrome";
//		System.out.println("Search Display:" + homePage.appHeader.validateSearchField("HomePage", this.testTarget));
//		System.out.println("Products displayed are:"+ homePage.productSection.getGridItemCount());
//		System.out.println("This is the test Target name:"+ this.testTarget.targetName);
//		List<Map<String, Object>> expectedList = homePage.appHeader.getExpectedVisualAttributes(homePage.appHeader, homePage.getClass().getSimpleName(), this.testTarget);
//		homePage.appHeader.getActualVisualAttributes(expectedList);
//	
//	}
	

	public void validateProductCount2() throws Exception {
		System.out.println("Is Driver null in the test"+ this.getDriver() == null);
		HomePage homePage = new HomePage(this.getDriver());
		homePage.colorFilter.selectFilterOption("black");
		homePage.product.instantiateProductElements(homePage.productSection.getGridItem(2));
		System.out.println(homePage.colorFilter.getMatchCount("black"));
		Thread.sleep(2000);
		homePage.filterButtons.applyFilter();
		Thread.sleep(2000);
		System.out.println(homePage.colorFilter.getMatchCount("black"));
		
	}
	
	
}
