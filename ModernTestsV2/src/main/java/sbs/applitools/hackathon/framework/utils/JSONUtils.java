package sbs.applitools.hackathon.framework.utils;


import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;


public interface JSONUtils {
	

	public JSONObject getDataObject();
	public JSONArray getJSONArray(String key);
	public JSONObject getJSONObject(String key);
	public int getJSONArrayLength(JSONArray jsonArray);
	<T> T getObject(String jsonString, Class<T> returnClass);
	
	
}
