package sbs.ufg.hackathon.traditional.v2.framework.baseTest;

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
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Factory;

import sbs.ufg.hackathon.traditional.v2.framework.constants.*;
import sbs.ufg.hackathon.traditional.v2.framework.dataProvider.TestTargetList;
import sbs.ufg.hackathon.traditional.v2.framework.excptions.FactoryException;
import sbs.ufg.hackathon.traditional.v2.framework.excptions.FrameworkException;
import sbs.ufg.hackathon.traditional.v2.framework.excptions.ReporterException;
import sbs.ufg.hackathon.traditional.v2.framework.excptions.VisualAttributeException;
import sbs.ufg.hackathon.traditional.v2.framework.setup.TestTarget;
import sbs.ufg.hackathon.traditional.v2.framework.utils.JSONUtils;
import sbs.ufg.hackathon.traditional.v2.framework.utils.JSONUtilsGsonImpl;
import sbs.ufg.hackathon.traditional.v2.framework.utils.TestReporter;
import sbs.ufg.hackathon.traditional.v2.framework.utils.Utils;
import sbs.ufg.hackathon.traditional.v2.framework.utils.VisualAttribute;
import sbs.ufg.hackathon.traditional.v2.framework.utils.propertyHandler;


public class BaseTest {
	
	

	private static final Logger LOG = LogManager.getLogger(BaseTest.class);
	
	
	public TestTarget testTarget;
	private WebDriver driver;
	protected TestReporter report;
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	
	@BeforeSuite
	public void methodBeforeSuite() throws FrameworkException {
		LOG.info(propertyHandler.getInstance().getValue("app.v2.url"));
		
	}	
	@AfterSuite
	public void afterSuiteMethod() throws ReporterException  {
		this.report.close();
		
	}
		
	
	
	@BeforeClass
	public void beforeClassMethod() throws FrameworkException {
		this.report = TestReporter.getInstance();
		LOG.debug("Initializing Driver.....");
		this.driver = new DriverFactory(this.testTarget).setUpDriver();
		this.driver.get(propertyHandler.getInstance().getValue("app.v2.url"));
	
	}
	
	@AfterClass
	public void afterClassMethod() throws FrameworkException {
		LOG.debug("Closing Driver.....");
		this.getDriver().quit();
		
	
	}
	
	
	@BeforeTest
	public void initDriver() throws FrameworkException {
		
		LOG.info(propertyHandler.getInstance().getValue("app.v2.url"));
	}
	
	@BeforeMethod
	public void beforeMethod() throws FrameworkException {
		this.report.open();
	}
	
	@AfterMethod
	public void afterMethod() throws FrameworkException {
		this.report.close();
	}
	
	
	@AfterTest
	public void afterTestMethod() throws FrameworkException {
		this.report.close();
		
	}
	
	
	
	
	@Factory
    public Object[] factMethod() throws FrameworkException {
		LOG.info(propertyHandler.getInstance().getValue("app.v2.url"));
		try {
			LOG.debug("In the factory method");		
			String targetJson = Utils.readFile(System.getProperty("user.dir")+"//config//test_targets.json");
			JSONUtils jsonUtil =  new JSONUtilsGsonImpl(targetJson);
			
			TestTargetList testTargets = this.getClass().getAnnotation(TestTargetList.class);
			List<Object> testList = new ArrayList<Object>();
			for(String testTargetArrayName: testTargets.value()) {
				TestTarget[] targets = (TestTarget[]) jsonUtil.getObject(jsonUtil.getJSONArray(testTargetArrayName).toString(), TestTarget[].class);
				LOG.debug("Test Target Array Name:"+ testTargetArrayName +" Test Target Array lenght:"+ targets.length);
				for(TestTarget target : targets) {
					testList.add(this.getClass().getConstructor(TestTarget.class).newInstance(target));	
				}
				
			}
			
			LOG.debug(String.format("Length of the Target Array is: %d", testList.toArray().length));
			return testList.toArray();
		
		} catch (FileNotFoundException e) {
			
			throw new FactoryException("Test targets file not found at:"+ System.getProperty("user.dir")+"//config//test_targets.json" );
			
		} catch (Exception e) {
			
			throw new FactoryException("Encountered exception in the test factory:"+ e.getStackTrace());
			
		}	
    
	}
	
	public StringBuilder getReportLine(String testDescription, String locator, TestTarget target) {
		StringBuilder reportRec = new StringBuilder(testDescription);
		reportRec.append(",");
		//reportRec.append("DOM ID:" + locator);
		//reportRec.append(",");
		reportRec.append("Browser:"+this.testTarget.browser.browserName.toUpperCase());
		reportRec.append(",");
//		reportRec.append("Viewport:"+this.testTarget.browserSize.width + "X" + this.testTarget.browserSize.height);
//		reportRec.append(",");
//		reportRec.append("Device:"+this.testTarget.device.deviceName);
//		reportRec.append(",");
		
		return reportRec;
		
	}

				
}
