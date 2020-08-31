package pages.base;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static constants.Constant.TimeoutVariables.getExplicitWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class BasePage {

    protected WebDriver driver;

    /**
     * Метод для навигации по страницам
     */
    @Step("Перейти по адресу \"{url}\"")
    public void goToUrl(String url) {
        driver.get(url);
    }

    /**
     * Ожидание элемента в DOM
     */
    public WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(driver, getExplicitWait()).until(visibilityOf(element));
        return element;
    }

    /**
     * Ожидание загрузки всех Ajax-запросов
     */
    public void waitForAjaxToFinish() {
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        wait.until((ExpectedCondition<Boolean>) wdriver
                -> ((JavascriptExecutor) driver)
                .executeScript("return jQuery.active == 0").equals(true));
    }

    /**
     * Метод для переключения на новую вкладку
     */
    @Step("Закрыть предыдущую вкладку браузера")
    public void closeOldTab() {
        List<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        driver.close();
        driver.switchTo().window(tabs.get(1));
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
