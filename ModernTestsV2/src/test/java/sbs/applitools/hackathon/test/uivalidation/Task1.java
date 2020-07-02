package sbs.applitools.hackathon.test.uivalidation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResultContainer;
import com.applitools.eyes.TestResults;
import com.applitools.eyes.selenium.fluent.Target;
import com.applitools.eyes.triggers.MouseAction;
import com.applitools.eyes.visualgrid.model.DeviceName;


import sbs.applitools.hackathon.framework.baseTest.BaseTest;
import sbs.applitools.hackathon.framework.excptions.FrameworkException;
import sbs.applitools.hackathon.framework.excptions.ReporterException;
import sbs.applitools.hackathon.framework.excptions.UnsupportedTestTargetException;
import sbs.applitools.hackathon.framework.setup.TestTarget;
import sbs.applitools.hackathon.framework.setup.TestTargetList;
import sbs.applitools.hackathon.framework.setup.device.DeviceType;
import sbs.applitools.hackathon.pages.HomePage;


@TestTargetList({"Laptop_all", "Tablet_all", "Mobile_chrome"})
public class Task1 extends AppliToolsBaseTest{
	

	@Test(priority = 0)
	public void validateCrossDeviceElements() throws FrameworkException {
	
		this.eyes.open(this.getDriver(), "demo.applitools", "Task 1", new RectangleSize(800,600));
		HomePage homePage = new HomePage(this.getDriver());
		homePage.product.instantiateProductElements(homePage.productSection.getGridItem(1));
		homePage.productSection.hoverOnProduct(1);
		this.eyes.addMouseTrigger(MouseAction.Move, homePage.product.getSelectedProduct());
		
		this.eyes.setWaitBeforeScreenshots(2);
		this.eyes.check(Target.window().fully().withName("Cross-Device Elements Test"));
		
		homePage.productSection.viewProductDetail(1);
		this.eyes.setWaitBeforeScreenshots(2);
		this.eyes.check(Target.window().fully().withName("Cross-Device Elements Test"));
		
		
		this.eyes.close();
	}
	

	@Test(priority = 1)
	public void validateFilterResults() throws FrameworkException {
		
		this.eyes.open(this.getDriver(), "demo.applitools", "Task 2", new RectangleSize(800, 600));
		HomePage homePage = new HomePage(this.getDriver());
		homePage.applyColorFilter("Black");
		
		this.eyes.check(Target.region(By.id("product_grid")).withName("Filter Results"));
		
		eyes.close();
		
	}

	@Test(priority = 2)
	public void validateProductDetails() throws FrameworkException {
	
		this.eyes.open(this.getDriver(), "demo.applitools", "Task 3	", new RectangleSize(800, 600));
		
		HomePage homePage = new HomePage(this.getDriver());
		homePage.applyColorFilter("Black");
		homePage.productSection.viewProductDetail(1);
		
		this.eyes.check(Target.window().fully().withName("Product Details test"));
		
		eyes.close();
	
		
	}

	
	
}
