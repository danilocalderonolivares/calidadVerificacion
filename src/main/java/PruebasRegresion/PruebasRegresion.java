package PruebasRegresion;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PruebasRegresion extends BasePage {
    Logger logger = Logger.getLogger(PruebasRegresion.class.getName());
//    By dropDownLogout = By.id("nav-link-accountList");
   By logoutBtn = FindElementByXpath("//*[@id=\"nav-item-signout\"]");

    public PruebasRegresion(WebDriver driver) {
        super(driver);
    }

    public void validateSession() throws InterruptedException {
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
}
