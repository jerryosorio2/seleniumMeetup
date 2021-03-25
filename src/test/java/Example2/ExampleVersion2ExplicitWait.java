package Example2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExampleVersion2ExplicitWait {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemResource("chromedriver.exe").getPath());
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void testFindByIdAndName() {
        driver.get("http://www.google.com/");
        WebElement searchBox = driver.findElement(By.id("lst-ib")); //Find By Id
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        highlightElement(searchBox);
        searchBox.sendKeys("Selenium Web Driver");
        WebElement searchButton = driver.findElement(By.name("btnK")); //Find By Name
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        highlightElement(searchButton);
        searchButton.submit();
    }

    @Test(priority = 1)
    public void testFindByPartialLinkTextAndClass() {
        WebElement searchResult = driver.findElement(By.partialLinkText("Selenium WebDriver")); //Find By partialLinkText
        wait.until(ExpectedConditions.visibilityOf(searchResult));
        wait.until(ExpectedConditions.elementToBeClickable(searchResult));
        highlightElement(searchResult);
        searchResult.click();
        WebElement downloadButton = driver.findElement(By.className("downloadBox")); //Find By partialLinkText
        wait.until(ExpectedConditions.visibilityOf(downloadButton));
        wait.until(ExpectedConditions.elementToBeClickable(downloadButton));
        highlightElement(downloadButton);
        downloadButton.click();
    }

    @AfterClass
    public void close() {
        driver.quit();
    }

    public void highlightElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow;');", element);
    }

}