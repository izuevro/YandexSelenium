package positive;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static constants.Constant.Urls.getMainUrl;

public class MarketPositiveTest extends BaseTest {

    @Test
    @DisplayName("Проверка результатов поиска в Маркете для телевизоров")
    public void checkSearchResultsByTvOnMarket() {
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
