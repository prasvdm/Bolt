package com.googlemaps.utils;



import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class TestListeners implements ITestListener {

	private static ExtentReports extent = new Utils().createInstance();
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getTestClass().getName() + " :: " + 
															result.getMethod().getMethodName());
		extentTest.set(test);
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		String logText = "<b>Test Method "+ result.getMethod().getMethodName() + " Successfull</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		extentTest.get().log(Status.PASS,m);
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		String logText = "<b>Test Method "+ result.getMethod().getMethodName() + " SKIP</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		extentTest.get().log(Status.SKIP,m);
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String exceptionTrace = Arrays.toString(result.getThrowable().getStackTrace());
		String exceptionMessage = result.getThrowable().getMessage();
		
		extentTest.get().fail("<details><summary><b><font color=red>" + 
						"Exception Occured, click to see details:" + "</font></b></summary>" + 
						exceptionMessage + "<br>" +
						exceptionTrace.replaceAll(",", "<br>") + "</details> \n");
		String logText = "<b>Test Method "+ methodName + " Failed</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		extentTest.get().log(Status.FAIL,m);
	}
	
	@Override
	public void onFinish(ITestContext context) {
		if(extent!=null) {
			extent.flush();
		}
	}
}
