package co.verisoft.examples.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class DriverManager {
    PropertiesService propertiesService = new PropertiesService();
    Properties mobileCapability = propertiesService.getProperty("src/test/resources/mobileCapability.properties");
    String platformName = mobileCapability.getProperty("PLATFORM_NAME");
    String platformVersion = mobileCapability.getProperty("PLATFORM_VERSION");
    String deviceName = mobileCapability.getProperty("DEVICE_NAME");
    Properties androidMobileCapability = propertiesService.getProperty("src/test/resources/androidMobileCapability.properties");
    String appActivity = androidMobileCapability.getProperty("APP_ACTIVITY");
    String appPackage = androidMobileCapability.getProperty("APP_PACKAGE");
    String url = propertiesService.getProperty("src/test/resources/appiumServer.properties").getProperty("URL");

    public AppiumDriver driverInit() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,platformName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
        URL appiumServerURL = new URL(url);
        return new AndroidDriver(appiumServerURL, capabilities);
    }

}
