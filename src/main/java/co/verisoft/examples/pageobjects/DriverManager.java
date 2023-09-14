package co.verisoft.examples.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    PropertiesService propertiesService = new PropertiesService();
    String platformName = propertiesService.getProperty("mobileCapability.properties").getProperty("PLATFORM_NAME");
    String platformVersion = propertiesService.getProperty("mobileCapability.properties").getProperty("PLATFORM_VERSION");
    String deviceName = propertiesService.getProperty("mobileCapability.properties").getProperty("DEVICE_NAME");
    String appActivity = propertiesService.getProperty("androidMobileCapability.properties").getProperty("APP_ACTIVITY");
    String appPackage = propertiesService.getProperty("androidMobileCapability.properties").getProperty("APP_PACKAGE");
    String url = propertiesService.getProperty("appiumServer.properties").getProperty("URL");

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
