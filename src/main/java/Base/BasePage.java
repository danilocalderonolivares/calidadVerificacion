package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {

    WebDriver driver;
    Actions hover;
    By changeLanguageButton = By.id("icp-nav-flyout");
    By languageRadioButton;
    By saveChangesButton = By.xpath("//*[@id='icp-btn-save']/span/input");
    By filterName = By.id("twotabsearchtextbox");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        hover = new Actions(driver);
    }

    public void Click(By element) {
        driver.findElement(element).click();
    }

    public void SendKeys(By element, String text) {
        driver.findElement(element).sendKeys(text);
    }

    public void HoverElement(String id) throws InterruptedException {
        WebElement element = FindElementById(id);
        hover.moveToElement(element).perform();
        Thread.sleep(3000);
    }

    public WebElement FindElementById(String id) {
        return driver.findElement(By.id(id));
    }

    public By FindElementByXpath(String xpath) {
        return By.xpath(xpath);
    }

    public String GetElementTextById(String id) {
        return driver.findElement(By.id(id)).getText();
    }

    public String GetElementTextByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath)).getText();
    }

    public String GetElementTextByCssSelector(String selector) {
        return driver.findElement(By.cssSelector(selector)).getText();
    }

    public boolean CheckElementExistsById(String id) {
        return !driver.findElements(By.id(id)).isEmpty();
    }

    public void SetDefaultLanguage() {
        Click(changeLanguageButton);
        languageRadioButton = FindElementByXpath("//span[contains(text(),'English - EN')]");
        Click(languageRadioButton);
        Click(saveChangesButton);
    }
    public  void CleanInputs(){
        driver.findElement(filterName).clear();
    }

}
