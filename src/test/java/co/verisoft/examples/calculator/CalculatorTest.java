package co.verisoft.examples.calculator;

import co.verisoft.examples.pageobjects.CalculatorPage;
import co.verisoft.examples.pageobjects.CalculatorService;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.net.MalformedURLException;

public class CalculatorTest extends BaseTest {

    private final CalculatorPage calculatorPage;
    private final CalculatorService calculatorService;


    public CalculatorTest() throws MalformedURLException {
        calculatorPage = new CalculatorPage(driver);
        calculatorService = new CalculatorService(calculatorPage);
    }


    @AfterAll
    public void afterAll() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Adds two numbers and checks the result")
    public void testCalculator() {
        Assertions.assertEquals(calculatorService.calculatePlus(5,3) , 8,
                "the result is wrong");
    }
}
