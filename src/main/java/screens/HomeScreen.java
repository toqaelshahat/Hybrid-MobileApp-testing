package screens;

import Base.Base;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.Test;

public class HomeScreen  {
    AndroidDriver<AndroidElement> driver;
    public HomeScreen(AndroidDriver driver){
        this.driver=driver;

    }

    public cartscreen gotocart(){
        driver.findElementByAccessibilityId("").click();
        return new cartscreen(driver);
    }















}
