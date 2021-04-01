package PruebasHumo;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PruebasHumo extends BasePage {

    By categoriesMenuButton = By.id("nav-hamburger-menu");
    By categoriesMenuCloseButton = By.cssSelector("#hmenu-canvas-background > div");

    public PruebasHumo(WebDriver driver) {
        super(driver);
    }

    public void LandingPageLoadsHamburgerMenu(String expectedValue, String pathToText) throws InterruptedException {
        click(categoriesMenuButton);
        Thread.sleep(3000);

        String valueToCompare = GetElementTextByCssSelector(pathToText);
        Assert.assertEquals(valueToCompare, expectedValue);
        click(categoriesMenuCloseButton);
    }

    public void LandingPageLoadsSearchBar() {
        Assert.assertEquals(false, CheckElementExistsById("twotabsearchtextbox"));
    }

    public void MyAccountButtonWorksCorrectly() {

    }
}