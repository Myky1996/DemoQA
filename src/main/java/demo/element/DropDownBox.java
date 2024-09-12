package demo.element;

import demo.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownBox extends BaseElement {
    Select select = null;
    String xpathChildren;

    public DropDownBox(By locator) {
        super(locator);
    }

    public DropDownBox(By locator, String xpathChildren) {
        super(locator);
        this.xpathChildren = xpathChildren;
    }
    public static DropDownBox xpath(String locator) {
        return new DropDownBox(By.xpath(locator));
    }
    public static DropDownBox xpath(String locator, String xpathChildren) {
       return new DropDownBox(By.xpath(locator), xpathChildren);
    }
    public static DropDownBox cssSelector(String locator, String xpathChildren) {
       return new DropDownBox(By.cssSelector(locator), xpathChildren);
    }
    public Select getDropdownElement() {
        select = new Select(DriverManager.getDriver().findElement(locator));
        return select;
    }

    public String selectItem(String name){
        List<WebElement> lstWebElements = DriverManager.getDriver().findElements(By.xpath(xpathChildren));
        String text = "";
        for(WebElement e : lstWebElements){
            text = e.getText();
            if(text.toLowerCase().equals(name.toLowerCase())){
                e.click();
                return text;
            }
        }
        return text;
    }
    public void selectByVisibleText(String name) {
        this.click();
        sleep(1);
        selectItem(name);
    }
}
