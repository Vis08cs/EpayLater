package com.EpayLater.pages;

import org.apache.xerces.impl.xpath.XPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epaylater.keywords.Keywords;

public class Home extends Keywords {
	@FindBy(xpath="//a[@class='r-btn r-btn-xl r-btn-blue ng-scope']")
	WebElement start_new_credit_application;
	@FindBy(xpath="//*[@id='LoanAmountInput']")
	WebElement loanAmount;
	@FindBy(xpath=".//*[@id='scannedCopy']")
	WebElement selectbox;
	@FindBy(xpath="//*[@id='continueButton']")
	WebElement continue_button;
	@FindBy(xpath="//h1[@class='page_heading']")
	WebElement Home_page;
	
	WebDriver driver;
	public Home(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 101);
		action = new Actions(driver);
		PageFactory.initElements(driver, this);
		//Report.reporter(false, "Header elements initialised", true);
	}
	public String Home_page_()
	{
		String text=Home_page.getText();
			
		return text;
	}
	public void StartNewApplicationAnd_FillingDetails(String amount) throws InterruptedException{
		start_new_credit_application.click();
		Thread.sleep(3000);
		loanAmount.sendKeys(amount);
		selectbox.click();
		continue_button.click();
		
	}
	
	

}
