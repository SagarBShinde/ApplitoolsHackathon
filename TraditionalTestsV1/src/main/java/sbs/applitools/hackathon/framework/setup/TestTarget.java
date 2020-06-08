package sbs.applitools.hackathon.framework.setup;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import sbs.applitools.hackathon.framework.setup.device.Device;


public class TestTarget {
	
	public String targetName;
	public Device device;
	public DeviceOrientation orientation;
	public Browser browser;
	public ViewPort browserSize ;
	


public TestTarget(String targetName) {
	this.targetName = targetName;
}	








}
