package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static void getDriver(String browserType) {
		switch (browserType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			break;
		}

	}

	@SuppressWarnings("deprecation")
	public String simpleDateFormat(String date) {
		Date date1 = new Date(date);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		String format = dateFormat.format(date1);
		return format;

	}

	public static String getPropertyFile(String key) throws IOException {
		FileInputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");

		Properties properties = new Properties();
		properties.load(stream);
		Object name = properties.get(key);
		String value = (String) name;
		return value;
	}

	public void navigat(String url) {

		driver.navigate().to(url);
	}

	public void back() {
		driver.navigate().back();
	}

	public static void maximize() {

		driver.manage().window().maximize();
	}

	public static void implicitWait(int duration) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}

	public static void getUrl(String url) {

		driver.get(url);
	}

	public static void Type(WebElement element, String data) {

		element.sendKeys(data);
	}

	public void click(WebElement element) {
		element.click();
	}

	public void clickJavascriptExecutor(WebElement element) {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public String getText(WebElement element) {
		String gettext = element.getText();
		return gettext;
	}

	public Actions contextClick(WebElement element) {
		Actions actions = new Actions(driver);
		Actions contextClick = actions.contextClick(element);
		return contextClick;
	}

	public void scrollDownJs(WebElement element) {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public void screenshot(String fileName) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File file = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(
				"C:\\Users\\nithya\\eclipse-workspace\\MovieInformationValidation\\Screenshots\\" + fileName + ".png");
		FileUtils.copyFile(file, dest);
	}

	public void closeAllWindows() {
		driver.quit();
	}
}
