package constants;

public class Constant {

    public static class TimeoutVariables {
        private static final int IMPLICIT_WAIT = 5;
        private static final int EXPLICIT_WAIT = 10;

        public static int getImplicitWait() {
            return IMPLICIT_WAIT;
        }

        public static int getExplicitWait() {
            return EXPLICIT_WAIT;
        }
    }

    public static class Urls {

        private static final String MAIN_URL = "https://yandex.ru/";

        public static String getMainUrl() {
            return MAIN_URL;
        }
    }
}
