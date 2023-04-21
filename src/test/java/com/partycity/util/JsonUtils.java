package com.partycity.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class JsonUtils {

    private static final String FILE_PATH = "src/test/resources/TestData/file.json"; // replace with your file path

    // Reading JSON files
    public static JSONObject readJsonFile() {
        JSONObject jsonObject = null;
        try (Reader reader = new FileReader(FILE_PATH)) {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(reader);
            jsonObject = (JSONObject) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    // Writing JSON files
    public static void writeJsonFile(JSONObject jsonObject) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH)) {
            fileWriter.write(jsonObject.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Parsing JSON strings
    public static JSONObject parseJsonString(String jsonString) {
        JSONObject jsonObject = null;
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(jsonString);
            jsonObject = (JSONObject) obj;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    // Generating JSON strings
    public static String generateJsonString(JSONObject jsonObject) {
        return jsonObject.toJSONString();
    }

    // Reading values from JSON objects
    public static Object getValueFromJsonObject(JSONObject jsonObject, String key) {
        return jsonObject.get(key);
    }

    // Reading values from JSON arrays
    public static Object getValueFromJsonArray(JSONArray jsonArray, int index) {
        return jsonArray.get(index);
    }

    // Adding values to JSON objects
    public static void addValueToJsonObject(JSONObject jsonObject, String key, Object value) {
        jsonObject.put(key, value);
    }

    // Adding values to JSON arrays
    public static void addValueToJsonArray(JSONArray jsonArray, Object value) {
        jsonArray.add(value);
    }

    // Removing values from JSON objects
    public static void removeValueFromJsonObject(JSONObject jsonObject, String key) {
        jsonObject.remove(key);
    }

    // Removing values from JSON arrays
    public static void removeValueFromJsonArray(JSONArray jsonArray, int index) {
        jsonArray.remove(index);
    }
}
