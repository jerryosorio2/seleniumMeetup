package Example1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExampleVersion1 {

    WebDriver driver;

    @BeforeClass
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemResource("chromedriver.exe").getPath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void testFindByIdAndName() throws InterruptedException {
        driver.get("http://www.google.com/");
        Thread.sleep(5000);
        WebElement searchBox = driver.findElement(By.xpath("//div[@class='a4bIc']/input")); //Find By Xpath
        highlightElement(searchBox);
        searchBox.sendKeys("Selenium Web Driver");
        WebElement searchButton = driver.findElement(By.name("btnK")); //Find By Name
        highlightElement(searchButton);
        searchButton.submit();
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void testFindByPartialLinkTextAndClass() throws InterruptedException {
        WebElement searchResult = driver.findElement(By.partialLinkText("Selenium WebDriver")); //Find By partialLinkText
        highlightElement(searchResult);
        searchResult.click();
        Thread.sleep(5000);
        WebElement downloadButton = driver.findElement(By.xpath("//a[@class='nav-item'][1]")); //Find By Xpath
        highlightElement(downloadButton);
        downloadButton.click();
        Thread.sleep(5000);
    }

    @AfterClass
    public void close() {
        driver.close();
    }

    public void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow;');", element);
    }
}