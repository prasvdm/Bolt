	package com.googlemaps.appframe;



	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Optional;
	import org.testng.annotations.Parameters;

	import io.appium.java_client.AppiumDriver;
	import io.appium.java_client.MobileElement;


	public class BaseTest {

		public static String  device;
		 protected static  Logger log =  LogManager.getLogger(BaseTest.class);
		static public Map<String, String> dataTable = new HashMap<String, String>();
		List<String> propertyFiles = new ArrayList<String>();
		TestDataUtils data;
		static boolean launched ;
		protected static AppiumDriver<MobileElement> driver;


		protected void launchApp() throws IOException, InterruptedException {
			if(!launched) {
				driver.launchApp();

			}

			else {

				launched = false;
			}

		}
		protected void resetApp() {

		driver.resetApp();

		}

		@BeforeTest
	public void dataSetup1() throws IOException, InterruptedException {

			data = new TestDataUtils();
			dataTable = data.initData();
			//propertyFiles
		}
		@BeforeTest(alwaysRun = true)
		@Parameters({ "OS_","UDID_","appPackage_","appActivity","URL_","testsuitename_" })
		public void driverSetup(@Optional("android") String OS,
				@Optional String UDID,@Optional String appPackage,@Optional String appActivity,@Optional String URL,
				@Optional String testSuiteName )throws IOException, InterruptedException {

			System.out.println("BaseTest: Setting driver...");
			try {
			driver=DriverManager.setDriver(OS, UDID,appPackage,appActivity, URL,testSuiteName);
			log.info("Driver launched");
			launched = true;

			}

			catch(Exception e){

				e.printStackTrace();

			}

		}
		@AfterSuite(alwaysRun = true)
		public void terminate() {
			DriverManager.getDriver().quit();
		}

	}

