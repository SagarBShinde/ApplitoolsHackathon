package sbs.ufg.hackathon.modern.v1.framework.baseTest;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import sbs.ufg.hackathon.modern.v1.framework.basePage.BaseComponent;
import sbs.ufg.hackathon.modern.v1.framework.constants.FrameworkConstants;
import sbs.ufg.hackathon.modern.v1.framework.excptions.FrameworkException;
import sbs.ufg.hackathon.modern.v1.framework.setup.TestTarget;


public class DriverFactory {
	
	private static final Logger LOG = LogManager.getLogger(DriverFactory.class);
	
	private String defaultBrowser;
	
	public DriverFactory(String defaultBrowser ) {
		this.defaultBrowser = defaultBrowser;
	}

	public WebDriver setUpDriver() throws FrameworkException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver");
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"//drivers//msedgedriver");
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//drivers//geckodriver");
		
		WebDriver d;
		
		
		switch(defaultBrowser.toLowerCase()) {
		
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
		
		case "edge_chromium":
			d = new EdgeDriver();
			setBrowserSize(d);
			setTimeOuts(d);
			break;
		
		default:
			throw new FrameworkException("Browser not supported by the framework, supported browser are chrome, firefox and edge_chromium. Browser found:" + defaultBrowser );
		
		
		}
		return d;
		
	}

	private void setTimeOuts(WebDriver d) {
		d.manage().timeouts().implicitlyWait(FrameworkConstants.DRIVER_IMPLICIT_WAIT, TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(FrameworkConstants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		d.manage().timeouts().setScriptTimeout(FrameworkConstants.SCRRIPT_TIMEOUT, TimeUnit.SECONDS);
	}

	private void setBrowserSize(WebDriver d) {
		Dimension browser_size = new Dimension(1200,700);
		d.manage().window().setSize(browser_size);
	} 
	
	

}