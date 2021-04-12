package WaitsStructure;

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

public class ExplicitWaitStructure {

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
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='a4bIc']/input")));
        highlightElement(searchBox);
        searchBox.sendKeys("Selenium Web Driver");
        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("btnK"))); //Find By Name
        wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        highlightElement(searchButton);
        searchButton.submit();
    }

    @Test(priority = 1)
    public void testFindByPartialLinkTextAndClass() {
        WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Selenium WebDriver"))); //Find By partialLinkText
        wait.until(ExpectedConditions.elementToBeClickable(searchResult));
        highlightElement(searchResult);
        searchResult.click();
        WebElement downloadButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='nav-item'][1]"))); //Find By Xpath
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