package pages.market;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarketCatalogPage {

    protected WebDriver driver;

    @FindBy(xpath = "//div[@data-zone-name='search-filter']")
    WebElement blockSearchFilter;

    @FindBy(css = "#glpricefrom")
    WebElement inputPriceFrom;

    @FindBy(xpath = "//legend[contains(text(), 'Производитель')]")
    WebElement blockManufacturer;

    @FindBy(xpath = "//div[@data-zone-name='snippetList']")
    WebElement blockResults;

    @FindBy(xpath = "//h3[@data-zone-name='title']")
    WebElement titleElement;

    @FindBy(css = "#header-search")
    WebElement inputHeaderSearch;

    String textTitleElement;

    @Step("Проверить доступность фильтра поиска")
    public MarketCatalogPage checkSearchFilterVisible() {
        blockSearchFilter.isEnabled();
        return this;
    }

    @Step("Ввести сумму от \"{item}\"")
    public MarketCatalogPage setValueInToInputPriceFrom(String item) {
        inputPriceFrom.clear();
        inputPriceFrom.sendKeys(item);
        driver.navigate().refresh();
        return this;
    }

    @Step("Выбрать производителя \"{item}\"")
    public MarketCatalogPage selectManufacturerCheckbox(String item) {
        blockManufacturer.findElement(By.xpath("//input[@name='Производитель " + item + "']/..")).click();
        driver.navigate().refresh();
        return this;
    }

    @Step("Проверить количество товаров на странице равным \"{item}\"")
    public MarketCatalogPage checkNumberOfElementsOnPage(int item) {
        List<WebElement> list = blockResults.findElements(By.xpath("//article[@data-zone-name='snippet-card']"));
        assertEquals(item, list.size());
        return this;
    }

    @Step("Наименование первого товара'")
    public String getTextOfFirstBlockElement() {
        textTitleElement = titleElement.getText();
        return textTitleElement;
    }

    @Step("Ввести в поисковую строку наименование первого товара")
    public MarketCatalogPage inputTitleElementInHeaderSearch() {
        inputHeaderSearch.clear();
        inputHeaderSearch.sendKeys(getTextOfFirstBlockElement());
        inputHeaderSearch.submit();
        return this;
    }

    @Step("Проверить соответствие наименования первого товара с запросом при поиске")
    public MarketCatalogPage checkTitleOfElement() {
        assertEquals(textTitleElement, titleElement.getText());
        return this;
    }

    public MarketCatalogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
