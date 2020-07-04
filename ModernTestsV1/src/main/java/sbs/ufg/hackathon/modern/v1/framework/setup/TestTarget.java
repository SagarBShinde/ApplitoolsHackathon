package sbs.ufg.hackathon.modern.v1.framework.setup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import sbs.ufg.hackathon.modern.v1.framework.setup.device.Device;
import sbs.ufg.hackathon.modern.v1.framework.setup.device.DeviceOrientation;

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
