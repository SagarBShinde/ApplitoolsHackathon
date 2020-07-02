package sbs.applitools.hackathon.framework.setup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import sbs.applitools.hackathon.framework.baseTest.DriverFactory;
import sbs.applitools.hackathon.framework.excptions.FrameworkException;
import sbs.applitools.hackathon.framework.setup.device.Device;
import sbs.applitools.hackathon.framework.setup.device.DeviceOrientation;
import sbs.applitools.hackathon.framework.utils.propertyHandler;
import sbs.applitools.hackathon.framework.setup.Browser;

public class TestTarget {
	
	public String targetName;
	public Device device;
	public DeviceOrientation orientation;
	public Browser browser;
	public ViewPort browserSize;
	public String visual_attribute_dir;
	
	private static final Logger LOG = LogManager.getLogger(TestTarget.class);

	public TestTarget(String targetName) {
	this.targetName = targetName;
	}	

	@Override
	public String toString() {
		return this.targetName + "::" + this.device.toString() + "::" + this.orientation + "::" + this.browser.toString() + "::" + this.browserSize.toString();
		
	}
}
