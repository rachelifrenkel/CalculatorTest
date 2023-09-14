package co.verisoft.examples.pageobjects;

public class CalculatorService {
    CalculatorPage calculatePage;
    public CalculatorService(CalculatorPage calculatePage) {
        this.calculatePage = calculatePage;
    }

    public int calculatePlus(int num1, int num2) {
        calculatePage.clickOnDigit(num1);
        calculatePage.clickOnPlus();
        calculatePage.clickOnDigit(num2);
        calculatePage.clickOnEquals();

        String resultText = calculatePage.getResult();
        return Integer.parseInt(resultText);
    }

}
