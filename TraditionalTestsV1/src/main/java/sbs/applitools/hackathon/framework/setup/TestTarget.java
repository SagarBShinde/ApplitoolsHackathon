package sbs.applitools.hackathon.framework.setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import sbs.applitools.hackathon.framework.baseTest.DriverFactory;
import sbs.applitools.hackathon.framework.excptions.FrameworkException;
import sbs.applitools.hackathon.framework.setup.device.Device;
import sbs.applitools.hackathon.framework.utils.propertyHandler;
import sbs.applitools.hackathon.framework.setup.Browser;

public class TestTarget {
	
	public String targetName;
	public Device device;
	public DeviceOrientation orientation;
	public Browser browser;
	public ViewPort browserSize ;
	


public TestTarget(String targetName) {
	this.targetName = targetName;
}	

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
	
	
	
	
	
//	t.browser = b;
//	
//	t.browser.size.height = 700;
//	t.browser.size.width = 768;	
	
	
	WebDriver D = new DriverFactory(t).setUpDriver();
	
	D.get(propertyHandler.getInstance().getValue("app.v1.url"));
	System.out.println(D.manage().window().getSize().height);
	System.out.println(D.manage().window().getSize().width);
	
	WebElement e = D.findElement(By.id("NAV__colxlcollg__10"));
	

}







}
