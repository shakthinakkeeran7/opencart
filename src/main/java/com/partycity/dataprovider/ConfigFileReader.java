package com.partycity.dataprovider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath = "src/test/resources/configuration.properties";

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public void getDriverPath() {
	}

	public void getImplicitlyWait() {

	}

	public String getApplicationUrl() {

		String ApplicationUrl = properties.getProperty("url");

		return ApplicationUrl;

	}

	public String getBrowser() {

		String browserName = properties.getProperty("browserName");

		return browserName;
	}


	public void getEnvironment() {
	}

	public void getBrowserWindowSize() {
	}

	public void getTestDataResourcePath() {
	}

	public String getSheetName(String GetsheetName) {
		String sheetName = properties.getProperty(GetsheetName);

		return sheetName;
	}

}
