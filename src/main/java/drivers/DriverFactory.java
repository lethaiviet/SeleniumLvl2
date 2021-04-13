package drivers;

public enum DriverFactory {

    CHROME {
        @Override
        public DriverManager getDriverManager() {
            return new ChromeDriver();
        }
    },
    FIREFOX {
        @Override
        public DriverManager getDriverManager() {
            return new FirefoxDriver();
        }
    };

    public abstract DriverManager getDriverManager();
}