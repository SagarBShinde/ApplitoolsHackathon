package sbs.ufg.hackathon.traditional.v2.tests.test.uivalidation;

import sbs.ufg.hackathon.traditional.v2.tests.pages.HomePage;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import sbs.ufg.hackathon.traditional.v2.framework.excptions.FrameworkException;
import sbs.ufg.hackathon.traditional.v2.framework.setup.TestTarget;
import sbs.ufg.hackathon.traditional.v2.framework.testFactory.TestTargetList;

@Test
@TestTargetList({"Laptop_all","Tablet_all","Mobile_chrome"})
public class FilterTest extends AppliToolsBaseTest {
	
	 public FilterTest(TestTarget target) {
		    this.testTarget = target;
		 }
		    
	public FilterTest() {
	}
	
	@Test(description = "Validate Number of Filtered products for Black color Filter" , priority = 0)
	public void validateColorFilterResults() throws FrameworkException {
		StringBuilder reportRec = this.getReportLine("Task: 2, Test Name: Validate number of filtered products for Black color filter:","Filter Results",this.testTarget );

		HomePage homePage = new HomePage(this.getDriver());
		homePage.applyColorFilter("Black");
		
		int matchProductCount = homePage.colorFilter.getExpectedMatchCount("Black");
		int actualProductCount = homePage.productSection.getGridItemCount();
		String status = (matchProductCount == actualProductCount) ? "Pass" : "Fail";
		reportRec.append("Status: "+status);
		this.report.write(reportRec.toString());
		Assert.assertEquals(actualProductCount, matchProductCount);	
		
	}
	
	@Test(description = "Validate off Ribbon for first product in Grid", priority = 1)
	public void validateOffRibbon() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		WebElement product = homePage.productSection.getGridItem(1);
		homePage.product.instantiateProductElements(product);
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate Off Ribbon first product",homePage.product.getLocator("offRibbon"),this.testTarget );
		
		Map<String, String> compareResult = homePage.product.checkOffRibbon("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate product image for the first product on the grid on the home page", priority = 1)
	public void validateProductImage() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		
		WebElement product = homePage.productSection.getGridItem(1);
		homePage.product.instantiateProductElements(product);
		
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate product image",homePage.product.getLocator("productImage"),this.testTarget );
		
		Map<String, String> compareResult = homePage.product.checkProductImage("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate count down for the first product on the grid on the home page", priority = 1 )
	public void validateCountDown() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		
		WebElement product = homePage.productSection.getGridItem(1);
		homePage.product.instantiateProductElements(product);
		
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate count down",homePage.product.getLocator("countDown"),this.testTarget );
		
		Map<String, String> compareResult = homePage.product.checkCountDown("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate product name for the first product on the grid on the home page", priority = 1)
	public void validateProductName() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		
		WebElement product = homePage.productSection.getGridItem(1);
		homePage.product.instantiateProductElements(product);
		
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate product name",homePage.product.getLocator("productName"),this.testTarget );
		
		Map<String, String> compareResult = homePage.product.checkProductName("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate original price for the first product on the grid on the home page", priority = 1)
	public void validateOriginalPrice() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		
		WebElement product = homePage.productSection.getGridItem(1);
		homePage.product.instantiateProductElements(product);
		
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate original price",homePage.product.getLocator("originalPrice"),this.testTarget );
		
		Map<String, String> compareResult = homePage.product.checkOriginalPrice("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate original price for the first product on the grid on the home page", priority = 1)
	public void validateSalePrice() throws FrameworkException {
		HomePage homePage = new HomePage(this.getDriver());
		
		WebElement product = homePage.productSection.getGridItem(1);
		homePage.product.instantiateProductElements(product);
		
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate sale price",homePage.product.getLocator("salePrice"),this.testTarget );
		
		Map<String, String> compareResult = homePage.product.checkSalePrice("homePage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	@Test(description = "Validate cart icon for the first product on the grid on the home page", priority = 1)
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
	
	@Test(description = "Validate wish List icon for the first product on the grid on the home page", priority = 1)
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
	
	@Test(description = "Validate wish List icon for the first product on the grid on the home page", priority = 1)
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
