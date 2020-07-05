package sbs.ufg.hackathon.traditional.v2.tests.test.uivalidation;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import sbs.ufg.hackathon.traditional.v2.framework.excptions.FrameworkException;
import sbs.ufg.hackathon.traditional.v2.framework.setup.TestTarget;
import sbs.ufg.hackathon.traditional.v2.framework.testFactory.TestTargetList;
import sbs.ufg.hackathon.traditional.v2.tests.pages.HomePage;
import sbs.ufg.hackathon.traditional.v2.tests.pages.ProductDetailPage;

@Test
@TestTargetList({"Mobile_chrome"})
public class ProductsDetailsTest extends AppliToolsBaseTest {
	

		
	public ProductsDetailsTest(TestTarget target) {
		this.testTarget = target;
	}
			    
	public ProductsDetailsTest() {
	}
		
	@Test(description = "Validate Product Details" , priority = 0)
	public void selectProductFromFilterResults() throws FrameworkException {
			
	sbs.ufg.hackathon.traditional.v2.tests.pages.HomePage homePage = new HomePage(this.getDriver());
	homePage.applyColorFilter("Black");
	
	ProductDetailPage productDetailsPage = homePage.selectProductFromProductGrid(1);
	Assert.assertEquals(productDetailsPage.productMain.getProductName().trim(), "Appli Air x Night");

	}
	
	@Test(description = "Validate Default Value in Size Dropdown" , priority = 0)
	public void validateDefaultValueInSizeDropDown() throws FrameworkException {
		StringBuilder reportRec = this.getReportLine("Task: 3, Test Name: Validate Default Value in Size Dropdown:","Filter Results",this.testTarget );

		ProductDetailPage productDetailsPage = new ProductDetailPage(this.getDriver());
		
		String actualDefaultSize = productDetailsPage.productOption.getSizeDropDownDefaultValue();
		String status = (actualDefaultSize.equals("Small (S)")) ? "Pass" : "Fail";
		reportRec.append(", ");
		reportRec.append(status);
		this.report.write(reportRec.toString());
		Assert.assertEquals(actualDefaultSize, "Small (S)");
		
	}
	
	@Test(description = "Validate Default value in Quantity input box" , priority = 0)
	public void validateDefaultValueInQuantityInputBox() throws FrameworkException {
		StringBuilder reportRec = this.getReportLine("Task: 3, Test Name: Validate Default value in Quantity input box:","Filter Results",this.testTarget );

		ProductDetailPage productDetailsPage = new ProductDetailPage(this.getDriver());
		String actualDefaultQuantity = productDetailsPage.productOption.getQuantityInputDefaultValue();
		
		reportRec.append(", ");
		reportRec.append("Expected results: "+ "1"); 
		reportRec.append(", ");
		reportRec.append("Actual results: "+actualDefaultQuantity); 
		String status = (actualDefaultQuantity.equals("1")) ? "Pass" : "Fail";
		reportRec.append(", ");
		reportRec.append(status);
		this.report.write(reportRec.toString());
		Assert.assertEquals(actualDefaultQuantity, "1");
		
	}
	
