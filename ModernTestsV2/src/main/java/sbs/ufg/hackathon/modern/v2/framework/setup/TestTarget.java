package sbs.ufg.hackathon.modern.v2.framework.setup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import sbs.ufg.hackathon.modern.v2.framework.baseTest.DriverFactory;
import sbs.ufg.hackathon.modern.v2.framework.excptions.FrameworkException;
import sbs.ufg.hackathon.modern.v2.framework.setup.Browser;
import sbs.ufg.hackathon.modern.v2.framework.setup.device.Device;
import sbs.ufg.hackathon.modern.v2.framework.setup.device.DeviceOrientation;
import sbs.ufg.hackathon.modern.v2.framework.utils.propertyHandler;

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
