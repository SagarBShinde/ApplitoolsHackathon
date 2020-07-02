package sbs.applitools.hackathon.framework.baseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;

import sbs.applitools.hackathon.framework.excptions.FactoryException;
import sbs.applitools.hackathon.framework.excptions.FrameworkException;
import sbs.applitools.hackathon.framework.excptions.ReporterException;
import sbs.applitools.hackathon.framework.excptions.VisualAttributeException;
import sbs.applitools.hackathon.framework.setup.Browser;
import sbs.applitools.hackathon.framework.setup.TestTarget;
import sbs.applitools.hackathon.framework.setup.TestTargetList;
import sbs.applitools.hackathon.framework.setup.device.DeviceOrientation;
import sbs.applitools.hackathon.framework.setup.device.DeviceType;
import sbs.applitools.hackathon.framework.utils.JSONUtils;
import sbs.applitools.hackathon.framework.utils.JSONUtilsGsonImpl;
import sbs.applitools.hackathon.framework.utils.TestReporter;
import sbs.applitools.hackathon.framework.utils.Utils;
import sbs.applitools.hackathon.framework.utils.VisualAttribute;
import sbs.applitools.hackathon.framework.utils.propertyHandler;

import sbs.applitools.hackathon.framework.constants.*;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.TestResultContainer;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import com.applitools.eyes.TestResults;
import com.applitools.eyes.TestResultsSummary;


public class BaseTest {
	
	

	private static final Logger LOG = LogManager.getLogger(BaseTest.class);
	
	
	protected TestTarget[] testTargets;
	protected TestResultContainer[] testResults;
	private WebDriver driver;
	protected TestReporter report;
	protected Configuration config;
	protected VisualGridRunner runner;
	protected Eyes eyes;
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	
	@BeforeSuite
	public void methodBeforeSuite() throws FrameworkException {
		LOG.info("STARTING TEST EXCUTION.................");
		LOG.info("Application URL is:" + propertyHandler.getInstance().getValue("app.v1.url"));
		
	}	
	@AfterSuite
	public void afterSuiteMethod() throws ReporterException  {
		LOG.info("FINISHING TEST EXCUTION.................");
		this.report.close();
		LOG.debug("Closed report...");
		this.eyes.abortIfNotClosed();
		LOG.debug("Eyes closed...");
		
	}
		
	
	
	@BeforeClass
	@Parameters({"default_browser"})
	public void beforeClassMethod(String defaultBrowser) throws FrameworkException {
		this.report = TestReporter.getInstance();
		LOG.debug("Initializing Driver.....");
		this.driver = new DriverFactory(defaultBrowser).setUpDriver();
		
		this.config = new Configuration();
		this.config.setApiKey(propertyHandler.getInstance().getValue("applitools.sbs.api.key"));
		LOG.debug("API Key is set..");
		
		this.config.setBatch(new BatchInfo(propertyHandler.getInstance().getValue("config.applitools.batchName")));
		
		this.runner = new VisualGridRunner(10);
		this.eyes = new Eyes(runner);	
		
		this.testTargets = getTestTargets();
		LOG.debug("No. of Test Targets to execute test against:"+ this.testTargets.length);
		addBrowsers();
		LOG.debug("No. of Configurations added:"+ config.getBrowsersInfo().size());
		eyes.setConfiguration(config);
		LOG.debug("Test configuration is complete..");
	
	}


	@AfterClass
	public void afterClassMethod() throws FrameworkException {
		LOG.debug("Closing Driver.....");
		this.getDriver().quit();
	    eyes.abortIfNotClosed();
		LOG.debug("Test is concluded...");
	  }
		
	
	
	@BeforeMethod
	public void beforeMethod() throws FrameworkException {
		LOG.debug("Opening Test report for writting....");
		this.report.open();
		this.driver.get(propertyHandler.getInstance().getValue("app.v1.url"));
	}
	
