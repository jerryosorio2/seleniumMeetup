package ImprovedPOMStructure.PageActions;

import ImprovedPOMStructure.PageElements.GooglePageElements;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Google extends GooglePageElements {

    WebDriverWait wait;

    public Google(WebDriver driver, WebDriverWait wait) {
        super(driver);
        this.wait = wait;
    }

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