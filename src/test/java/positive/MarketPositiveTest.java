package positive;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.Constant.TimeoutVariables.getExplicitWait;
import static constants.Constant.Urls.getMainUrl;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class MarketPositiveTest extends BaseTest {

    @Test
    @DisplayName("Проверка результатов поиска в Маркете для телевизоров")
    public void checkSearchResultsByTvOnMarket() {

//        basePage.goToUrl(getMainUrl());
//        WebElement element = driver.findElement(By.xpath("//span[contains(text(), 'Войти в почту')]"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element).click().build().perform();
//        basePage.closeOldTab();
//
//        WebElement login = driver.findElement(By.xpath("//*[@name='login']"));
//        actions.moveToElement(login).click().build().perform();
//        login.sendKeys("");
//        login.submit();
//
//        WebElement pass = driver.findElement(By.xpath("//*[@name='passwd']"));
//        actions.moveToElement(pass).click().build().perform();
//        pass.sendKeys("");
//        pass.submit();

        basePage.goToUrl(getMainUrl());
        mainPage.clickMarketButton();
        basePage.closeOldTab();
        marketPage.clickRegionAgreeButton()
                .clickMenuListItem("Электроника");
        marketCategoryPage.clickSubItem("Телевизоры");
        marketCatalogPage.checkSearchFilterVisible()
                .setValueInToInputPriceFrom("20000")
                .selectManufacturerCheckbox("Samsung")
                .selectManufacturerCheckbox("LG")
                .checkNumberOfElementsOnPage(48)
                .inputTitleElementInHeaderSearch()
                .checkTitleOfElement();
    }

    @Test
    @DisplayName("Проверка результатов поиска в Маркете для наушников")
    public void checkSearchResultsByHeadPhonesOnMarket() {
        basePage.goToUrl(getMainUrl());
        mainPage.clickMarketButton();
        basePage.closeOldTab();
        marketPage.clickRegionAgreeButton()
                .clickMenuListItem("Электроника");
        marketCategoryPage.clickSubItem("Наушники и Bluetooth-гарнитуры");
        marketCatalogPage.checkSearchFilterVisible()
                .setValueInToInputPriceFrom("5000")
                .selectManufacturerCheckbox("Beats")
                .checkNumberOfElementsOnPage(12)
                .inputTitleElementInHeaderSearch()
                .checkTitleOfElement();
    }
}
