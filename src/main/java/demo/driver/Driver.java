package demo.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static demo.Constant.DEFAULT_TIMEOUT_30S;

public class Driver implements WebDriver {
    protected WebDriver webDriver;
    protected WebDriverWait driverWait;

    public WebDriver getWebDriver() {
        return webDriver;
    }

    protected void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void get(String url) {
        try {
            webDriver.get(url);
        } catch (TimeoutException ex) {
            System.out.println("Exception: TimeoutException at get URL method on Driver class");
        }
    }

    @Override
    public String getCurrentUrl() {
        try {
            return webDriver.getCurrentUrl();
        } catch (TimeoutException ex) {
            System.out.println("Exception: TimeoutException while getting currentUrl");
            return "";
        }
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        setDriverWaitBySecond(webDriver, DEFAULT_TIMEOUT_30S);
        return driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    @Override
    public WebElement findElement(By by) {
        setDriverWaitBySecond(webDriver, DEFAULT_TIMEOUT_30S);
        return driverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    @Override
    public String getPageSource() {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public void quit() {
        webDriver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return null;
    }

    @Override
    public String getWindowHandle() {
        return null;
    }

    @Override
    public TargetLocator switchTo() {
        return null;
    }

    @Override
    public Navigation navigate() {
        return null;
    }

    @Override
    public Options manage() {
        return null;
    }

    public void maximize() {
        webDriver.manage().window().maximize();
    }

    public void setDriverWaitBySecond(WebDriver driver, long timeout) {
        this.driverWait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public boolean isElementClickAble(By by, int timeout) {
        try {
            setDriverWaitBySecond(webDriver, timeout);
            driverWait.until(ExpectedConditions.elementToBeClickable(by));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }


    public boolean isElementVisible(By by, int timeout) {
        try {
            setDriverWaitBySecond(webDriver, timeout);
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
