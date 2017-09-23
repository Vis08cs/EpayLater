package Epaylater;


import java.io.IOException;

import org.apache.http.client.methods.Configurable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.EpayLater.pages.Home;
import com.EpayLater.pages.Login;

public class EpayLater_Testcases extends Epaylater_Suite_Config
{
	@Test(priority=1)
	public static void login_EpayLater() throws InterruptedException, IOException
	{
	
		Login login=new Login(driver);
		String num=configElement.getProperty("phonenumber");
		//System.out.println("NUMBER IS  @@@@@@@@@"+ num);
		login.EnterPhonenumber(num);
		Thread.sleep(3000);
		
		String otp=configElement.getProperty("OTP");
		login.EnterOTP(otp);
		Thread.sleep(3000);
		Home home=new Home(driver);
		String text=home.Home_page_();
		Assert.assertEquals(text, "Welcome to ePayLater");
		takeScreenShot();
		//System.out.println("********"+text);
		
	}
	//@Test(priority=2)
	public void start_new_application() throws InterruptedException
	{
		//login_EpayLater();
		Home home =new Home(driver);
		String amount=configElement.getProperty("LoanAmount");
		home.StartNewApplicationAnd_FillingDetails(amount);
		
		
	}
	
}