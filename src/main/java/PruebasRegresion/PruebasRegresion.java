package PruebasRegresion;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.logging.Logger;

public class PruebasRegresion extends BasePage {
    Logger logger = Logger.getLogger(PruebasRegresion.class.getName());
    By emailInput = By.id("ap_email");
    By continueButton = By.id("continue");
    By passwordInput = By.id("ap_password");
    By loginSubmitButton = By.id("signInSubmit");
    By logoutBtn = FindElementByXpath("//*[@id=\"nav-item-signout\"]");

    public PruebasRegresion(WebDriver driver) {
        super(driver);
    }

    /*
    Esta funcion prueba la persistencia de una sesión al dar click al botón logout
     */
    public void ValidateSession() throws InterruptedException {
        logger.info("Iniciando prueba de regresesion");
        HoverElement("nav-link-accountList");
        Click(logoutBtn);
        Thread.sleep(1500);
        getDriver().navigate().back();
        Thread.sleep(1500);
        getDriver().navigate().refresh();
        Thread.sleep(1500);
        logger.info("Existe el elemento singin : " + CheckElementExistsById("nav-flyout-ya-signin"));

        Assert.assertTrue(CheckElementExistsById("nav-flyout-ya-signin"));
    }

    /*
     Esta prueba valida la funcionalidad e integridad del inicio de sesión despúes de cerrar sesión
     */
    public void ValidateLoginFunctionality(String email, String password) throws InterruptedException {
        logger.info("Iniciando prueba de regresesion");
        HoverElement("nav-link-accountList");
        Click(logoutBtn);
        Thread.sleep(1500);
        SendKeys(emailInput, email);
        Click(continueButton);
        SendKeys(passwordInput, password);
        Click(loginSubmitButton);
        logger.info("Existe el elemento hello ? : " + CheckElementExistsById("nav-link-accountList-nav-line-1"));

        Assert.assertTrue(CheckElementExistsById("nav-link-accountList-nav-line-1"));
    }
}
