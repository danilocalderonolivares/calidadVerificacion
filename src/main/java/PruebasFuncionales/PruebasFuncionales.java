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
    By loginButton = By.id("nav-link-accountList");
    By emailInput = By.id("ap_email");
    By continueButton = By.id("continue");
    By passwordInput = By.id("ap_password");
    By loginSubmitButton = By.id("signInSubmit");

    public PruebasFuncionales(WebDriver driver) {
        super(driver);
    }

    public void Login(String email, String password, String expectedValue) {
        Click(loginButton);
        SendKeys(emailInput, email);
        Click(continueButton);
        SendKeys(passwordInput, password);
        Click(loginSubmitButton);

        String valueToCompare = GetElementTextByCssSelector("#nav-xshop > a:nth-child(8)");
        Assert.assertEquals(valueToCompare, expectedValue);
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
}