	@Test(description = "Validate Product Name on the Product Detail Page" , priority = 0)
	public void validateProductName() throws FrameworkException, InterruptedException {
		ProductDetailPage productDetailsPage = new ProductDetailPage(this.getDriver());;
		
		StringBuilder reportRec = this.getReportLine("Task: 3, Test Name: Validate Product Name",productDetailsPage.productMain.getLocator("productName"),this.testTarget );
		
		Map<String, String> compareResult = productDetailsPage.productMain.checkProductName("ProductDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
		
		
	}
	
	@Test(description = "Validate Product Image on the Product Detail Page" , priority = 1)
	public void validateProductImage() throws FrameworkException {
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		
		StringBuilder reportRec = this.getReportLine("Task: 3, Test Name: Validate Product Image",productDetailPage.productMain.getLocator("productImage"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.productMain.checkProductImage("ProductDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
		
		
	}
	
	@Test(description = "Validate Product Id on the Product Detail Page" , priority = 1)
	public void validateProductId() throws FrameworkException {
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		
		StringBuilder reportRec = this.getReportLine("Task: 3, Test Name: Validate Product Image",productDetailPage.productInfo.getLocator("productId"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.productInfo.checkProductId("ProductDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
		
		
	}
	
	@Test(description = "Validate Product review count on the Product Detail Page" , priority = 1)
	public void validateProductReviewCount() throws FrameworkException, InterruptedException {
		
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		
		StringBuilder reportRec = this.getReportLine("Task: 3, Test Name: Validate Product review count",productDetailPage.productInfo.getLocator("reviewCount"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.productInfo.checkReviewCount("ProductDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
		
		
	}
	
	@Test(description = "Validate Product review start-1 on the Product Detail Page" , priority = 1)
	public void validateProductReviewstar_1() throws FrameworkException, InterruptedException {
		
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		
		StringBuilder reportRec = this.getReportLine("Task: 3, Test Name: Validate Product review star_1 ",productDetailPage.productInfo.getLocator("reviewstar_1"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.productInfo.checkReviewstar_1("ProductDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
		
		
	}
	
	@Test(description = "Validate Product review start-2 on the Product Detail Page" , priority = 1)
	public void validateProductReviewstar_2() throws FrameworkException, InterruptedException {
		
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		
		StringBuilder reportRec = this.getReportLine("Task: 3, Test Name: Validate Product review star_2 ",productDetailPage.productInfo.getLocator("reviewstar_2"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.productInfo.checkReviewstar_2("ProductDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
		
		
	}
	
	@Test(description = "Validate Product review start-3 on the Product Detail Page" , priority = 1)
	public void validateProductReviewstar_3() throws FrameworkException, InterruptedException {
		
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		
		StringBuilder reportRec = this.getReportLine("Task: 3, Test Name: Validate Product review star_3 ",productDetailPage.productInfo.getLocator("reviewstar_3"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.productInfo.checkReviewstar_3("ProductDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
		
		
	}
	
	@Test(description = "Validate Product review star-4 on the Product Detail Page" , priority = 1)
	public void validateProductReviewstar_4() throws FrameworkException, InterruptedException {
		
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		
		StringBuilder reportRec = this.getReportLine("Task: 3, Test Name: Validate Product review star_2 ",productDetailPage.productInfo.getLocator("reviewstar_4"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.productInfo.checkReviewstar_4("ProductDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
		
		
	}
	
	@Test(description = "Validate Product review start-5 on the Product Detail Page" , priority = 1)
	public void validateProductReviewstar_5() throws FrameworkException, InterruptedException {
		
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		
		StringBuilder reportRec = this.getReportLine("Task: 3, Test Name: Validate Product review star_5 ",productDetailPage.productInfo.getLocator("reviewstar_5"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.productInfo.checkReviewstar_5("ProductDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
		
		
	}
	
	@Test(description = "Validate Product Size drop down on the Product Detail Page" , priority = 2)
	public void validateSizeDropDown() throws FrameworkException {
		
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		
		StringBuilder reportRec = this.getReportLine("Task: 3, Test Name: Validate Size drop down ",productDetailPage.productOption.getLocator("sizeDropDown"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.productOption.checkSizeDropDown("ProductDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
		
		
	}
	
	@Test(description = "Validate Product quantity input on the Product Detail Page" , priority = 2)
	public void validateQuantityInput() throws FrameworkException {
		
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		
		StringBuilder reportRec = this.getReportLine("Task: 3, Test Name: Validate Product quantity input ",productDetailPage.productOption.getLocator("quantityInput"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.productOption.checkQuantityInput("ProductDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
		
		
	}
	
	@Test(description = "Validate Product Add to cart button on the Product Detail Page" , priority = 2)
	public void validateAddToCartBtn() throws FrameworkException {
		
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		
		StringBuilder reportRec = this.getReportLine("Task: 3, Test Name: Validate Add To Cart Button ",productDetailPage.productOption.getLocator("addToCartBtn"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.productOption.checkAddToCartBtn("ProductDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
		
		
	}
	
	@Test(description = "Validate Product original price on the Product Detail Page" , priority = 2)
	public void validateProductOriginalPrice() throws FrameworkException {
		
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		
		StringBuilder reportRec = this.getReportLine("Task: 3, Test Name: Validate Product original price ",productDetailPage.productOption.getLocator("originalPrice"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.productOption.checkOriginalPrice("ProductDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
		
		
	}
	
	@Test(description = "Validate Product sale price on the Product Detail Page" , priority = 2)
	public void validateProductSalePrice() throws FrameworkException {
		
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		
		StringBuilder reportRec = this.getReportLine("Task: 3, Test Name: Validate Product review star_5 ",productDetailPage.productOption.getLocator("salePrice"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.productOption.checkSalePrice("ProductDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
		
		
	}
	
	@Test(description = "Validate Product discount on the Product Detail Page" , priority = 2)
	public void validateProductDiscount() throws FrameworkException {
		
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		
		StringBuilder reportRec = this.getReportLine("Task: 3, Test Name: Validate product discount  ",productDetailPage.productOption.getLocator("discount"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.productOption.checkDiscount("ProductDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
		
		
	}
	
	@Test(description = "Validate Account on the product details page")
	public void validateAccount() throws FrameworkException {
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		
		StringBuilder reportRec = this.getReportLine("Task: 3, Test Name: Validate Account",productDetailPage.mainNavBar.getLocator("account"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.mainNavBar.checkAccount("productDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
		
	@Test(description = "Validate wish list on the product details page")
	public void validateWishList() throws FrameworkException {
		
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		
		StringBuilder reportRec = this.getReportLine("Task: 3, Test Name: Validate Wish List",productDetailPage.mainNavBar.getLocator("wishList"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.mainNavBar.checkWishList("productDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
	}
	
	
	
}
