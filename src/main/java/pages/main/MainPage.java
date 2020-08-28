package pages.main;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    protected WebDriver driver;

    @FindBy(xpath = "//div[contains(text(), 'Маркет')]")
    WebElement marketButton;

    @Step("Нажать кнопку \"Маркет\"")
    public MainPage clickMarketButton() {
        marketButton.click();
        return this;
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
