package ImprovedPOMStructure;

import ImprovedPOMStructure.PageActions.Google;
import ImprovedPOMStructure.PageActions.Selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ImprovedPOMStructure {

    WebDriver driver;
    WebDriverWait wait;
    Google google;
    Selenium selenium;

    @BeforeClass
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemResource("chromedriver.exe").getPath());
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        google = new Google(driver, wait);
        selenium = new Selenium(driver, wait);
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void testPOMV2() {
        driver.get("http://www.google.com/");
        google.googlePageActions();
        selenium.seleniumPageActions();
    }

    @AfterClass
    public void close() {
        driver.quit();
    }
}