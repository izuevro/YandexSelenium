package base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import pages.base.BasePage;

import pages.main.MainPage;
import pages.market.MarketCatalogPage;
import pages.market.MarketCategoryPage;
import pages.market.MarketMainPage;


import static common.CommonActions.createDriver;
import static common.Config.*;

@Execution(ExecutionMode.CONCURRENT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected WebDriver driver = createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected MainPage mainPage = new MainPage(driver);
    protected MarketMainPage marketPage = new MarketMainPage(driver);
    protected MarketCatalogPage marketCatalogPage = new MarketCatalogPage(driver);
    protected MarketCategoryPage marketCategoryPage = new MarketCategoryPage(driver);

    @AfterEach
    void clearCookiesAndLocalStorage() {
        if (isClearCookies()) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterAll
    void close() {
        if (!isHoldBrowserOpen()) {
            driver.close();
        }
    }
}
