package Example4.PageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePageElements {

    protected WebDriver driver;

    public GooglePageElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Mapping web elements
    @FindBy(id = "lst-ib")
    protected WebElement searchBox;

    @FindBy(name = "btnK")
    protected WebElement searchButton;

    @FindBy(partialLinkText = "Selenium WebDriver")
    protected WebElement searchResult;
}