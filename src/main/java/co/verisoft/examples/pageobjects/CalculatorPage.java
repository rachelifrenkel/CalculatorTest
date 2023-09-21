package co.verisoft.examples.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorPage extends BasePage {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10));

    By add = By.id("op_add");

    By result = By.id("result");

    public CalculatorPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickOnDigit(int number) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("digit_" + number))).click();
    }

    public void clickOnPlus() {
        wait.until(ExpectedConditions.elementToBeClickable(add)).click();
    }

    public String getResult() {
        return wait.until(ExpectedConditions.elementToBeClickable(result)).getText();
    }
}
