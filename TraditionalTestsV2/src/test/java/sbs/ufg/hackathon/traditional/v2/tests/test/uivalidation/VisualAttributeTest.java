package sbs.ufg.hackathon.traditional.v2.tests.test.uivalidation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import net.bytebuddy.asm.Advice.This;
import sbs.ufg.hackathon.traditional.v2.framework.baseTest.BaseTest;
import sbs.ufg.hackathon.traditional.v2.framework.dataProvider.TestTargetList;
import sbs.ufg.hackathon.traditional.v2.framework.excptions.FrameworkException;
import sbs.ufg.hackathon.traditional.v2.framework.setup.TestTarget;
import sbs.ufg.hackathon.traditional.v2.framework.utils.Utils;
import sbs.ufg.hackathon.traditional.v2.tests.pages.HomePage;

@Test
@TestTargetList({"Mobile_chrome"})
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
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate BlackFilterSection",homePage.colorFilter.getLocator("blackFilterSection"),this.testTarget );
		
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
	
	@Test(description = "Validate Search button on the home page for Laptop and Tablet")
	public void validatesearchBtnWeb() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate search button",homePage.mainNavBar.getLocator("searchBtnWeb"),this.testTarget );
		
		Map<String, String> compareResult = homePage.mainNavBar.checksearchBtnWeb("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate Search button on the home page for Mobile")
	public void validatesearchBtnMob() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate search button",homePage.mainNavBar.getLocator("searchBtnMob"),this.testTarget );
		
		Map<String, String> compareResult = homePage.mainNavBar.checksearchBtnMob("homePage", this.testTarget);
		
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
	
	@Test(description = "Validate top product on the home page")
	public void validateTopProduct() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate Top Product",homePage.productSection.getLocator("topProduct"),this.testTarget );
		
		Map<String, String> compareResult = homePage.productSection.checkTopProduct("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate Product View Bar on the home page")
	public void validateProductViewBar() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate product view bar",homePage.productSection.getLocator("productViewBar"),this.testTarget );
		
		Map<String, String> compareResult = homePage.productSection.checkProductViewBar("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate sort drop down on the home page")
	public void validateSortDropDown() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate Sort Drop Down",homePage.productSection.getLocator("sortDropDown"),this.testTarget );
		
		Map<String, String> compareResult = homePage.productSection.checkSortDropDown("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate grid view button on the home page")
	public void validateGridViewBtn() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate Grid View",homePage.productSection.getLocator("gridViewBtn"),this.testTarget );
		
		Map<String, String> compareResult = homePage.productSection.checkGridViewBtn("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate list view button on the home page")
	public void validateListViewBtn() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate List View Button",homePage.productSection.getLocator("listViewBtn"),this.testTarget );
		
		Map<String, String> compareResult = homePage.productSection.checkListViewBtn("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate open filter button on the home page")
	public void validateOpenFilterBtn() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate Cart",homePage.productSection.getLocator("openFilterBtn"),this.testTarget );
		
		Map<String, String> compareResult = homePage.productSection.checkOpenFilterBtn("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate product grid on the home page")
	public void validateProductGrid() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate product grid",homePage.productSection.getLocator("productGrid"),this.testTarget );
		
		Map<String, String> compareResult = homePage.productSection.checkProductGrid("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate off Ribbon for first product in Grid")
	public void validateOffRibbon() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		WebElement product = homePage.productSection.getGridItem(1);
		homePage.product.instantiateProductElements(product);
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate Off Ribbon first product",homePage.product.getLocator("offRibbon"),this.testTarget );
		
		Map<String, String> compareResult = homePage.product.checkOffRibbon("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate product image for the first product on the grid on the home page")
	public void validateProductImage() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		
		WebElement product = homePage.productSection.getGridItem(1);
		homePage.product.instantiateProductElements(product);
		
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate product image",homePage.product.getLocator("productImage"),this.testTarget );
		
		Map<String, String> compareResult = homePage.product.checkProductImage("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate count down for the first product on the grid on the home page")
	public void validateCountDown() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		
		WebElement product = homePage.productSection.getGridItem(1);
		homePage.product.instantiateProductElements(product);
		
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate count down",homePage.product.getLocator("countDown"),this.testTarget );
		
		Map<String, String> compareResult = homePage.product.checkCountDown("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate product name for the first product on the grid on the home page")
	public void validateProductName() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		
		WebElement product = homePage.productSection.getGridItem(1);
		homePage.product.instantiateProductElements(product);
		
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate product name",homePage.product.getLocator("productName"),this.testTarget );
		
		Map<String, String> compareResult = homePage.product.checkProductName("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate original price for the first product on the grid on the home page")
	public void validateOriginalPrice() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		
		WebElement product = homePage.productSection.getGridItem(1);
		homePage.product.instantiateProductElements(product);
		
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate original price",homePage.product.getLocator("originalPrice"),this.testTarget );
		
		Map<String, String> compareResult = homePage.product.checkOriginalPrice("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate original price for the first product on the grid on the home page")
	public void validateSalePrice() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		
		WebElement product = homePage.productSection.getGridItem(1);
		homePage.product.instantiateProductElements(product);
		
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate sale price",homePage.product.getLocator("salePrice"),this.testTarget );
		
		Map<String, String> compareResult = homePage.product.checkSalePrice("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate cart icon for the first product on the grid on the home page")
	public void validateAddToCartInProduct() throws FrameworkException {
		int productIndex = 1;
		HomePage homePage = new HomePage(this.getDriver());
		
		WebElement product = homePage.productSection.getGridItem(productIndex);
		homePage.product.instantiateProductElements(product);
		
		homePage.productSection.hoverOnProduct(productIndex);
		homePage.product.waitTilAccountMenu();
		
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate cart icon",homePage.product.getLocator("addToCart"),this.testTarget );
		
		Map<String, String> compareResult = homePage.product.checkAddToCart("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate wish List icon for the first product on the grid on the home page")
	public void validateWishListInProduct() throws FrameworkException {
		int productIndex = 1;
		HomePage homePage = new HomePage(this.getDriver());
		
		WebElement product = homePage.productSection.getGridItem(productIndex);
		homePage.product.instantiateProductElements(product);
		
		homePage.productSection.hoverOnProduct(productIndex);
		homePage.product.waitTilAccountMenu();
		
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate wish list icon",homePage.product.getLocator("wishList"),this.testTarget );
		
		Map<String, String> compareResult = homePage.product.checkWishList("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate wish List icon for the first product on the grid on the home page")
	public void validateAddToCompareInProduct() throws FrameworkException {
		int productIndex = 1;
		HomePage homePage = new HomePage(this.getDriver());
		
		WebElement product = homePage.productSection.getGridItem(productIndex);
		homePage.product.instantiateProductElements(product);
		
		homePage.productSection.hoverOnProduct(productIndex);
		homePage.product.waitTilAccountMenu();
		
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate Add to compare icon",homePage.product.getLocator("addToCompare"),this.testTarget );
		
		Map<String, String> compareResult = homePage.product.checkAddToCompare("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
		
}
