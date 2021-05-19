package com.sample.testcases;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.HomeScreen;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class FailedTests {




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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[contains(@text, 'Username')]")).sendKeys("problem_user");


       driver.findElementByXPath("//android.widget.EditText[@content-desc=\"test-Password\"]").sendKeys("secret_sauce");
        driver.findElementByAccessibilityId("test-LOGIN").click();



    }




    @Test
    public void checktotal(){
        TouchAction action = new TouchAction((MobileDriver)driver);
        AndroidElement addtocart = driver.findElementByAccessibilityId("test-ADD TO CART");

        addtocart.click();
        action.longPress(PointOption.point(400, 800)).
                moveTo(PointOption.point(400,400)).release().perform();
        action.longPress(PointOption.point(400, 800)).
                moveTo(PointOption.point(400,400)).release().perform();
       // driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Sauce Labs Bolt T-Shirt\"))"));
        driver.findElementByAccessibilityId("test-ADD TO CART").click();
        driver.findElementByAccessibilityId("test-Cart").click();
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"CHECKOUT\"))"));
        driver.findElementByAccessibilityId("test-CHECKOUT").click();
        driver.findElementByAccessibilityId("test-First Name").sendKeys("Toqa");
        driver.findElementByAccessibilityId("test-Last Name").sendKeys("Elshahat");
        driver.findElementByAccessibilityId("test-Zip/Postal Code").sendKeys("123456");
        driver.findElementByAccessibilityId("test-CONTINUE").click();
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"FREE PONY EXPRESS DELIVERY!\"))"));
        String totaltesxt=  driver.findElement(By.xpath("//*[contains(@text, 'Item total')]")).getText();
        Assert.assertEquals(totaltesxt, "Item total: $44");

    }

   /* @Test
    public void checkAddOrRemove(){
        AndroidElement addtocart = driver.findElementByAccessibilityId("test-ADD TO CART");

        addtocart.click();
        AndroidElement ttt= driver.findElementByAccessibilityId("test-Cart");
        System.out.println("the texxttt isss"+ttt.getText());

    }*/


}
