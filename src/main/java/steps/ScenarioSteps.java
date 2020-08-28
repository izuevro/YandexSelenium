package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.base.BasePage;
import pages.main.MainPage;
import pages.market.MarketCatalogPage;
import pages.market.MarketCategoryPage;
import pages.market.MarketMainPage;

import static constants.Constant.Urls.getMainUrl;

public class ScenarioSteps {
    protected BasePage basePage = new BasePage(BaseSteps.getDriver());
    protected MainPage mainPage = new MainPage(BaseSteps.getDriver());
    protected MarketMainPage marketPage = new MarketMainPage(BaseSteps.getDriver());
    protected MarketCatalogPage marketCatalogPage = new MarketCatalogPage(BaseSteps.getDriver());
    protected MarketCategoryPage marketCategoryPage = new MarketCategoryPage(BaseSteps.getDriver());

    @When("^перейти на сайт Яндекс$")
    public void stepGoToUrl() {
        basePage.goToUrl(getMainUrl());
    }

    @When("^выбрать Маркет в меню$")
    public void stepClickMarketButton() {
        mainPage.clickMarketButton();
    }

    @When("^закрыть старое окно$")
    public void stepCloseOldTab() {
        basePage.closeOldTab();
    }

    @When("^выбрать регион$")
    public void stepClickRegionAgreeButton() {
        marketPage.clickRegionAgreeButton();
    }

    @When("^выбрать раздел \"(.*)\"$")
    public void stepClickMenuListItem(String item) {
        marketPage.clickMenuListItem(item);
    }

    @When("^выбрать подраздел \"(.*)\"$")
    public void stepClickSubItem(String item) {
        marketCategoryPage.clickSubItem(item);
    }

    @Then("^проверить наличие фильтра$")
    public void stepCheckSearchFilterVisible() {
        marketCatalogPage.checkSearchFilterVisible();
    }

    @When("^ввести сумму от \"(.*)\"$")
    public void stepSetValueInToInputPriceFrom(String item) {
        marketCatalogPage.setValueInToInputPriceFrom(item);
    }

    @When("^выбрать производителя \"(.*)\"$")
    public void stepSelectManufacturerCheckbox(String item) {
        marketCatalogPage.selectManufacturerCheckbox(item);
    }

    @Then("^проверить количество товаров на странице равным \"(.*)\"$")
    public void stepCheckNumberOfElementsOnPage(int item) {
        marketCatalogPage.checkNumberOfElementsOnPage(item);
    }

    @When("^ввести в поисковую строку наименование первого товара$")
    public void stepInputTitleElementInHeaderSearch() {
        marketCatalogPage.inputTitleElementInHeaderSearch();
    }

    @Then("^проверить соответствие наименования первого товара с запросом при поиске$")
    public void stepCheckTitleOfElement() {
        marketCatalogPage.checkTitleOfElement();
    }
}
