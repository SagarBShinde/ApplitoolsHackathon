package sbs.applitools.hackathon.framework.setup.device;

import sbs.applitools.hackathon.framework.setup.Browser;

// public abstract class Device {
public class Device {

	public String deviceName;
	public DeviceType deviceType;
	public Platform platform;
	public String os;
	public String os_version;
	public Browser[] browsers;
}