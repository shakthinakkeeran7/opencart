package com.practice;

import org.json.simple.JSONObject;

import com.partycity.util.JsonUtils;

public class TempFile extends JsonUtils {

	
	public static void main(String[] args) {
		
		
		
	Object object = readJsonFile().get("address");
	
	Object valueFromJsonObject = getValueFromJsonObject((JSONObject) object, "street");
	System.out.println(valueFromJsonObject);
	//JSONObject jsonObject = JsonUtils.parseJsonString(jsonString);
	//System.out.println(jsonObject.get("street")); // Output: John
	///System.out.println(jsonObject.get("zip")); // Output: 30
	//System.out.println(jsonObject.get("city")); // Output: New York

		

		
		
		
		
		
		
		
		
		
		
	}
}
