package common;

public class Config {
    /**
     * Выбираем драйвер и платформу:
     * CHROME_MAC
     * CHROME_WINDOWS
     * MOZILLA_MAC
     */
    private static final String BROWSER_AND_PLATFORM = "CHROME_MAC";

    public static String getBrowserAndPlatform() {
        return BROWSER_AND_PLATFORM;
    }

    /**
     * Очистка cookie и локального хранилища после каждой итерации
     */
    private static final boolean CLEAR_COOKIES = true;

    public static boolean isClearCookies() {
        return CLEAR_COOKIES;
    }

    /**
     * Оставлять браузер открытым после всех сценариев или тестов
     */
    private static final boolean HOLD_BROWSER_OPEN = true;

    public static boolean isHoldBrowserOpen() {
        return HOLD_BROWSER_OPEN;
    }
}
