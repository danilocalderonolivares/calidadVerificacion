package PruebasFuncionales;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PruebasFuncionales extends BasePage {

    By changeLanguageButton = By.id("icp-nav-flyout");
    By languageRadioButton;
    By saveChangesButton = By.xpath("//*[@id='icp-btn-save']/span/input");
    By myAccountButton = By.id("nav-link-accountList");
    By myOrdersButton = By.cssSelector("#a-page > div.a-container > div > div:nth-child(2) > div:nth-child(1)");
    By searchBar = By.id("twotabsearchtextbox");
    By addToCartButton = By.id("add-to-cart-button");
    By myCartButton = By.id("nav-cart");
    By searchButton = By.id("nav-search-submit-button");

    public PruebasFuncionales(WebDriver driver) {
        super(driver);
    }

    public void ChangeLanguage(String expectedValue, String pathToText, String elementXpath) {
        Click(changeLanguageButton);
        languageRadioButton = FindElementByXpath(elementXpath);
        Click(languageRadioButton);
        Click(saveChangesButton);

        String valueToCompare = GetElementTextById(pathToText);
        Assert.assertEquals(valueToCompare, expectedValue);
    }

    public void CheckOrders(String expectedValue, String pathToText) {
        Click(myAccountButton);
        Click(myOrdersButton);

        String valueToCompare = GetElementTextByCssSelector(pathToText);
        Assert.assertEquals(valueToCompare, expectedValue);
    }

    public void AddItemToCart(String itemName, String expectedValue, String itemXpath, String itemPath) throws InterruptedException {
        SendKeys(searchBar, itemName);
        Click(searchButton);
        Thread.sleep(1500);
        By firstItem = By.xpath(itemXpath);
        Click(firstItem);
        Click(addToCartButton);
        Click(myCartButton);

        Thread.sleep(1500);
        String valueToCompare = GetElementTextById(itemPath);
//        Assert.assertEquals(valueToCompare, expectedValue);
    }
}
