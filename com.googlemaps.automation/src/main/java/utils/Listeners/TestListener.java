//package utils.Listeners;
//
//import java.util.Objects;
//
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.model.Log;
//import com.googlemaps.appframe.BaseTest;
//
//import utils.ExtentManager;
//import utils.ExtentTestManager;
//
//public class TestListener extends BaseTest implements ITestListener {
//	
//    private static String getTestMethodName(ITestResult iTestResult) {
//        return iTestResult.getMethod().getConstructorOrMethod().getName();
//    }
//    public void onStart(ITestContext iTestContext) {
//    	
//        log.info("I am in onStart method " + iTestContext.getName());
//        iTestContext.setAttribute("WebDriver", this.driver);
//    }
//    
//    public void onFinish(ITestContext iTestContext) {
//        log.info("I am in onFinish method " + iTestContext.getName());
//        //Do tier down operations for ExtentReports reporting!
//        ExtentManager.extentReports.flush();
//    }
//   
//    public void onTestStart(ITestResult iTestResult) {
//    	log.info(getTestMethodName(iTestResult) + " test is starting.");
//    }
//    
//    public void onTestSuccess(ITestResult iTestResult) {
//    	log.info(getTestMethodName(iTestResult) + " test is succeed.");
//        //ExtentReports log operation for passed tests.
//    	ExtentTestManager.getTest().log(Status.PASS, "Test passed");
//    }
//    
//    public void onTestFailure(ITestResult iTestResult) {
//    	log.info(getTestMethodName(iTestResult) + " test is failed.");
//        //Get driver from BaseTest and assign to local webdriver variable.
//        Object testClass = iTestResult.getInstance();
//        WebDriver driver = ((BaseTest) testClass).getDriver();
//        //Take base64Screenshot screenshot for extent reports
//        String base64Screenshot =
//            "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
//        //ExtentReports log and screenshot operations for failed tests.
//        ExtentTestManager.getTest().log(Status.FAIL, "Test Failed",
//        		ExtentTestManager.getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
//    }
//   
//    public void onTestSkipped(ITestResult iTestResult) {
//    	log.info(getTestMethodName(iTestResult) + " test is skipped.");
//        //ExtentReports log operation for skipped tests.
//    	ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
//    }
//   
//    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
//    	log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
//    }
//}