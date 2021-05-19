package screens;

import Base.Base;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;

import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

public class LoginScreen extends Base {







    @Test
    public void afillemailandpass(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElementByAccessibilityId("test-Username").sendKeys("standard_user");
        // driver.findElementByAccessibilityId("test-Password").sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[contains(@text, 'Username')]")).sendKeys("standard_user");
        //driver.findElement(By.xpath("//*[contains(@text, ‘Password')]"));

        //driver.findElementByXPath("//android.widget.EditText[@content-desc=\"test-Username\"]").sendKeys("standard_user");
        driver.findElementByXPath("//android.widget.EditText[@content-desc=\"test-Password\"]").sendKeys("secret_sauce");
        driver.findElementByAccessibilityId("test-LOGIN").click();


    }











}
