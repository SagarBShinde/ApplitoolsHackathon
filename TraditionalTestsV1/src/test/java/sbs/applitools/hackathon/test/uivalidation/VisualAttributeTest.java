package sbs.applitools.hackathon.test.uivalidation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import net.bytebuddy.asm.Advice.This;
import sbs.applitools.hackathon.framework.baseTest.BaseTest;
import sbs.applitools.hackathon.framework.dataProvider.TestTargetList;
import sbs.applitools.hackathon.framework.excptions.FrameworkException;
import sbs.applitools.hackathon.framework.setup.TestTarget;
import sbs.applitools.hackathon.framework.utils.Utils;
import sbs.applitools.hackathon.pages.HomePage;

@Test
@TestTargetList({"Default"})
public class VisualAttributeTest extends AppliToolsBaseTest {

	 public VisualAttributeTest(TestTarget target) {
		    this.testTarget = target;
		 }
		    
	public VisualAttributeTest() {
	}
	
	@Test(description = "Validate Applitools Logo on the home page")
	public void validateApplitoolsLogo() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate ApplitoolsLogo",homePage.appHeader.getLocator("applitoolsLogo"),this.testTarget );
		
		Map<String, String> compareResult = homePage.appHeader.checkApplitoolsLogo("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
	}
	
	@Test(description = "Validate Main Menu on the home page")
	public void validateMainMenu() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate Main Menu",homePage.appHeader.getLocator("mainMenu"),this.testTarget );
		
		Map<String, String> compareResult = homePage.appHeader.checkMainMenu("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate Home Menu on the home page")
	public void validateHomeMenu() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate homeMenu",homePage.appHeader.getLocator("homeMenu"),this.testTarget );
		
		Map<String, String> compareResult = homePage.appHeader.checkHomeMenu("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate Men Menu on the home page")
	public void validateMenMenu() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate menMenu",homePage.appHeader.getLocator("menMenu"),this.testTarget );
		
		Map<String, String> compareResult = homePage.appHeader.checkMenMenu("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	
	@Test(description = "Validate Women Menu on the home page")
	public void validateWomenMenu() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate womenMenu",homePage.appHeader.getLocator("womenMenu"),this.testTarget );
		
		Map<String, String> compareResult = homePage.appHeader.checkWomenMenu("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate Running Menu on the home page")
	public void validateRunningMenu() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate runningMenu",homePage.appHeader.getLocator("runningMenu"),this.testTarget );
		
		Map<String, String> compareResult = homePage.appHeader.checkRunningMenu("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate Training Menu on the home page")
	public void validateTrainingMenu() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate trainingMenu",homePage.appHeader.getLocator("trainingMenu"),this.testTarget );
		
		Map<String, String> compareResult = homePage.appHeader.checkTrainningMenu("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate Black Filter section on the home page")
	public void validateBlackFilterSection() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate BlackFilterSection",homePage.colorFilter.getLocator("blackFiilterSection"),this.testTarget );
		
		Map<String, String> compareResult = homePage.colorFilter.checkBlackFilterSection("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate Search Bar on the home page")
	public void validateSearchBar() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate Search Bar",homePage.mainNavBar.getLocator("searchBar"),this.testTarget );
		
		Map<String, String> compareResult = homePage.mainNavBar.checkSearchBar("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate Search Input on the home page")
	public void validateSearchInput() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate searchInput",homePage.mainNavBar.getLocator("searchInput"),this.testTarget );
		
		Map<String, String> compareResult = homePage.mainNavBar.checkSearchInput("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate Search button on the home page")
	public void validateSearchBtn() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate search button",homePage.mainNavBar.getLocator("searchBtn"),this.testTarget );
		
		Map<String, String> compareResult = homePage.mainNavBar.checkSearchBtn("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate Customer Tool Section on the home page")
	public void validateCustomerToolSection() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate Customer Tool Section",homePage.mainNavBar.getLocator("customerToolSection"),this.testTarget );
		
		Map<String, String> compareResult = homePage.mainNavBar.checkCustomerToolSection("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate Account on the home page")
	public void validateAccount() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate Account",homePage.mainNavBar.getLocator("account"),this.testTarget );
		
		Map<String, String> compareResult = homePage.mainNavBar.checkAccount("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	
	@Test(description = "Validate wish list on the home page")
	public void validateWishList() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate Wish List",homePage.mainNavBar.getLocator("wishList"),this.testTarget );
		
		Map<String, String> compareResult = homePage.mainNavBar.checkWishList("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate cart on the home page")
	public void validateCar() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate Cart",homePage.mainNavBar.getLocator("cart"),this.testTarget );
		
		Map<String, String> compareResult = homePage.mainNavBar.checkCart("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
//	
//	@Test(description = "Validate Filter button on the home page")
//	public void validateApplitoolsLogo() throws FrameworkException {
//		HomePage homePage = new HomePage(this.getDriver());
//		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate ApplitoolsLogo",homePage.appHeader.getLocator("applitoolsLogo"),this.testTarget );
//		
//		Map<String, String> compareResult = homePage.appHeader.checkApplitoolsLogo("homePage", this.testTarget);
//		
//		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
//		softAssert.assertAll();	
//	}
//	
//	@Test(description = "Validate Filter button on the home page")
//	public void validateApplitoolsLogo() throws FrameworkException {
//		HomePage homePage = new HomePage(this.getDriver());
//		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate ApplitoolsLogo",homePage.appHeader.getLocator("applitoolsLogo"),this.testTarget );
//		
//		Map<String, String> compareResult = homePage.appHeader.checkApplitoolsLogo("homePage", this.testTarget);
//		
//		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
//		softAssert.assertAll();	
//	}
		
}
