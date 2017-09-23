package com.EpayLater.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epaylater.keywords.Keywords;

public class Login extends Keywords {
	@FindBy(xpath=("//*[@id='phoneNumber']"))
	WebElement PhoneNumber;
	@FindBy(id="continueButton")
	WebElement continuebutton;
	@FindBy(xpath="//div[@class='input-group']/input[1]")
	WebElement OTP;
	@FindBy(xpath="//button[@class='r-btn r-btn-xl r-btn-blue']")
	WebElement OTP_Continue;
	
	WebDriver driver;
	
	public Login(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 101);
		action = new Actions(driver);
		PageFactory.initElements(driver, this);
		//Report.reporter(false, "Header elements initialised", true);
	}
	public void EnterPhonenumber(String number)
	{
		wait.until(ExpectedConditions.visibilityOf(PhoneNumber)).sendKeys(number);
		wait.until(ExpectedConditions.visibilityOf(continuebutton)).click();
	}
	public void EnterOTP(String otp)
	{
		wait.until(ExpectedConditions.visibilityOf(OTP)).sendKeys(otp);
		OTP_Continue.click();
	}
	

			
	
	
	

}
