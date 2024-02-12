package com.opencart.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1 {
	public static WebDriver driver;

	public static WebDriver getDriver(String browserName) throws Exception {
		
		try {
			switch (browserName.toLowerCase()) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver",
						"D:\\eclipse workspace\\Selenium2\\driver\\chromedriver.exe");
				
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver",
						"D:\\eclipse workspace\\Selenium2\\driver\\geckodriver.exe");
				driver = new FirefoxDriver();
				break;
			default:
				throw new IllegalArgumentException("Invalid browser name: " + browserName);
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			throw new Exception("Failed to initialize WebDriver: " + e.getMessage());
		}
		return driver;
	}

	// window handles
	public static void Windowhandles(WebElement element) {
		String childid = driver.getWindowHandle();
		element.click();
		Set<String> parentid = driver.getWindowHandles();
		String y = null;
		for (String d : parentid) {
			if (!d.equals(childid)) {
				y = d;
			}
		}
		driver.switchTo().window(y);
	}

	// Robot Class Methods

	public static void moveMouseTo(int x, int y) {
		try {
			Robot robot = new Robot();
			robot.mouseMove(x, y);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public static void pressKey(int key) {
		try {
			Robot robot = new Robot();
			robot.keyPress(key);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static void releaseKey(int key) {
		try {
			Robot robot = new Robot();
			robot.keyRelease(key);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static void pressMouse(int buttons) {
		try {
			Robot robot = new Robot();
			robot.mousePress(buttons);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static void releaseMouse(int buttons) {
		try {
			Robot robot = new Robot();
			robot.mouseRelease(buttons);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static void pause(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void scrollMouse(int wheelAmt) {
		try {
			Robot robot = new Robot();
			robot.mouseWheel(wheelAmt);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	// Alerts

	public static void switchToAlert() {
		driver.switchTo().alert();
	}

	public static void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public static void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	public static String getAlertText() {
		return driver.switchTo().alert().getText();
	}

	public static void sendKeysToPromptAlert(String inputText) {
		try {
			Alert promptAlert = driver.switchTo().alert();
			promptAlert.sendKeys(inputText);
			promptAlert.accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Screenshots

	public static void captureScreenshot() {
		try {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
			File destinationFile = new File("path/to/save/screenshot.png");
			FileUtils.copyFile(sourceFile, destinationFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Navigation

	public static void openURL(String url) throws Exception {
		try {
			driver.get(url);
		} catch (Exception e) {
			// Log the exception or handle it as per your application's logging strategy
			e.printStackTrace();
			throw new Exception("Failed to navigate to the URL: " + url);
		}
	}

	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public static void navigateBack() {
		driver.navigate().back();
	}

	public static void navigateForward() {
		driver.navigate().forward();
	}

	public static void refreshPage() {
		driver.navigate().refresh();
		
	}
	// Locators

	public static WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	public static List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}

	// Xpath and CSS Locators

	public static void useXpath(String xpath) {
		// Implementation to use XPath
	}

	public static void useCssSelector(String cssSelector) {
		// Implementation to use CSS Selector
	}

	// Element Interaction

	public static void clickElement(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void enterText(WebElement element, String keysToSend) {
		try {
			element.clear();
			element.sendKeys(keysToSend);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getTextContent(WebElement element) {
		try {
			return element.getText();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public static String getAttributeValue(WebElement element, String attributeName) {
		try {
			return element.getAttribute(attributeName);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public static boolean checkIfEnabled(WebElement element) {
		try {
			return element.isEnabled();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean checkIfSelected(WebElement element) {
		try {
			return element.isSelected();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean checkIfDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// Frames

	public static void switchToFrame(String frame) {
		driver.switchTo().frame(frame);
	}

	public static void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}

	public static void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	// Windows and Tabs

	public static String getCurrentWindowHandle() {
		return driver.getWindowHandle();
	}

	public static Set<String> getAllWindowHandles() {
		return driver.getWindowHandles();
	}

	public static void switchToWindow(String handle) {
		driver.switchTo().window(handle);
	}

	// JavaScript Execution

	public static void scrollPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
	}

	// scroll
	public static void scroll(WebElement elements) {
		try {
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView();", elements);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void executeScript(String script, Object... args) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(script, args);
	}

	// Keyboard Actions

	public static void pressKey(Keys key) {
		try {
			Actions actions = new Actions(driver);
			actions.sendKeys(key).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void holdKeyDown(Keys key) {
		try {
			Actions actions = new Actions(driver);
			actions.keyDown(key).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// current URL
	public static String getCurrentUrl() throws Exception {
		String currentUrl = null;
		try {
			currentUrl = driver.getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("if Url is not present");
		}
		return currentUrl;
	}

	// Mouse Actions

	public static void moveToElement(WebElement element) {
		try {
			Actions actions = new Actions(driver);
			if (checkIfDisplayed(element) && checkIfEnabled(element)) {
				actions.moveToElement(element).build().perform();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendKeysToElement(WebElement element, String keys) {
		try {
			Actions actions = new Actions(driver);
			actions.sendKeys(element, keys).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clickOnElement(WebElement element) {
		try {
			Actions actions = new Actions(driver);
			actions.click(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void rightClickOnElement(WebElement element) {
		try {
			Actions actions = new Actions(driver);
			actions.contextClick(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void doubleClickOnElement(WebElement element) {
		try {
			Actions actions = new Actions(driver);
			actions.doubleClick(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void hoverOverElement(WebElement element) {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clickAndHoldOnElement(WebElement element) {
		try {
			Actions actions = new Actions(driver);
			actions.clickAndHold(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void releaseMouseOnElement(WebElement element) {
		try {
			Actions actions = new Actions(driver);
			actions.release(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void dragAndDrop(WebElement source, WebElement target) {
		try {
			Actions actions = new Actions(driver);
			actions.dragAndDrop(source, target).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void moveToElementByOffset(WebElement element, int xOffset, int yOffset) {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(element, xOffset, yOffset).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void moveToElementAndClickByOffset(WebElement element, int xOffset, int yOffset) {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(element, xOffset, yOffset).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Key Actions

	public static void pressKeyDown(Keys key) {
		try {
			Actions actions = new Actions(driver);
			actions.keyDown(key).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void releaseKeyUp(Keys key) {
		try {
			Actions actions = new Actions(driver);
			actions.keyUp(key).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Waits

	public static void implicitWait(int timeout, TimeUnit timeUnit) {
		try {
			driver.manage().timeouts().implicitlyWait(timeout, timeUnit);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void waitForCondition(ExpectedCondition<?> condition) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Dropdowns

	public static void selectByVisibleText(WebElement element, String text) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void selectByValue(WebElement element, String value) {
		try {
			Select select = new Select(element);
			select.selectByValue(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void selectByIndex(WebElement element, int index) {
		try {
			Select select = new Select(element);
			select.selectByIndex(index);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deselectAllOptions(WebElement element) {
		try {
			Select select = new Select(element);
			select.deselectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<WebElement> getAvailableOptions(WebElement element) {
		try {
			Select select = new Select(element);
			return select.getOptions();
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	// get options
	public static List<WebElement> getoptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;
	}

	public static WebElement getFirstSelectedOption(WebElement element) {
		try {
			Select select = new Select(element);
			return select.getFirstSelectedOption();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Cookies

	public static void addCookie(Cookie cookie) {
		try {
			driver.manage().addCookie(cookie);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Cookie getNamedCookie(String name) {
		try {
			return driver.manage().getCookieNamed(name);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void deleteNamedCookie(String name) {
		try {
			driver.manage().deleteCookieNamed(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteAllCookies() {
		try {
			driver.manage().deleteAllCookies();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// close
	public static void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// quit
	public static void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		pressKey(KeyEvent.VK_DOWN);
	}

}