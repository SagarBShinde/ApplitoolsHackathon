package sbs.ufg.hackathon.traditional.v1.framework.baseTest;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import sbs.ufg.hackathon.traditional.v1.framework.basePage.BaseComponent;
import sbs.ufg.hackathon.traditional.v1.framework.constants.FrameworkConstants;
import sbs.ufg.hackathon.traditional.v1.framework.excptions.FrameworkException;
import sbs.ufg.hackathon.traditional.v1.framework.setup.TestTarget;


public class DriverFactory {
	
	private static final Logger LOG = LogManager.getLogger(DriverFactory.class);
	
	private TestTarget target;
	
	public DriverFactory(TestTarget target ) {
		this.target = target;
	}

	public WebDriver setUpDriver() throws FrameworkException {
				
		WebDriver d;
		
		LOG.info("Setting up driver the Driver factory...");
		switch(this.target.browser.browserName.toLowerCase()) {
		
		case "chrome":
			WebDriverManager.chromedriver().setup();
			d = new ChromeDriver();
			setBrowserSize(d);
			setTimeOuts(d);
			break;
		
		case "firefox":
		//	WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//drivers//geckodriver");
			d = new FirefoxDriver();
			setBrowserSize(d);
			setTimeOuts(d);
			break;
		
		case "edge_chromium":
			WebDriverManager.edgedriver().setup();
			d = new EdgeDriver();
			setBrowserSize(d);
			setTimeOuts(d);
			break;
		
		default:
			throw new FrameworkException("Test target contains a browser not supported by the framework, supported browser are chrome, firefox and edge. Browser found :" + target.browser.browserName );
		
		
		}
		return d;
		
	}

	private void setTimeOuts(WebDriver d) {
		LOG.info("Setting up wait timeouts....");
		d.manage().timeouts().implicitlyWait(FrameworkConstants.DRIVER_IMPLICIT_WAIT, TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(FrameworkConstants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		d.manage().timeouts().setScriptTimeout(FrameworkConstants.SCRRIPT_TIMEOUT, TimeUnit.SECONDS);
	}

	private void setBrowserSize(WebDriver d) {
		LOG.info("Setting up browser size as:"+target.browserSize.toString() );
		Dimension browser_size = new Dimension(target.browserSize.width,target.browserSize.height);
		d.manage().window().setSize(browser_size);
	} 
	
	

}
