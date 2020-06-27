package sbs.applitools.hackathon.test.uivalidation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.openqa.selenium.WebElement;
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
@TestTargetList({"Laptop_all"})
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
	public void validateCart() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate Cart",homePage.mainNavBar.getLocator("cart"),this.testTarget );
		
		Map<String, String> compareResult = homePage.mainNavBar.checkCart("homePage", this.testTarget);
		
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
	
	@Test(description = "Validate sale price for the first product on the grid on the home page")
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
