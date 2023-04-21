package com.partycity.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.partycity.baseclass.BaseClass;
import com.partycity.runner.TestRunner;

public class UtilFunctions extends BaseClass {

	/*
	 * 1. ExpWaitForWebelement() 2. getExcelData() 3. getCurrentAndReturnDates() 4.
	 * customXpath() 5. scrollToBottom() 6. ScrollToTop() 7. scrollToView() 8.
	 * getScreenshot()
	 * 
	 */
	public static void ExpWaitForWebelement(WebElement element) {
		WebDriverWait expWait = new WebDriverWait(driver, 40);
		expWait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public static By customXpath(String xpath, String param) {
		String rawPath = xpath.replaceAll("%replace%", param);
		return By.xpath(rawPath);
	}

	public static void scrollToBottom() throws InterruptedException {
		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;

		try {
			long currentHeight = Long.parseLong(jsDriver.executeScript("return document.body.scrollHeight").toString());

			while (true) {
				jsDriver.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				Thread.sleep(300);

				long newHeight = Long.parseLong(jsDriver.executeScript("return document.body.scrollHeight").toString());

				if (currentHeight == newHeight)
					break;
				currentHeight = newHeight;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void ScrollToTop() {
		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
		jsDriver.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}

	public static void scrollToView(WebElement element) {
		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
		jsDriver.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	 public static WebDriver getDriver() {
	        if (driver == null) {
	        	
	        	driver = TestRunner.driver;
	            	        }
	        return driver;
	    }
	public static String getScreenshot(String imageName) {

		String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/Screenshots/" + imageName + currentDate + ".png";
		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (IOException e) {
			System.out.println("Failed to capture the screen " + e.getMessage());
		}

		return destination;
	}

	public static boolean isVisble(WebElement element) {
		boolean flag = false;
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		try {
			if (element.isDisplayed()) {
				flag = true;
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return flag;

	}

	
	public static void writeData(String flightName, String deptTime, String duration, String amount, int rowCount)
			throws Throwable {
		File f = new File(System.getProperty("user.dir")
				+ "\\src\\test\\resource\\com\\makemytrip\\flightdetails\\Flight Details.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);

		Sheet sheetAt = wb.getSheet("Flight_Details");
		Row createRow = sheetAt.createRow(rowCount);

		Cell c0 = createRow.createCell(0);
		c0.setCellValue(flightName);
		Cell c1 = createRow.createCell(1);
		c1.setCellValue(deptTime);
		Cell c2 = createRow.createCell(2);
		c2.setCellValue(duration);
		Cell c3 = createRow.createCell(3);
		c3.setCellValue(amount);

		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		wb.close();
	}

}
