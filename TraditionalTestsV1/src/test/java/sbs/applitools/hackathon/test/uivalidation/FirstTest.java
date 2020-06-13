package sbs.applitools.hackathon.test.uivalidation;

import org.testng.annotations.Test;

import sbs.applitools.hackathon.framework.baseTest.BaseTest;
import sbs.applitools.hackathon.framework.dataProvider.TestTargetList;
import sbs.applitools.hackathon.framework.setup.TestTarget;
import sbs.applitools.hackathon.pages.HomePage;


@TestTargetList({"Default"})
@Test
public class FirstTest extends BaseTest {
	 
	
	 public FirstTest(TestTarget target) {
		    this.testTarget = target;
		 }
		    
	public FirstTest() {
		    	
		}
	


	public void validateProductCount() {
		System.out.println("Is Driver null in the test"+ this.getDriver() == null);
		HomePage homePage = new HomePage(this.getDriver());
		System.out.println(homePage.appHeader.getDriver() == null);
		homePage.appHeader.click(homePage.appHeader.mainMenu);
		System.out.println("Products displayed are:"+ homePage.productSection.getGridItemCount());
	}
	

	public void validateProductCount2() {
		System.out.println("Is Driver null in the test"+ this.getDriver() == null);
		HomePage homePage = new HomePage(this.getDriver());
		System.out.println(homePage.appHeader.getDriver() == null);
		homePage.appHeader.click(homePage.appHeader.mainMenu);
		System.out.println("Products displayed are:"+ homePage.productSection.getGridItemCount());
	}
	
	
}
