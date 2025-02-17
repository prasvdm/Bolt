package com.googlemaps.app;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.googlemaps.appframe.BaseTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppiumSetupTest extends BaseTest {
	
	public static AppiumDriver<MobileElement> driver;

	public static DesiredCapabilities caps = new DesiredCapabilities();

	public static AppiumDriver<MobileElement> setDriver() throws MalformedURLException{
		androidSetup();
		return driver;
	}


	public static AppiumDriver<MobileElement> androidSetup() throws MalformedURLException {

		caps.setCapability("appPackage","com.google.android.apps.maps" );
		caps.setCapability("appActivity", "com.google.android.maps.MapsActivity");
		caps.setCapability("deviceName","ce0cde3f");
		caps.setCapability("automationName", "UIAutomator2");
		caps.setCapability("eventTimings", true);
		caps.setCapability("clearSystemFiles",true);
		caps.setCapability("adbExecTimeout", 600000);
		caps.setCapability("noSign", true);
		caps.setCapability("noReset", true);
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		return driver;
	}

	@Test
	public void run() throws MalformedURLException {
		AppiumDriver<MobileElement> driver1;
		driver1 = setDriver();
		driver1.launchApp();

	}

}
