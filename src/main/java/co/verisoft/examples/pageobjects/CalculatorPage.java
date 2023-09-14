package co.verisoft.examples.pageobjects;

import co.verisoft.fw.utils.Waits;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatorPage extends BasePage {

    @FindBy(id = "op_add")
    private WebElement add;

    @FindBy(id = "eq")
    private WebElement equal;

    @FindBy(id = "result")
    private WebElement result;

    public CalculatorPage(AppiumDriver driver) {
        super(driver);
    }

    private WebElement getDigitSelectorId(int number) {
        return (WebElement) By.id("digit_" + number);
    }

    public void clickOnDigit(int number) {
        Waits.visibilityOf(driver, 30, getDigitSelectorId(number)).click();
    }

    public void clickOnPlus() {
        Waits.visibilityOf(driver, 30, add).click();
    }

    public void clickOnEquals() {
        Waits.visibilityOf(driver, 30, equal).click();
    }

    public String getResult() {
        return Waits.visibilityOf(driver, 30, result).getText();
    }
}
