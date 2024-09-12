package demo.driver;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

import static demo.Constant.CHROME;
import static demo.Constant.CHROME_HEADLESS;

public class DriverManager {
    private static Map<String, MutableCapabilities> factories;
    public static Driver driver = new Driver();

    public static Driver getDriver() {
        return driver;
    }

    private static void initDefaultFactories() {
        factories = new HashMap<>();
        factories.put(CHROME, new ChromeOptions().setPageLoadStrategy(PageLoadStrategy.EAGER));
        factories.put(CHROME_HEADLESS, new ChromeOptions().setPageLoadStrategy(PageLoadStrategy.EAGER));
    }

    public static void initDriver(String browser) {
        initDefaultFactories();
        switch (browser) {
            case CHROME:
            case CHROME_HEADLESS:
                driver.setWebDriver(new ChromeDriver((ChromeOptions) factories.get(browser)));
        }
    }
}
