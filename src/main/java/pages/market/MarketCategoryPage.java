package pages.market;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketCategoryPage {

    protected WebDriver driver;

    @FindBy(xpath = "//div[@data-apiary-widget-name='@MarketNode/NavigationTree']")
    WebElement blockSubItems;

    @Step("Перейти в раздел \"{item}\"")
    public MarketCategoryPage clickSubItem(String item) {
        blockSubItems.findElement(By.xpath("//a[contains(text(), '" + item + "')]")).click();
        return this;
    }

    public MarketCategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
