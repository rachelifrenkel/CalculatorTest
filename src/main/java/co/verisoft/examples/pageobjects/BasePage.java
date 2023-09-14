package co.verisoft.examples.pageobjects;

import io.appium.java_client.AppiumDriver;

public abstract class BasePage {

    public final AppiumDriver driver;
    public BasePage(AppiumDriver driver) {
        this.driver = driver;
    }



}
