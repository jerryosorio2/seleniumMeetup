package Example4.PageActions;

import Example4.PageElements.SeleniumPageElements;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium extends SeleniumPageElements {

    WebDriverWait wait;

    public Selenium(WebDriver driver, WebDriverWait wait) {
        super(driver);
        this.wait = wait;
    }


    public void seleniumPageActions() {
        clickDownloadBox();
    }

    private void clickDownloadBox() {
        wait.until(ExpectedConditions.visibilityOf(downloadButton));
        wait.until(ExpectedConditions.elementToBeClickable(downloadButton));
        highlightElement(downloadButton);
        downloadButton.click();
    }

    public void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow;');", element);
    }
}
