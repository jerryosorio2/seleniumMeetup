package Example3.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Google {

    WebDriver driver;
    WebDriverWait wait;

    public Google(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    //Mapping web elements
    @FindBy(xpath = "//div[@class='a4bIc']/input")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private WebElement searchButton;

    @FindBy(partialLinkText = "Selenium WebDriver")
    private WebElement searchResult;

    //Actions for page elements

    public void googlePageActions() {
        searchInput();
        clickSearchButton();
        clickSearchResult();
    }

    private void searchInput() {
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        highlightElement(searchBox);
        searchBox.sendKeys("Selenium Web Driver");

    }

    private void clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        highlightElement(searchButton);
        searchButton.submit();
    }

    private void clickSearchResult() {
        wait.until(ExpectedConditions.visibilityOf(searchResult));
        wait.until(ExpectedConditions.elementToBeClickable(searchResult));
        highlightElement(searchResult);
        searchResult.click();
    }

    public void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow;');", element);
    }
}