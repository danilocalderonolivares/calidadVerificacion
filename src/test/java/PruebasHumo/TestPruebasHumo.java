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
    @Parameters({"email", "password"})
    public void LoginWorksCorrectly(String email, String password) {
        pruebasFuncionales.Login(email, password);
        //Meter un escenario extra con la otra cuenta de login
    }

    @Test(priority = 4)
    public void MyAccountButtonWorksCorrectly() {
        pruebasHumo.MyAccountButtonWorksCorrectly();
    }
}
