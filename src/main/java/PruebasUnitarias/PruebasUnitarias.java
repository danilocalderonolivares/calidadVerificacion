package PruebasUnitarias;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PruebasUnitarias extends BasePage {

    By emailInput = By.id("ap_email");
    By continueButton = By.id("continue");
    By passwordInput = By.id("ap_password");
    By loginSubmitButton = By.id("signInSubmit");
    By options = By.xpath("//*[@id=\"nav-hamburger-menu\"]");
    By exit = By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[26]/a");
    By createAccountButton = By.xpath("//*[@id=\"createAccountSubmit\"]");
    By nameInput = By.id("ap_customer_name");
    By mailInput = By.id("ap_email");
    By passInput = By.id("ap_password");
    By passConfInput = By.id("ap_password_check");
    By btnPass = By.xpath("//*[@id=\"continue\"]");
    By logout = By.xpath(" //*[@id=\"hmenu-content\"]/ul[1]/li[25]/a");
    By loginButton = By.id("nav-link-accountList");

    public PruebasUnitarias(WebDriver driver) {
        super(driver);
    }

    public void LoginFail(String email, String password) {
        Click(loginButton);
        SendKeys(emailInput, email);
        Click(continueButton);
        SendKeys(passwordInput, password);
        Click(loginSubmitButton);
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
}