package com.opencart.manager;

import com.opencart.dataprovider.ConfigExcelFileReader;
import com.opencart.dataprovider.ConfigFileReader;

public class FileReaderManager {

	private FileReaderManager() {
		
	}

	
	public static FileReaderManager getInstance() {
	
		FileReaderManager obj = new FileReaderManager();
			return obj;	
		
	}
	
	public ConfigFileReader getCrInstance() throws Throwable {
		ConfigFileReader cr= new 		ConfigFileReader();
		return cr;
	}
	
	public ConfigExcelFileReader getExcelInstance() throws Throwable {
		ConfigExcelFileReader ce= new ConfigExcelFileReader();
		return ce;
	}
	
	
	
}
