package com.partycity.dataprovider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigCSVFileReader {

	public static List<Map<String, String>> readCsv(String filePath) throws IOException {
		List<Map<String, String>> data = new ArrayList<Map<String, String>>();
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		String[] headers = null;

		try {
			br = new BufferedReader(new FileReader(filePath));
			while ((line = br.readLine()) != null) {
				String[] values = line.split(cvsSplitBy);
				if (headers == null) {
					headers = values;
				} else {
					Map<String, String> row = new HashMap<String, String>();
					for (int i = 0; i < headers.length; i++) {
						if (i < values.length) {
							row.put(headers[i], values[i]);
						} else {
							row.put(headers[i], "");
						}
					}
					data.add(row);
				}
			}
		} catch (IOException e) {
			throw e;
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					throw e;
				}
			}
		}
		return data;
	}
}
