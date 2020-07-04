package sbs.ufg.hackathon.modern.v1.framework.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebElement;

import com.google.gson.Gson;

import sbs.ufg.hackathon.modern.v1.framework.baseTest.BaseTest;
import sbs.ufg.hackathon.modern.v1.framework.excptions.FactoryException;
import sbs.ufg.hackathon.modern.v1.framework.excptions.FrameworkException;
import sbs.ufg.hackathon.modern.v1.framework.excptions.VisualAttributeException;
import sbs.ufg.hackathon.modern.v1.framework.setup.TestTarget;

public class VisualAttribute {
	
	private String pageName;
	private TestTarget target;
	
	private static final Logger LOG = LogManager.getLogger(VisualAttribute.class);
	
	public VisualAttribute(String pageName) {
		this.pageName = pageName;
	}
	
	
	public Map<String, Object> getExpectedVisualAttributes(String componentName, String elementName, TestTarget target) throws FrameworkException{
		
		try {
		LOG.debug(String.format("Component Name: %s Element Name is : %s Test Target is %s}",componentName,elementName,target.targetName ));
		LOG.debug(String.format("Visual Attribute JSON File Path: %s", target.visual_attribute_dir + "//"+ this.pageName + ".json"));
		String visualAttributeJson = new String(Files.readAllBytes(Paths.get(target.visual_attribute_dir + "//"+ this.pageName + ".json")));
		JSONUtils jsonUtils =  new JSONUtilsGsonImpl(visualAttributeJson);
		JSONArray child_elements = jsonUtils.getJSONObject(componentName).getJSONArray("child_elements");
		
		for(int i=0; i < child_elements.length(); i++) {
			LOG.debug(String.format("Element in the JSOn File is:%s", child_elements.getJSONObject(i).get("element_name")));
			if (child_elements.getJSONObject(i) != null && child_elements.getJSONObject(i).get("element_name")
							.toString().equalsIgnoreCase(elementName)) {
				
				return jsonUtils.getObject(child_elements.getJSONObject(i).toString(), Map.class);
				
			}
		}
		
		LOG.debug(String.format("Could not find the attributes in the JSON file for: %s",elementName));
		return null;
	
		} catch (IOException e) {
			throw new FactoryException ("Error reading a JSON file for:" + componentName + ":" + elementName + "\n" + e.getStackTrace() );
			
			}
		}
	
	// Returns all the attribues-  Element displayed, Size, Location
	public Map<String, Object> getActualVisualAttributes(WebElement el , String[] cssProperties){
		
		Map<String,Object> actualAttributes = new HashMap<String,Object>();
		Map<String,Integer> elementLocation = new HashMap<String,Integer>();
		Map<String,Integer> elementSize = new HashMap<String,Integer>();
		Map <String,String> actual_css_property = new HashMap<String,String>();
		
		actualAttributes.put("isDisplayed", el.isDisplayed());
		actualAttributes.put("element_text", el.getText());
		
		elementLocation.put("X", el.getLocation().getX());
		elementLocation.put("Y", el.getLocation().getY());
		actualAttributes.put("element_location", elementLocation);
		
		elementSize.put("height", el.getSize().getHeight());
		elementSize.put("width", el.getSize().getWidth());
		actualAttributes.put("element_size", elementSize);
		
		for (String cssProperty : cssProperties) {
			actual_css_property.putIfAbsent(cssProperty, el.getCssValue(cssProperty));		
		}
		
		actualAttributes.put("css_properties", actual_css_property);
		return actualAttributes;
		
	}
	
	public  Map<String, Object> getActualVisualAttributes(WebElement el){
		
		Map<String,Object> actualAttributes = new HashMap<String,Object>();
		Map<String,Integer> elementLocation = new HashMap<String,Integer>();
		Map<String,Integer> elementSize = new HashMap<String,Integer>();
		Map <String,String> actual_css_property = new HashMap<String,String>();
		
		actualAttributes.put("isDisplayed", el.isDisplayed());
		actualAttributes.put("element_text", el.getText());
		
		elementLocation.put("X", el.getLocation().getX());
		elementLocation.put("Y", el.getLocation().getY());
		actualAttributes.put("element_location", elementLocation);
		
		elementSize.put("height", el.getSize().getHeight());
		elementSize.put("width", el.getSize().getWidth());
		actualAttributes.put("element_size", elementSize);
	
		return actualAttributes;
		
	}
	
	// Returns only those attributes that are present in Attributes to Fetch
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getActualVisualAttributes(Map<String,Object> AttributesToFetch,WebElement el){
		
		Map<String,Object> actualAttributes = new HashMap<String,Object>();
		
		if (AttributesToFetch.containsKey("isDisplayed")){
			actualAttributes.put("isDisplayed", el.isDisplayed());
		}
		
		if (AttributesToFetch.containsKey("element_text")){
			actualAttributes.put("isDisplayed", el.getText());
		}
		
		if (AttributesToFetch.containsKey("element_location")) {
			Map<String,Integer> elementLocation = new HashMap<String,Integer>();
			elementLocation.put("X", el.getLocation().getX());
			elementLocation.put("Y", el.getLocation().getY());
			actualAttributes.put("element_location", elementLocation);
		}
		
		if (AttributesToFetch.containsKey("element_size")) {
			Map<String,Integer> elementSize = new HashMap<String,Integer>();
			elementSize.put("height", el.getSize().getHeight());
			elementSize.put("width", el.getSize().getWidth());
			actualAttributes.put("element_size", elementSize);
		}
		
		if (AttributesToFetch.containsKey("css_properties")) {
			Map <String,String> actual_css_property = new HashMap<String,String>();
			((Map<String,String>)AttributesToFetch.get("css_properties")).keySet().forEach(
					key -> actual_css_property.put(key, el.getCssValue(key)));
			
			actualAttributes.put("css_properties", actual_css_property);
		}
				
		return actualAttributes;	
	}
	
