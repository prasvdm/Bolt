package com.googlemaps.appframe;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;



public class DriverManager {
	
	public static AppiumDriver<MobileElement> driver;
	
	public static DesiredCapabilities caps = new DesiredCapabilities();
	
	public static AppiumDriver<MobileElement> setDriver(String OS, String UDID, String appPackage,String appActivity, String URL,String testSuiteName) throws MalformedURLException{
		androidSetup(UDID,appPackage,appActivity,URL);
		return driver;
	}
	
	
	public static AppiumDriver<MobileElement> androidSetup(String UDID, String appPackage, String appActivity, String uRL) throws MalformedURLException {
		
		caps.setCapability("appPackage", appPackage);
		caps.setCapability("appActivity",appActivity);
		caps.setCapability("udid",UDID);
		caps.setCapability("automationName", "UIAutomator2");
		caps.setCapability("clearSystemFiles",true);
		caps.setCapability("adbExecTimeout", 600000);
		caps.setCapability("noReset", true);
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		return driver;
	}
	
	public static AppiumDriver<MobileElement> getDriver() {
		
		return driver;
	}

}


