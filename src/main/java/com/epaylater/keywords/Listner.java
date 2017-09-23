package com.epaylater.keywords;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.IExecutionListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listner implements ITestListener,ISuiteListener,IExecutionListener {
	public static int runningTestCaseNumber;
	public static int totalTestCases;
	public static int totalTestCasesPassed;
	public static int totalTestCasesFailed;
	public static int totalTestCasesSkipped;

	public static String getCurrentTime() {

		Date date = new Date();
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		String getTime = df.format(date);
		return getTime;
	}

	public void onExecutionFinish() {
		// TODO Auto-generated method stub
		
	}

	public void onExecutionStart() {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ISuite Suite) {
		// TODO Auto-generated method stub
		System.out.println("Test suite finished at : " + getCurrentTime());
		System.out.println("Total number of test cases executed : "
				+ (totalTestCasesPassed + totalTestCasesFailed + totalTestCasesSkipped));
		System.out.println("Total test cases passed  : " + totalTestCasesPassed);
		System.out.println("Total test cases failed  : " + totalTestCasesFailed);
		System.out.println("Total test cases skipped  : " + totalTestCasesSkipped);
		
	}

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		totalTestCases = suite.getAllMethods().size();
		System.out.println("Test suite started at : " + getCurrentTime());
		System.out.println("Total test cases : " + totalTestCases);
		runningTestCaseNumber = 0;
		totalTestCasesPassed = 0;
		totalTestCasesFailed = 0;
		totalTestCasesSkipped = 0;
		
	}

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName() + " is failed. It failed at time : " + getCurrentTime());

		totalTestCasesFailed++;
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName() + " is skipped. It skipped at : " + getCurrentTime());
		totalTestCasesSkipped++;
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		runningTestCaseNumber++;
		System.out.println("Test case running number is : " + runningTestCaseNumber
				+ " out of total number of test cases : " + totalTestCases);
		System.out.println("Test case running is : " + result.getName() + ", which started at : " + getCurrentTime());
		System.out.println("###################################################################");
		System.out.println("Test results so far as below. ");
		System.out.println("Total test cases passed till now : " + totalTestCasesPassed);
		System.out.println("Total test cases failed till now : " + totalTestCasesFailed);
		System.out.println("Total test cases skipped till now : " + totalTestCasesSkipped);
		System.out.println("###################################################################");
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName() + " is passed. It passed at : " + getCurrentTime());
		totalTestCasesPassed++;
		
	}
	
}
