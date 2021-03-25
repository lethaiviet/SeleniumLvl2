package driver;

public enum DriverFactory {

    CHROME {
        @Override
        public DriverManager getDriverManager() {
            return new ChromeDriverManager();
        }
    };
//    FIREFOX {
//        @Override
//        public DriverManager getDriverManager() {
//            return new FirefoxDriverManager();
//        }
//    };

    public abstract DriverManager getDriverManager();
}