package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {

    WebDriver driver;
    Actions hover;

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        hover = new Actions(driver);
    }

    public void click(By element)
    {
        driver.findElement(element).click();
    }

    public void sendKeys(By element, String text)
    {
        driver.findElement(element).sendKeys(text);
    }

    public void hover(WebElement element){
        hover.moveToElement(element);
        hover.build();
        hover.perform();
    }

    public WebElement findElementById(String id){
        return driver.findElement(By.id(id));
    }

    public By findElementByXpath(String xpath){
        return By.xpath(xpath);
    }

    public String GetElementTextById(String id){
        return driver.findElement(By.id(id)).getText();
    }

    public String GetElementTextByXpath(String xpath){
        return driver.findElement(By.xpath(xpath)).getText();
    }

    public String GetElementTextByCssSelector(String selector){
        return driver.findElement(By.cssSelector(selector)).getText();
    }
}
