package PruebasUnitarias;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PruebasUnitarias extends BasePage {

    By emailInput = By.id("ap_email");
    By continueButton = By.id("continue");
    By createAccountButton = By.xpath("//*[@id=\"createAccountSubmit\"]");
    By nameInput = By.id("ap_customer_name");
    By mailInput = By.id("ap_email");
    By passInput = By.id("ap_password");
    By passConfInput = By.id("ap_password_check");
    By btnPass = By.xpath("//*[@id=\"continue\"]");
    By loginButton = By.id("nav-link-accountList");

    public PruebasUnitarias(WebDriver driver) {
        super(driver);
    }

    public void LoginFail(String email, String expectedValue, String pathToText) {
        Click(loginButton);
        SendKeys(emailInput, email);
        Click(continueButton);

        String valueToCompare = GetElementTextByXpath(pathToText);
        Assert.assertEquals(valueToCompare, expectedValue);
    }

    public void CreateAccount(String Name, String emailNew, String passwordNew, String passwordConfirm) {
        Click(loginButton);
        Click(createAccountButton);
        SendKeys(nameInput, Name);
        SendKeys(mailInput, emailNew);
        SendKeys(passInput, passwordNew);
        SendKeys(passConfInput, passwordConfirm);
        Click(btnPass);
    }

    public void CreateAccountFail(String Name, String emailNew, String passwordNew, String passwordConfirm) {
        Click(loginButton);
        Click(createAccountButton);
        SendKeys(nameInput, Name);
        SendKeys(mailInput, emailNew);
        SendKeys(passInput, passwordNew);
        SendKeys(passConfInput, passwordConfirm);
        Click(btnPass);
    }
}
