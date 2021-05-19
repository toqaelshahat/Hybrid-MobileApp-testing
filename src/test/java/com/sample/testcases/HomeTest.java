package com.sample.testcases;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeTest extends BaseTest {



    @Test
    public void adraganddropp() {


        TouchAction action = new TouchAction((MobileDriver)driver);
        AndroidElement draggeditem = (AndroidElement) driver.findElementByAccessibilityId("test-Drag Handle");
        AndroidElement distenationelement = (AndroidElement) driver.findElementByAccessibilityId("test-Cart drop zone");

        System.out.println(distenationelement.getLocation());

        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(draggeditem))).perform();
        action.moveTo(PointOption.point(300, 300)).release().perform();





    }
    @Test
    public void baddtocart(){
       // AndroidElement addtocart= driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[2]");
        AndroidElement addtocart = driver.findElementByAccessibilityId("test-ADD TO CART");
        addtocart.click();
    }

    @Test
    public void cremovefromcart(){
        AndroidElement removefromcart= driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"test-REMOVE\"]");
        removefromcart.click();
    }
    @Test
    public void dswitchviews(){
        AndroidElement toggle = driver.findElementByAccessibilityId("test-Toggle");
        toggle.click();

    }
    @Test
    public void drawaline() throws InterruptedException {
        AndroidElement gotomenue = driver.findElementByAccessibilityId("test-Menu");
        gotomenue.click();
        AndroidElement gotodrawing= driver.findElementByAccessibilityId("test-DRAWING");
        gotodrawing.click();


        TouchAction action = new TouchAction((MobileDriver)driver);
        Thread.sleep(2000);

        action.longPress(PointOption.point(400, 800)).moveTo(PointOption.point(1000, 1000)).
                moveTo(PointOption.point(600,1500)).release().perform();




        // AndroidElement gotomenue= driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView");



        //AndroidElement gotodrawing = driver.findElementByXPath("//android.widget.TextView [@text=\"DRAWING\"]");
        // [@text=‘DRAWING‘]");

       // AndroidElement gotodrawing = driver.findElement(By.xpath("//*[contains(@text, ‘DRAWING’)]"));

        //Actions action = new Actions(driver);





    }




    public void rotate(){

        driver.rotate(new DeviceRotation(10, 10, 10));
    }
}
