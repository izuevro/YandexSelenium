package steps;

import common.CommonActions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Attachment;

import static common.Config.isHoldBrowserOpen;

public class BaseSteps {

    protected static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public static void setUp() {
        driver = CommonActions.createDriver();
    }

    @After
    public static void close() {
        if (!isHoldBrowserOpen()) {
            driver.close();
        }
    }
}
