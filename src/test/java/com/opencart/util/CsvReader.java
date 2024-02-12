package com.opencart.util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvReader {
    
    public static List<Map<String, String>> getTestData(String filePath) throws IOException {
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String[] headers = reader.readLine().split(",");
        String line;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            Map<String, String> row = new HashMap<String, String>();
            for (int i = 0; i < headers.length; i++) {
                row.put(headers[i], values[i]);
            }
            data.add(row);
        }
        reader.close();
        return data;
    }
    
   
}
