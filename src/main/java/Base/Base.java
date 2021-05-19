package Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Base {

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








    }






}
