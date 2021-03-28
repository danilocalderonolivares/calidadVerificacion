package PruebasFuncionales;

import Base.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestPruebasFuncionales extends BaseTest {

    @Test(priority = 1)
    @Parameters({"email", "password"})
    public void Login(String email, String password) {
        pruebasFuncionales.Login(email, password);
    }

    @Test(priority = 2)
    public void ChangeLanguage() {
        pruebasFuncionales.ChangeLanguage("Wunschlisten", "#nav-xshop > a:nth-child(8)", "//span[contains(text(),'Deutsch - DE')]");
        pruebasFuncionales.ChangeLanguage("Listas", "#nav-xshop > a:nth-child(8)", "//span[contains(text(),'Español - ES')]");
    }

    @Test(priority = 3)
    public void CheckOrders() {
        pruebasFuncionales.CheckOrders();
    }
}
