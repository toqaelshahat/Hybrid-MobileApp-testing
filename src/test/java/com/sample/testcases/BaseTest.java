package com.sample.testcases;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;
import screens.HomeScreen;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public ExtentReports extents;
    public ExtentTest logger;

    protected HomeScreen homeScreen ;

    DesiredCapabilities cap = new DesiredCapabilities();
    public static AndroidDriver<AndroidElement> driver;


    @BeforeClass
    public void beforeclass() throws MalformedURLException {

        File file = new File("src/test/resources/apps/saucesampleapp.apk");



        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Toqa");

        cap.setCapability("platformName","Android");
        cap.setCapability("autoGrantPermissions",true);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");


        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.swaglabsmobileapp");
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.swaglabsmobileapp.MainActivity");
        driver= new AndroidDriver(url, cap);
        goHome();








    }

    public void goHome(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElementByAccessibilityId("test-Username").sendKeys("standard_user");
        // driver.findElementByAccessibilityId("test-Password").sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[contains(@text, 'Username')]")).sendKeys("standard_user");
        //driver.findElement(By.xpath("//*[contains(@text, ‘Password')]"));

        //driver.findElementByXPath("//android.widget.EditText[@content-desc=\"test-Username\"]").sendKeys("standard_user");
        driver.findElementByXPath("//android.widget.EditText[@content-desc=\"test-Password\"]").sendKeys("secret_sauce");
        driver.findElementByAccessibilityId("test-LOGIN").click();
        homeScreen =new HomeScreen(driver);


    }
    @BeforeSuite
    public void rep(){
        extents= new ExtentReports("Reports/index.html");
        extents.addSystemInfo("Author","Toqa");
        extents.addSystemInfo("version", "second");
        extents.addSystemInfo("Enviornment", "wendiw");
        extents.addSystemInfo("App", "QA cart");


    }
    @AfterSuite
    public void rec(){
        extents.flush();
    }
    @BeforeMethod
    public void beforemethod(Method method){
        logger=extents.startTest(method.getName());

    }

    @AfterMethod
    public void afterMethod(Method method, ITestResult result) throws IOException, Exception {

        Thread.sleep(1000);
        File image = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(image, new File("Screenshots/" + method.getName() + ".png"));

        String imagePath = System.getProperty("user.dir") + File.separator + "Screenshots/" + method.getName() + ".png";

        if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(LogStatus.PASS, "Test passed and no BUGS found.");
            logger.log(LogStatus.PASS, logger.addScreenCapture(imagePath));
        } else if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(LogStatus.FAIL, "Test Failed.");
            logger.log(LogStatus.FAIL, result.getThrowable());
            logger.log(LogStatus.FAIL, logger.addScreenCapture(imagePath));
        } else {
            logger.log(LogStatus.SKIP, "Test Skipped.");
        }
    }






}
