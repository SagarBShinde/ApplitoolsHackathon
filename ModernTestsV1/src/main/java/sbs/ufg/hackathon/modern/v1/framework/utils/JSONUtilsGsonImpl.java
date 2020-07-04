package sbs.ufg.hackathon.modern.v1.framework.utils;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;


public class JSONUtilsGsonImpl implements JSONUtils {

	String JSONString= StringUtils.EMPTY;
	JsonObject jsonObject;
	
	
	public JSONUtilsGsonImpl(String dataJson) {
		
		this.JSONString= dataJson; 
		if(parseJson(this.JSONString).isJsonObject())
			jsonObject= (JsonObject) parseJson(this.JSONString);
		}
	
	public JSONUtilsGsonImpl() {
		
	}

	public JSONObject getDataObject() {
		
		return new JSONObject(this.jsonObject.toString());
			
	}
	
	
	@Override
	public JSONArray getJSONArray(String key) {
		return new JSONArray (this.jsonObject.getAsJsonArray(key).toString()); 
		
	}

	@Override
	public JSONObject getJSONObject(String key) {
		return new JSONObject (this.jsonObject.getAsJsonObject(key).toString()); 
	}

	@Override
	public int getJSONArrayLength(JSONArray jsonArray) {
		return jsonArray.length();
	}
	
	private JsonElement parseJson(String jsonString) throws JsonSyntaxException {
		
		return new JsonParser().parse(jsonString);
		
	}
	
	@Override
	public <T> T getObject(String jsonString, Class<T> returnClass) {
		Gson gson= new GsonBuilder().create();
		return gson.fromJson(jsonString, returnClass);
		
	}

}
