package PruebasHumo;

import Base.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestPruebasHumo extends BaseTest {

    @Test(priority = 1)
    public void LandingPageLoadsHamburgerMenu() throws InterruptedException {
        pruebasHumo.LandingPageLoadsHamburgerMenu("Digital Content & Devices", "#hmenu-content > ul.hmenu.hmenu-visible > li:nth-child(1) > div");
    }

    @Test(priority = 2)
    public void LandingPageLoadsSearchBar() {
        pruebasHumo.LandingPageLoadsSearchBar();
    }

    @Test(priority = 3)
    @Parameters({"email2", "password2", "URL"})
    public void LoginWorksCorrectly(String email2, String password2, String URL) throws InterruptedException {
        pruebasHumo.Login(email2, password2, "Hello, Danilo");
        basePage.Logout();
        driver.navigate().to(URL);
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    @Parameters({"email", "password"})
    public void LoginWithDifferentAccountWorksCorrectly(String email, String password) throws InterruptedException {
        pruebasHumo.Login(email, password, "Hello, Jose");
    }

    @Test(priority = 5)
    @Parameters({"email", "password"})
    public void ClickMyAccountButtonWorksCorrectly(String email, String password) throws InterruptedException {
        pruebasHumo.ClickMyAccountButtonWorksCorrectly(email, password, "Your Account");
    }

    @Test(priority = 6)
    public void HoverOverMyAccountButtonWorksCorrectly() throws InterruptedException {
        pruebasHumo.HoverOverMyAccountButtonWorksCorrectly();
    }
}
