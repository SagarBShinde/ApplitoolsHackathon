package sbs.ufg.hackathon.traditional.v1.framework.setup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import sbs.ufg.hackathon.traditional.v1.framework.baseTest.DriverFactory;
import sbs.ufg.hackathon.traditional.v1.framework.dataProvider.DataProviderJsonImpl;
import sbs.ufg.hackathon.traditional.v1.framework.excptions.FrameworkException;
import sbs.ufg.hackathon.traditional.v1.framework.setup.Browser;
import sbs.ufg.hackathon.traditional.v1.framework.setup.device.Device;
import sbs.ufg.hackathon.traditional.v1.framework.utils.propertyHandler;

public class TestTarget {
	
	public String targetName;
	public Device device;
	public DeviceOrientation orientation;
	public Browser browser;
	public ViewPort browserSize ;
	public String visual_attribute_dir;
	
	private static final Logger LOG = LogManager.getLogger(TestTarget.class);

public TestTarget(String targetName) {
	this.targetName = targetName;
}	


// Move the main class to Test Class
public static void main(String[] args) throws FrameworkException {
	
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver");
	System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"//drivers//msedgedriver");
	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//drivers//geckodriver");
	//WebDriver D = new ChromeDriver();
	//WebDriver D = new EdgeDriver();
	TestTarget t = new TestTarget("test");
	Browser b = new Browser();
	b.browserName = "edge";
	t.browser = b;
	ViewPort browserSize = new ViewPort();
	browserSize.height = 500;
	browserSize.width = 700;
	
	b.size = browserSize;
	t.browserSize = browserSize;
	WebDriver D = new DriverFactory(t).setUpDriver();
	
	D.get(propertyHandler.getInstance().getValue("app.v1.url"));
	LOG.debug(String.format("Browser height is:",D.manage().window().getSize().height));
	LOG.debug(String.format("Browser width is:",D.manage().window().getSize().width));	

}







}