	@AfterMethod
	public void afterMethod() throws FrameworkException {
		LOG.debug("Closing Test report....");
		this.report.close();
	  
	}
	

	
	/* Returns the consolidated list of Test targets for the given test by reading the 
	 * the annotation value @TestTargetList
	 */
    public TestTarget[] getTestTargets() throws FrameworkException {
		
		try {
			LOG.debug("Getting targets for test execution...");
			LOG.debug("Reading Targets file from:"+(System.getProperty("user.dir")+"//config//test_targets.json"));
			String targetJson = Utils.readFile(System.getProperty("user.dir")+"//config//test_targets.json");
			JSONUtils jsonUtil =  new JSONUtilsGsonImpl(targetJson);
			
			TestTargetList testTargets = this.getClass().getAnnotation(TestTargetList.class);
			List<TestTarget> testList = new ArrayList<TestTarget>();
			for(String testTargetArrayName: testTargets.value()) {
				TestTarget[] targets = (TestTarget[]) jsonUtil.getObject(jsonUtil.getJSONArray(testTargetArrayName).toString(), TestTarget[].class);
				LOG.debug("Test Target Array Name:"+ testTargetArrayName +" Test Target Array lenght:"+ targets.length);
				for(TestTarget target : targets) {
					testList.add(target);	
				}
				
			}
			return testList.stream().toArray(TestTarget[]::new);
		
		} catch (FileNotFoundException e) {
			
			throw new FactoryException("Test targets file not found at:"+ System.getProperty("user.dir")+"//config//test_targets.json" );
			
		} catch (Exception e) {
			
			throw new FactoryException("Encountered exception in the test factory:"+ e.getStackTrace());
			
		}	
    
	}
	
//	public StringBuilder getReportLine(String testDescription, String locator, TestTarget target) {
////		StringBuilder reportRec = new StringBuilder(testDescription);
////		reportRec.append(",");
////		//reportRec.append("DOM ID:" + locator);
////		//reportRec.append(",");
////		reportRec.append("Browser:"+this.testTarget.browser.browserName.toUpperCase());
////		reportRec.append(",");
//////		reportRec.append("Viewport:"+this.testTarget.browserSize.width + "X" + this.testTarget.browserSize.height);
//////		reportRec.append(",");
//////		reportRec.append("Device:"+this.testTarget.device.deviceName);
//////		reportRec.append(",");
//		
//	//	return reportRec;
//		
//	}
    
	// Only iPhone X is supported are the moment. Modify this code to accept any device given in the Target JSON
	private void addBrowsers() throws FrameworkException {
		for(TestTarget target: this.testTargets) {
			if (target.device.deviceType == DeviceType.LAPTOP || target.device.deviceType == DeviceType.TABLET) {
			this.config.addBrowser(target.browserSize.width, target.browserSize.height, getBrowserType(target.browser.browserName));
			}else {
				this.config.addDeviceEmulation(DeviceName.iPhone_X, ScreenOrientation.PORTRAIT);
			}
		}
		
	}

	private BrowserType getBrowserType(String browserName) throws FrameworkException {
		
		LOG.debug("Gettiing browser type for browser:"+browserName );
		switch(browserName.toLowerCase()) {
		
		case "chrome":
			return BrowserType.CHROME;
		
		case "firefox":
			return BrowserType.FIREFOX;
		
		case "edge_chromium":
			return BrowserType.EDGE_CHROMIUM;
		
		default:
			throw new FrameworkException("Browser not supported by the framework, supported browser are chrome, firefox and edge_chromium. Browser found:" + browserName);
		}
		
		
	}
	@DataProvider (name = "testTargetProvider")
	public Object[][]  testTargetProvider(){
		Object[][] dataArray =  new Object[this.testTargets.length][1];
		for(int i=0; i < this.testTargets.length; i++ ) {
			dataArray[i][0] = this.testTargets[i];
		}
		return dataArray;
	}
				
}
