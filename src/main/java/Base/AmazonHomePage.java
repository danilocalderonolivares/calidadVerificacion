package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonHomePage extends BasePage{

    By loginButton = By.id("nav-link-accountList");
    By emailInput = By.id("ap_email");
    By continueButton = By.id("continue");
    By passwordInput = By.id("ap_password");
    By loginSubmitButton = By.id("signInSubmit");

    AmazonHomePage(WebDriver driver){
        super(driver);
    }

    public void Login(String email, String password){
        click(loginButton);
        sendKeys(emailInput, email);
        click(continueButton);
        sendKeys(passwordInput, password);
        click(loginSubmitButton);
    }
}
