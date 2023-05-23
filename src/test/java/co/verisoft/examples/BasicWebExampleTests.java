/*
 * (C) Copyright 2023 VeriSoft (http://www.verisoft.co)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package co.verisoft.examples;

import co.verisoft.fw.report.observer.Report;
import co.verisoft.fw.selenium.drivers.VerisoftDriver;
import co.verisoft.fw.selenium.drivers.factory.DriverCapabilities;
import co.verisoft.fw.selenium.drivers.factory.DriverUrl;
import co.verisoft.fw.utils.Asserts;
import co.verisoft.examples.pageobjects.WikipediaMainPage;
import co.verisoft.examples.pageobjects.WikipediaResultPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

@Execution(ExecutionMode.CONCURRENT)
public class BasicWebExampleTests extends BaseTest{

    @DriverCapabilities
    private DesiredCapabilities capabilities = new DesiredCapabilities();
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");

        capabilities.setBrowserName("chrome");
        options.merge(capabilities);
    }

    @DriverUrl
    private URL url = new URL("http://65.109.141.131:4444/wd/hub");

    public BasicWebExampleTests() throws MalformedURLException {
    }


    @Test
    @DisplayName("Search Wikipedia test")
    public void searchWikipedia(VerisoftDriver driver) throws InterruptedException {
        driver.get("https://www.wikipedia.org/");
        Thread.sleep(30000);
        driver.findElement(By.id("searchInput")).sendKeys("Test Automation");
        new Actions(driver).sendKeys(Keys.ENTER).build().perform();

        String phraseToAssert = "Test automation";

        // Note!! Verisoft Assert
        Asserts.assertTrue(driver.getTitle().contains(phraseToAssert), "Page should contain the pharase " + phraseToAssert);

        Report.info("Got to this point - We are on the right page");
    }


    @Test
    @DisplayName("Search Wikipedia with Page Objects")
    public void searchWikipediaWithPageObjects(VerisoftDriver driver) throws InterruptedException {

        String phraseToSearch = "Test Automation";

        WikipediaMainPage wikipediaMainPage = new WikipediaMainPage(driver);
        WikipediaResultPage resultPage = wikipediaMainPage.gotoPage().searchForTerm(phraseToSearch);
        Thread.sleep(30000);

        // Note!! Verisoft Assert
        Asserts.assertTrue(resultPage.isOnPage(), "Should be on the result page");
        Report.info("We reaeched the result page");

        Asserts.assertTrue(resultPage.getPageTitle().toLowerCase(Locale.ROOT)
                .contains(phraseToSearch.toLowerCase()), "Title should containt the pharse " + phraseToSearch);

    }


    @Test
    @DisplayName("Search Wikipedia with Page Objects - Failed Test")
    public void searchWikipediaWithPageObjectsFail(VerisoftDriver driver) throws InterruptedException {

        String phraseToSearch = "Test Automation";

        WikipediaMainPage wikipediaMainPage = new WikipediaMainPage(driver);
        WikipediaResultPage resultPage = wikipediaMainPage.gotoPage().searchForTerm(phraseToSearch);
        Thread.sleep(30000);

        // Note!! Verisoft Assert
        Asserts.assertTrue(resultPage.isOnPage(), "Should be on the result page");
        Report.info("We reaeched the result page");

        Asserts.assertFalse(resultPage.getPageTitle().toLowerCase(Locale.ROOT)
                .contains(phraseToSearch.toLowerCase()), "Title should containt the pharse " + phraseToSearch);

    }
}
