package demo;

import demo.driver.DriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static demo.Constant.FORM_URL;

public class BaseCase {
    @Parameters({"browser"})
    @BeforeTest(alwaysRun = true)
    public void beforeTest(@Optional("chrome") String browser) {
        openBrowser(browser);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(@Optional("chrome") String browser) {
        navigateToFormURL();
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        DriverManager.getDriver().quit();
    }
    protected void openBrowser(String browser) {
        DriverManager.initDriver(browser);
        DriverManager.getDriver().maximize();
    }

    protected void navigateToFormURL() {
        System.out.println(String.format("Navigate to form url: %s", FORM_URL));
        DriverManager.getDriver().get(FORM_URL);
    }
}
