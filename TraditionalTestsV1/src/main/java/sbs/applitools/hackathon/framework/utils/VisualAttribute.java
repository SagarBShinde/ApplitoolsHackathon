package sbs.applitools.hackathon.framework.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebElement;

import com.google.gson.Gson;

import sbs.applitools.hackathon.framework.excptions.FactoryException;
import sbs.applitools.hackathon.framework.setup.TestTarget;

public class VisualAttribute {
	
	private String pageName;
	private TestTarget target;
	
	public VisualAttribute(String pageName) {
		this.pageName = pageName;
	}
	
	
	public Map<String, Object> getExpectedVisualAttributes(String componentName, String elementName, TestTarget target) throws FactoryException{
		
		try {
		String visualAttributeJson = new String(Files.readAllBytes(Paths.get(target.visual_attribute_dir + "//"+ this.pageName + ".json")));
		//System.out.println(visualAttributeJson);
		JSONUtils jsonUtils =  new JSONUtilsGsonImpl(visualAttributeJson);
		JSONArray child_elements = jsonUtils.getJSONObject(componentName).getJSONArray("child_elements");
		
		for(int i=0; i < child_elements.length(); i++) {
			System.out.println(child_elements.getJSONObject(i).get("element_name").toString());
			System.out.println("Element Name is:"+ elementName);
			System.out.println(child_elements.getJSONObject(i).get("element_name").toString().equalsIgnoreCase(elementName));
			if (child_elements.getJSONObject(i) != null && child_elements.getJSONObject(i).get("element_name").toString().equalsIgnoreCase(elementName)) {
				return jsonUtils.getObject(child_elements.getJSONObject(i).toString(), Map.class);
				
			}
			
		}
		
		throw new FactoryException("Could not find matching child element in JSON for:"+ componentName + ":" + elementName );
	
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new FactoryException("Error reading a Visual attributes for:" + componentName + ":" + elementName + "\n" + e.getStackTrace() );
		  }
		}
	
	public Map<String, Object> getActualVisualAttributes(WebElement el , String[] cssProperties){
		return null;
		
	}
	
	public static void main(String[] args) throws FactoryException {
		
		TestTarget t1 = new TestTarget("test");
		t1.visual_attribute_dir = ".//config/visual_attributes//laptop_chrome";
		
		VisualAttribute v1 = new VisualAttribute("HomePage");
		Map<String,Object> m1 = v1.getExpectedVisualAttributes("AppHeader", "applitoolsLogo", t1);
		
		System.out.println((Map<String,String>)(m1.get("css_properties")));
		
		
	}

}
