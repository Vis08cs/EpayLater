package com.epaylater.keywords;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Keywords {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Actions action;
	public static String fileWithPath;
	//public static final String browser = System.getProperty("browser");
	//public static final String serverName = System.getProperty("serverName");
	
	public static void launchSite(String browser) throws AWTException, IOException, InterruptedException
	{
		openBrowserAndSite(browser);
	}
	
	public static void endSuite() throws IOException, InterruptedException {
		
			driver.quit();
		
	}
	public boolean isElementPresent(WebElement element, int timeInSeconds) throws TimeoutException {
		WebDriverWait wait1 = new WebDriverWait(driver, timeInSeconds);

		wait1.until(ExpectedConditions.visibilityOf(element));
		return true;
	}
	public static void openBrowserAndSite(String platform) throws AWTException, IOException, InterruptedException {

		if (platform.equalsIgnoreCase("firefox")) {

			//Report.reporter(false, "Browser selected is firefox", true);
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\Downloads\\geckodriver-v0.19.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			Epaylatersite();
			//Report.reporter(false, "Launched firefox", true);
}
	}
	
	public static void Epaylatersite() {
		driver.get("https://automation-test.epaylater.in");
		//Report.reporter(false, "Launching FE", true);
	}
	public  static void takeScreenShot() throws IOException
	{
		 TakesScreenshot scrShot =((TakesScreenshot)driver);
		 File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		 fileWithPath="C://Users//Admin//Documents//1.png";
		 File DestFile=new File(fileWithPath);
		 FileUtils.copyFile(SrcFile, DestFile);
		 
	}
	
	
}
