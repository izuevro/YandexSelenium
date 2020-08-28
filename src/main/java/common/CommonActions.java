package common;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static common.Config.getBrowserAndPlatform;
import static constants.Constant.TimeoutVariables.getImplicitWait;

public class CommonActions {

    /**
     * Создать драйвер
     */
    public static WebDriver createDriver() {
        WebDriver driver = null;
        switch (getBrowserAndPlatform()) {
            case "CHROME_MAC":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                driver = new ChromeDriver();
                break;
            case "CHROME_WINDOWS":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "MOZILLA_MAC":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
                driver = new FirefoxDriver();
                break;
            default:
                Assertions.fail("Неверное имя браузера: " + getBrowserAndPlatform());
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(getImplicitWait(), TimeUnit.SECONDS);
        return driver;
    }
}
