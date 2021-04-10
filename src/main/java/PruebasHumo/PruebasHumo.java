package PruebasHumo;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PruebasHumo extends BasePage {

    By categoriesMenuButton = By.id("nav-hamburger-menu");
    By categoriesMenuCloseButton = By.cssSelector("#hmenu-canvas-background > div");
    By loginButton = By.id("nav-link-accountList");
    By emailInput = By.id("ap_email");
    By continueButton = By.id("continue");
    By passwordInput = By.id("ap_password");
    By loginSubmitButton = By.id("signInSubmit");

    public PruebasHumo(WebDriver driver) {
        super(driver);
    }

    public void Login(String email, String password, String expectedValue) {
        Click(loginButton);
        SendKeys(emailInput, email);
        Click(continueButton);
        SendKeys(passwordInput, password);
        Click(loginSubmitButton);

        String valueToCompare = GetElementTextById("nav-link-accountList-nav-line-1");
        Assert.assertEquals(valueToCompare, expectedValue);
    }

    public void Login(String email, String password) throws InterruptedException {
        Click(loginButton);
        Thread.sleep(2000);
        SendKeys(emailInput, email);
        Click(continueButton);
        SendKeys(passwordInput, password);
        Click(loginSubmitButton);
    }

    public void LandingPageLoadsHamburgerMenu(String expectedValue, String pathToText) throws InterruptedException {
        Click(categoriesMenuButton);
        Thread.sleep(3000);

        String valueToCompare = GetElementTextByCssSelector(pathToText);
        Assert.assertEquals(valueToCompare, expectedValue);
        Click(categoriesMenuCloseButton);
    }

    public void LandingPageLoadsSearchBar() {
        Assert.assertEquals(true, CheckElementExistsById("twotabsearchtextbox"));
    }

    public void HoverOverMyAccountButtonWorksCorrectly() throws InterruptedException {
        HoverElement("nav-link-accountList");

        Assert.assertEquals(true, CheckElementExistsById("nav_prefetch_yourorders"));
    }

    public void ClickMyAccountButtonWorksCorrectly(String email, String password, String expectedValue) throws InterruptedException {
        Click(loginButton);

        Thread.sleep(3000);
        String valueToCompare = GetElementTextByCssSelector("#a-page > div.a-container > div > div.a-row.a-spacing-base > h1");
        Assert.assertEquals(valueToCompare, expectedValue);
    }
}