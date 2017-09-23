package Epaylater;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.epaylater.keywords.Keywords;



public class Epaylater_Suite_Config extends Keywords{
	
	public static Properties configElement;
	public static FileInputStream configFileLocation;
	@BeforeSuite
	public static void beforeSuite() throws Exception{
		
		openBrowserAndSite("firefox");
	}
	@BeforeTest
	public static void beforeTest() throws IOException {
		configElement = new Properties();
		configFileLocation=new FileInputStream(System.getProperty("user.dir")+"//src//test//java/Epaylater//config.properties");
		configElement.load(configFileLocation);
		
	}
	@AfterSuite
	public static void afterSuite() throws IOException, InterruptedException{
		endSuite();
	}


}
