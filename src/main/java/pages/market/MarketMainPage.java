package pages.market;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketMainPage {

    protected WebDriver driver;

    @FindBy(xpath = "//span[contains(text(), 'Да, спасибо')]")
    WebElement buttonRegionAgree;

    @FindBy(xpath = "//div[@data-apiary-widget-id='/menu/layout/layout']")
    WebElement listMenu;


    @Step("Нажать кнопку \"Да, спасибо\"")
    public MarketMainPage clickRegionAgreeButton() {
        buttonRegionAgree.click();
        return this;
    }

    @Step("Перейти в меню \"{item}\"")
    public MarketMainPage clickMenuListItem(String item) {
        listMenu.findElement(By.xpath("//span[contains(text(), '" + item + "')]")).click();
        return this;
    }

    public MarketMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
