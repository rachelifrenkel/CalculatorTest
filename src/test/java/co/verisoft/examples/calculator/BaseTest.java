package co.verisoft.examples.calculator;

import co.verisoft.examples.pageobjects.DriverManager;
import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;

public class BaseTest {

    public final AppiumDriver driver;
    public BaseTest() throws MalformedURLException {
        driver = new DriverManager().driverInit();
    }
}
