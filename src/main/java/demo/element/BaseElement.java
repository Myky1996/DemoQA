package demo.element;

import demo.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import static demo.Constant.DEFAULT_TIMEOUT_30S;

public class BaseElement {
    protected WebElement instance = null;
    protected By locator;

    public BaseElement(By locator) {
        this.locator = locator;
    }

    public WebElement getWebElement() {
        instance = DriverManager.getDriver().findElement(locator);
        return instance;
    }

    public static BaseElement xpath(String xpath) {
        return new BaseElement(By.xpath(xpath));
    }

    public static BaseElement cssSelector(String xpath) {
        return new BaseElement(By.cssSelector(xpath));
    }

    public static BaseElement id(String xpath) {
        return new BaseElement(By.id(xpath));
    }

    public void click() {
        DriverManager.getDriver().isElementClickAble(locator, DEFAULT_TIMEOUT_30S);
        getWebElement().click();
    }

    public void clickByJS() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver().getWebDriver();
        js.executeScript("arguments[0].click();", getWebElement());
    }

    public String getText() {
        DriverManager.getDriver().isElementVisible(locator, DEFAULT_TIMEOUT_30S);
        return getWebElement().getText();
    }

    public void clearAndType(String text) {
        DriverManager.getDriver().isElementClickAble(locator, DEFAULT_TIMEOUT_30S);
        this.click();
        int clearTime =0;
        while (clearTime <3){
            this.type(Keys.chord(Keys.CONTROL, "a"));
            this.type(Keys.chord(Keys.CONTROL, Keys.BACK_SPACE));
            clearTime++;
        }
        type(text);
    }
    public void type(String text) {
        DriverManager.getDriver().isElementVisible(locator, DEFAULT_TIMEOUT_30S);
        getWebElement().clear();
        getWebElement().sendKeys(text);
    }
    public void scrollToThisControl(boolean isAlignedToTop) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver().getWebDriver();
        js.executeScript(String.format("arguments[0].scrollIntoView(%s);", isAlignedToTop), this.getWebElement());
    }
    public String getCssValue(String propertyName){
        return getWebElement().getCssValue(propertyName);
    }
    public void sleep(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