	//TODO: Remove this
	public static void main(String[] args) throws FrameworkException {
		
		TestTarget t1 = new TestTarget("test");
		t1.visual_attribute_dir = ".//config/visual_attributes//laptop_chrome";
		
		VisualAttribute v1 = new VisualAttribute("HomePage");
		Map<String,Object> m1 = v1.getExpectedVisualAttributes("AppHeader", "applitoolsLogo", t1);
		
		System.out.println((Map<String,String>)(m1.get("css_properties")));
				
	}

	// Start from this.
	public static Map<String,String> compareAttributes(Map<String, Object> expected_values, Map<String, Object> actual_values) {
		Map<String,String> ComparisionResult = new HashMap<String,String>();
		if ((boolean)actual_values.get("isDisplayed")) {
			
			if (expected_values.containsKey("isDisplayed")){
				ComparisionResult.put("isDisplayed", validateVisible((boolean)expected_values.get("isDisplayed"),(boolean)actual_values.get("isDisplayed")));
			}
			
			if (expected_values.containsKey("element_text")){
				ComparisionResult.put("element_text", validateText((String)expected_values.get("element_text"),(String)actual_values.get("element_text")));
			}
			
			if (expected_values.containsKey("element_location")){
				ComparisionResult.put("element_location", validateLocation((Map<String,Double>)expected_values.get("element_location"),(Map<String,Integer>)actual_values.get("element_location")));
			}
			
			if (expected_values.containsKey("element_size")){
				ComparisionResult.put("element_size", validateSize((Map<String,Double>)expected_values.get("element_size"),(Map<String,Integer>)actual_values.get("element_size")));
			}
			
			if (expected_values.containsKey("css_properties")){
				ComparisionResult.put("css_properties", validateCssProperties((Map<String,String>)expected_values.get("css_properties"),(Map<String,String>)actual_values.get("css_properties")) );
			}

			
		}else {
			ComparisionResult.put("isDisplayed", validateVisible((boolean)expected_values.get("isDisplayed"),(boolean)actual_values.get("isDisplayed")));
		
	}

	
		return ComparisionResult;

	}
	
	private static String validateVisible(boolean expected, boolean actual) {
		if (expected == actual) {
			return "Pass";
		}else {
			return String.format("Failed: expected visibility  %s actual visibility %s", expected,actual);
		}
	}
	
	private static String validateText(String expected, String actual) {
		System.out.println("----------------------Inside Validate Test-------------------------------------------------------------");
		if (expected.contentEquals(actual)) {
			return "Pass";
		}else {
			return String.format("Failed: expected text  %s actual text %s", expected,actual);
		}
	}


	private static String validateSize(Map<String,Double> exp_size, Map<String,Integer> act_size) {
		if (exp_size.get("height").intValue() == act_size.get("height").intValue() && exp_size.get("width").intValue() == act_size.get("width").intValue()) {
			
			return "Pass";
			
		}

		return "Fail: expected size  height:" + exp_size.get("height").intValue() + " width:" + exp_size.get("width").intValue() + " actual size height:" + act_size.get("height").intValue() + " width:" + act_size.get("width").intValue();
		//return "height:" + act_size.get("height").intValue() + " width:" + act_size.get("width").intValue();
		
	}

	private static String validateLocation(Map<String,Double> exp_loc, Map<String,Integer> act_loc) {
		if (exp_loc.get("X").intValue() == act_loc.get("X").intValue() && exp_loc.get("Y").intValue() == act_loc.get("Y").intValue()) {
			
			return "Pass";
			
		}
		return "Fail: expected location  X:" + exp_loc.get("X").intValue() + " Y:" + exp_loc.get("Y").intValue() + " actual location X:" + act_loc.get("X").intValue() + " Y:" + act_loc.get("Y").intValue();
		//return "location X:" + act_loc.get("X").intValue() + " Y:" + act_loc.get("Y").intValue();

	}


	private static String validateCssProperties(Map<String,String>exp_prop, Map<String,String> act_prop) {
		Iterator<String> itr = exp_prop.keySet().iterator();
		String status =  "";
		List<String> failed_props = new ArrayList<String>();
		while(itr.hasNext()) {
			String prop = itr.next();
			if (exp_prop.get(prop).equalsIgnoreCase(act_prop.get(prop))) {
				if (status.isEmpty()) {
					status = "Pass"; 
					
				}	
			}else {
				status  = "Fail";
				failed_props.add(prop);
			}
		}
		
		if (status == "Pass") {
			return status;
		}else {
			StringBuffer consolidated_status = new StringBuffer();
			consolidated_status.append("Fail:");
			failed_props.forEach(prop -> consolidated_status.append(prop).append("expected_value: ")
																		 .append(exp_prop.get(prop))
																		 .append("actual_value: ")
																		 .append(act_prop.get(prop)));
			status = consolidated_status.toString();
			return status;
		}	
		
	}
	
	
}
