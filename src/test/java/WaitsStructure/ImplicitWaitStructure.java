package WaitsStructure;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitStructure {

    WebDriver driver;

    @BeforeClass
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemResource("chromedriver.exe").getPath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void testFindByIdAndName() {
        driver.get("http://www.google.com/");
        WebElement searchBox = driver.findElement(By.xpath("//div[@class='a4bIc']/input")); //Find By Xpath
        highlightElement(searchBox);
        searchBox.sendKeys("Selenium Web Driver");
        WebElement searchButton = driver.findElement(By.name("btnK")); //Find By Name
        highlightElement(searchButton);
        searchButton.submit();
    }

    @Test(priority = 1)
    public void testFindByPartialLinkTextAndClass() {
        WebElement searchResult = driver.findElement(By.partialLinkText("Selenium WebDriver")); //Find By partialLinkText
        highlightElement(searchResult);
        searchResult.click();
        WebElement downloadButton = driver.findElement(By.xpath("//a[@class='nav-item'][1]")); //Find By partialLinkText
        highlightElement(downloadButton);
        downloadButton.click();
    }

    @AfterClass
    public void close() {
        driver.quit();
    }

    public void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow;');", element);
    }

}