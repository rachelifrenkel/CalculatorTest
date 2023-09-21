package co.verisoft.examples.calculator;
import co.verisoft.examples.pageobjects.DriverManager;
import io.appium.java_client.AppiumDriver;
import java.net.MalformedURLException;
import org.junit.jupiter.api.AfterAll;


public class BaseTest {

    public static AppiumDriver driver;
    public BaseTest() throws MalformedURLException {
        driver = new DriverManager().driverInit();
    }

    @AfterAll
    public static void afterAll() {
        if (driver != null) {
            driver.quit();
        }
    }
}
