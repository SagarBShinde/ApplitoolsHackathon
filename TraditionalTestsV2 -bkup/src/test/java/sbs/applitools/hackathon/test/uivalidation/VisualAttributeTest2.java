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
import sbs.applitools.hackathon.pages.ProductDetailPage;

@Test
@TestTargetList({"Tablet_chrome"})
public class VisualAttributeTest2 extends AppliToolsBaseTest {
	

	 public VisualAttributeTest2(TestTarget target) {
		    this.testTarget = target;
		 }
		    
	public VisualAttributeTest2() {
	}
	
	@Test(description = "Validate Product Name on the Product Detail Page" , priority = 0)
	public void validateProductName() throws FrameworkException, InterruptedException {
		ProductDetailPage productDetailPage = new HomePage(this.getDriver()).productSection.selectItem(1);
		
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate Product Name",productDetailPage.productMain.getLocator("productName"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.productMain.checkProductName("ProductDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
		
		
	}
	
	@Test(description = "Validate Product Image on the Product Detail Page" , priority = 1)
	public void validateProductImage() throws FrameworkException {
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate Product Image",productDetailPage.productMain.getLocator("productImage"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.productMain.checkProductImage("ProductDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
		
		
	}
	
	@Test(description = "Validate Product Id on the Product Detail Page" , priority = 1)
	public void validateProductId() throws FrameworkException {
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate Product Image",productDetailPage.productInfo.getLocator("productId"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.productInfo.checkProductId("ProductDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
		
		
	}
	
	@Test(description = "Validate Product review count on the Product Detail Page" , priority = 1)
	public void validateProductReviewCount() throws FrameworkException, InterruptedException {
		
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate Product review count",productDetailPage.productInfo.getLocator("reviewCount"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.productInfo.checkReviewCount("ProductDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
		
		
	}
	
	@Test(description = "Validate Product review start-1 on the Product Detail Page" , priority = 1)
	public void validateProductReviewstar_1() throws FrameworkException, InterruptedException {
		
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate Product review star_1 ",productDetailPage.productInfo.getLocator("reviewstar_1"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.productInfo.checkReviewstar_1("ProductDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
		
		
	}
	
	@Test(description = "Validate Product review start-2 on the Product Detail Page" , priority = 1)
	public void validateProductReviewstar_2() throws FrameworkException, InterruptedException {
		
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate Product review star_2 ",productDetailPage.productInfo.getLocator("reviewstar_2"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.productInfo.checkReviewstar_2("ProductDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
		
		
	}
	
	@Test(description = "Validate Product review start-3 on the Product Detail Page" , priority = 1)
	public void validateProductReviewstar_3() throws FrameworkException, InterruptedException {
		
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate Product review star_3 ",productDetailPage.productInfo.getLocator("reviewstar_3"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.productInfo.checkReviewstar_3("ProductDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
		
		
	}
	
	@Test(description = "Validate Product review star-4 on the Product Detail Page" , priority = 1)
	public void validateProductReviewstar_4() throws FrameworkException, InterruptedException {
		
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate Product review star_2 ",productDetailPage.productInfo.getLocator("reviewstar_4"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.productInfo.checkReviewstar_4("ProductDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
		
		
	}
	
	@Test(description = "Validate Product review start-5 on the Product Detail Page" , priority = 1)
	public void validateProductReviewstar_5() throws FrameworkException, InterruptedException {
		
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate Product review star_5 ",productDetailPage.productInfo.getLocator("reviewstar_5"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.productInfo.checkReviewstar_5("ProductDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
		
		
	}
	
	@Test(description = "Validate Product Size drop down on the Product Detail Page" , priority = 2)
	public void validateSizeDropDown() throws FrameworkException {
		
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate Size drop down ",productDetailPage.productOption.getLocator("sizeDropDown"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.productOption.checkSizeDropDown("ProductDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
		
		
	}
	
	@Test(description = "Validate Product quantity input on the Product Detail Page" , priority = 2)
	public void validateQuantityInput() throws FrameworkException {
		
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate Product quantity input ",productDetailPage.productOption.getLocator("quantityInput"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.productOption.checkQuantityInput("ProductDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
		
		
	}
	
	@Test(description = "Validate Product Add to cart button on the Product Detail Page" , priority = 2)
	public void validateAddToCartBtn() throws FrameworkException {
		
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate Add To Cart Button ",productDetailPage.productOption.getLocator("addToCartBtn"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.productOption.checkAddToCartBtn("ProductDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
		
		
	}
	
	@Test(description = "Validate Product original price on the Product Detail Page" , priority = 2)
	public void validateProductOriginalPrice() throws FrameworkException {
		
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate Product original price ",productDetailPage.productOption.getLocator("originalPrice"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.productOption.checkOriginalPrice("ProductDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
		
		
	}
	
	@Test(description = "Validate Product sale price on the Product Detail Page" , priority = 2)
	public void validateProductSalePrice() throws FrameworkException {
		
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate Product review star_5 ",productDetailPage.productOption.getLocator("salePrice"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.productOption.checkSalePrice("ProductDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
		
		
	}
	
	@Test(description = "Validate Product discount on the Product Detail Page" , priority = 2)
	public void validateProductDiscount() throws FrameworkException {
		
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate product discount  ",productDetailPage.productOption.getLocator("discount"),this.testTarget );
		
		Map<String, String> compareResult = productDetailPage.productOption.checkDiscount("ProductDetailPage", this.testTarget);
		
		SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
		softAssert.assertAll();	
		reportRec.append("\n");
		
		
	}
	
}
