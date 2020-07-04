package sbs.ufg.hackathon.modern.v1.framework.utils;


import org.json.JSONArray;
import org.json.JSONObject;


public interface JSONUtils {
	

	public JSONObject getDataObject();
	public JSONArray getJSONArray(String key);
	public JSONObject getJSONObject(String key);
	public int getJSONArrayLength(JSONArray jsonArray);
	<T> T getObject(String jsonString, Class<T> returnClass);
	
	
}
