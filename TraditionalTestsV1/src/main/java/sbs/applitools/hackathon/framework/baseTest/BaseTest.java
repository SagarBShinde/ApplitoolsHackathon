package sbs.applitools.hackathon.framework.baseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Factory;

import sbs.applitools.hackathon.framework.dataProvider.TestTargetList;
import sbs.applitools.hackathon.framework.excptions.FactoryException;
import sbs.applitools.hackathon.framework.excptions.FrameworkException;
import sbs.applitools.hackathon.framework.setup.TestTarget;
import sbs.applitools.hackathon.framework.utils.JSONUtils;
import sbs.applitools.hackathon.framework.utils.JSONUtilsGsonImpl;
import sbs.applitools.hackathon.framework.utils.Utils;
import sbs.applitools.hackathon.framework.utils.propertyHandler;

import sbs.applitools.hackathon.framework.constants.*;


public class BaseTest {
	
	

	private static final Logger LOG = LogManager.getLogger(BaseTest.class);
	
	
	public TestTarget testTarget;
	private WebDriver driver;
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	
	@BeforeSuite
	public void methodBeforeSuite() throws FrameworkException {
		LOG.info(propertyHandler.getInstance().getValue("app.v1.url"));
		LOG.debug("Initializing Driver.....");
		this.driver = new DriverFactory(this.testTarget).setUpDriver();
	
		
	}
	
	@BeforeClass
	public void beforeClassMethod() throws FrameworkException {
	
	}
	
	
	
	@BeforeTest
	public void initDriver() throws FrameworkException {
		this.driver.get(propertyHandler.getInstance().getValue("app.v1.url"));
		LOG.info(propertyHandler.getInstance().getValue("app.v1.url"));
	}
	
	@AfterTest
	public void afterTestMethod() throws FrameworkException {
		this.getDriver().quit();
	}
	
	
	
	
	@Factory
    public Object[] factMethod() throws FrameworkException {
		LOG.info(propertyHandler.getInstance().getValue("app.v1.url"));
		try {
			LOG.debug("In the factory method");
			InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("test_targets.json");		
			String targetJson = Utils.readFile(System.getProperty("user.dir")+"//config//test_targets.json");
			LOG.debug("The target JSON is {}", targetJson);
			JSONUtils jsonUtil =  new JSONUtilsGsonImpl(targetJson);
			
			TestTargetList testTargets = this.getClass().getAnnotation(TestTargetList.class);
			System.out.println(testTargets);
			
			System.out.println(jsonUtil.getJSONArray("Laptop_all"));
			
			List<Object> testList = new ArrayList<Object>();
			TestTarget[] targets = (TestTarget[]) jsonUtil.getObject(jsonUtil.getJSONArray("Laptop_all").toString(), TestTarget[].class);
			System.out.println(targets.length);
			for(TestTarget target : targets) {
					testList.add(this.getClass().getConstructor(TestTarget.class).newInstance(target));	
			}
	
			System.out.println(testList.toArray().length);
			return testList.toArray();
		
		} catch (FileNotFoundException e) {
			
			throw new FactoryException("Test targets file not found at:"+ System.getProperty("user.dir")+"//config//test_targets.json" );
			
		} catch (Exception e) {
			
			throw new FactoryException("Encountered exception in the test factory:"+ e.getStackTrace());
			
		}
		
		
		
    
	}

				
}
