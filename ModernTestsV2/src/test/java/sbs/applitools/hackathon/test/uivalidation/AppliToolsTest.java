package sbs.applitools.hackathon.test.uivalidation;

import org.testng.annotations.Test;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.TestResultContainer;
import com.applitools.eyes.TestResults;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;

import sbs.applitools.hackathon.framework.baseTest.BaseTest;
import sbs.applitools.hackathon.framework.setup.TestTarget;
import sbs.applitools.hackathon.framework.setup.TestTargetList;
import sbs.applitools.hackathon.pages.HomePage;


@TestTargetList({"Default"})
@Test
public class AppliToolsTest extends BaseTest{
		


public static final String APPLITOOLS_API_KEY = "pDeTTwxP3CxxR4jNcnmy2WlxukkxwgeVzVmZWytVRtI110";

public void validateProductCount() throws InterruptedException {
	
	VisualGridRunner runner = new VisualGridRunner(10);
	Eyes eyes = new Eyes(runner);
	
	
	Configuration config = new Configuration();
	config.setApiKey(APPLITOOLS_API_KEY);
	config.setBatch(new BatchInfo("Ultrafast Batch-6"));
	config.addBrowser(1200, 700, BrowserType.CHROME);
	config.addBrowser(1200, 700, BrowserType.FIREFOX);
	config.addBrowser(1200, 700, BrowserType.EDGE_CHROMIUM);
	config.addBrowser(768, 700, BrowserType.CHROME);
	config.addBrowser(768, 700, BrowserType.FIREFOX);
	config.addBrowser(768, 700, BrowserType.EDGE_CHROMIUM);
	config.addDeviceEmulation(DeviceName.iPhone_X, ScreenOrientation.PORTRAIT);
	
	eyes.setConfiguration(config);

	eyes.open(this.getDriver(), "Test app", "Task-1");
	
	HomePage homePage = new HomePage(this.getDriver());
	
	eyes.check(Target.window().fully().withName("Home page"));
	homePage.productSection.viewProductDetail(0);
	eyes.setWaitBeforeScreenshots(5);
	eyes.check(Target.window().fully().withName("Product Detail page"));
	eyes.closeAsync();
	eyes.abortAsync();

	
	
	this.getDriver().quit();
	com.applitools.eyes.TestResultsSummary allTestResults = runner.getAllTestResults(false);
	System.out.println(runner.getAllTestResults().getAllResults().getClass().getSimpleName());
	TestResultContainer[] results = runner.getAllTestResults().getAllResults();
	for(TestResultContainer result: results) {
		result.getTestResults().getStatus();
		result.getBrowserInfo().getBrowserType();
	}
	System.out.println(allTestResults);
	
}
	
	
	
	
}