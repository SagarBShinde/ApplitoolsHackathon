package sbs.applitools.hackathon.test.uivalidation;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.applitools.eyes.TestResultContainer;
import com.applitools.eyes.TestResults;
import com.applitools.eyes.selenium.fluent.Target;
import com.applitools.eyes.visualgrid.model.DeviceName;


import sbs.applitools.hackathon.framework.baseTest.BaseTest;
import sbs.applitools.hackathon.framework.excptions.FrameworkException;
import sbs.applitools.hackathon.framework.excptions.ReporterException;
import sbs.applitools.hackathon.framework.excptions.UnsupportedTestTargetException;
import sbs.applitools.hackathon.framework.setup.TestTarget;
import sbs.applitools.hackathon.framework.setup.TestTargetList;
import sbs.applitools.hackathon.framework.setup.device.DeviceType;
import sbs.applitools.hackathon.pages.HomePage;

@Test
@TestTargetList({"Laptop_all", "Tablet_all", "Mobile_chrome"})
public class Task1 extends AppliToolsBaseTest{
	
	 //This method will run the steps and capture screenshots with eyes at the required screens
	
	public void validateProductCount() throws FrameworkException {
		
		System.out.println(this.eyes.getApiKey());
		this.eyes.open(this.getDriver(), "Test app", "Task-1");
		HomePage homePage = new HomePage(this.getDriver());
		this.eyes.check(Target.window().fully().withName("Home page"));
		homePage.productSection.viewProductDetail(1);
		this.eyes.setWaitBeforeScreenshots(5);
		this.eyes.check(Target.window().fully().withName("Product Detail page"));
		
		com.applitools.eyes.TestResultsSummary allTestResults = runner.getAllTestResults(false);
		System.out.println(runner.getAllTestResults().getAllResults().getClass().getSimpleName());
		this.testResults =allTestResults.getAllResults();
		
		for(TestResultContainer result: testResults) {
			result.getTestResults().getStatus();
			result.getBrowserInfo().getBrowserType();
		}
		this.report.write(allTestResults.toString());
		
	}
	
	
	// This method will validate the rendering results for every Test target
	
	@Test(dataProvider = "testTargetProvider")
	public void validateUIResults(TestTarget target) throws FrameworkException {
		TestResultContainer result = this.findResultsForTarget(target);
		System.out.println(result);
		report.write("Task 1 – Cross-Device Elements Test Test Target:" + target.toString() + " Status:" + result.getTestResults().getStatus());
		Assert.assertEquals(result.getTestResults().getStatus().toString(), "Passed");

		
		
		
		
		//		for(TestResultContainer result: this.testResults) {
//			findResultsForTarget(target)
//			
//			
//			if (target.device.deviceType == DeviceType.LAPTOP) {
//				
//			}
//			
//			if (result.getBrowserInfo().getBrowserType().toString().equalsIgnoreCase(target.browser.browserName)  && result.getBrowserInfo().getViewportSize().toString() == target.browserSize.toString()) {
//				System.out.println("******************Match Found**********************");
//				
//			}
//			System.out.println("Inside for loop***************************************************");
//			System.out.println(result.getTestResults().getStatus());
//			System.out.println(result.getTestResults().getStepsInfo().toString());
//			System.out.println(result.getBrowserInfo().getBrowserType());
//			System.out.println(result.getBrowserInfo().getViewportSize());
//			System.out.println(result.getBrowserInfo().getEmulationInfo().getDeviceName());
//			System.out.println(result.getBrowserInfo().getIosDeviceInfo());
//			System.out.println(result.getTestResults().getMatches());
			 
//		}		
		
		
	}



	
	
}
