package com.googlemaps.utils;



import java.io.File;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.googlemaps.appframe.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class Utils extends BaseTest {

	private static ExtentReports extent;

	public ExtentReports createInstance() {

		

		Date d = new Date();
		String fileName = "AutomationReport_" + "_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
		String directory = System.getProperty("user.dir") + "/reports/";
		new File(directory).mkdirs();
		String path = directory + fileName;
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(path);
		htmlReporter.config().setEncoding("uft-8");
		htmlReporter.config().setDocumentTitle("Automation Reports");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
//		extent.setSystemInfo("Organization", org);
//		extent.setSystemInfo("Enviroment", env);
		return extent;
	}

}

