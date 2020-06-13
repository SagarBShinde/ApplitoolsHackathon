package sbs.applitools.hackathon.framework.baseTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import sbs.applitools.hackathon.framework.excptions.FrameworkException;
import sbs.applitools.hackathon.framework.setup.TestTarget;
import sbs.applitools.hackathon.framework.constants.FrameworkConstants;


public class DriverFactory {
	
	private TestTarget target;
	
	
	public DriverFactory(TestTarget target ) {
		this.target = target;
	}

	public WebDriver setUpDriver() throws FrameworkException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver");
		
		WebDriver d;
		
		
		switch(this.target.browser.browserName.toLowerCase()) {
		
		case "chrome":
			d = new ChromeDriver();
			setBrowserSize(d);
			setTimeOuts(d);
			break;
		
		case "firefox":
			d = new FirefoxDriver();
			setBrowserSize(d);
			setTimeOuts(d);
			break;
		
		case "edge":
			d = new EdgeDriver();
			setBrowserSize(d);
			setTimeOuts(d);
			break;
		
		default:
			throw new FrameworkException("Test target contains a browser not supported by the framework, supported browser are chrome, firefox and edge. Browser found" + target.browser.browserName );
		
		
		}
		return d;
		
	}

	private void setTimeOuts(WebDriver d) {
		d.manage().timeouts().implicitlyWait(FrameworkConstants.DRIVER_IMPLICIT_WAIT, TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(FrameworkConstants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		d.manage().timeouts().setScriptTimeout(FrameworkConstants.SCRRIPT_TIMEOUT, TimeUnit.SECONDS);
	}

	private void setBrowserSize(WebDriver d) {
		Dimension browser_size = new Dimension(target.browserSize.width,target.browserSize.height);
		//Dimension browser_size = new Dimension(500,700);
		d.manage().window().setSize(browser_size);
	//	d.manage().window().maximize();
	} 
	
	

}
