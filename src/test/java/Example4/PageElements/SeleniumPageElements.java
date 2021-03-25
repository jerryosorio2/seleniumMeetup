package Example4.PageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPageElements {

    protected WebDriver driver;

    public SeleniumPageElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Mapping web elements
    @FindBy(xpath = "//a[@class='nav-item'][1]")
    protected WebElement downloadButton;

}
