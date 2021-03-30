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
    public void ChangeLanguageToGerman() {
        pruebasFuncionales.ChangeLanguage("Alle", "nav-search-label-id", "//span[contains(text(),'Deutsch - DE')]");
    }

    @Test(priority = 3)
    public void ChangeLanguageToSpanish() {
        pruebasFuncionales.ChangeLanguage("Todos", "nav-search-label-id", "//span[contains(text(),'Español - ES')]");
    }

    @Test(priority = 4)
    public void CheckOrdersSpanish() {
        pruebasFuncionales.CheckOrders("Tus pedidos", "#yourOrdersContent > div.a-row > div:nth-child(1) > h1");
    }

    @Test(priority = 5)
    public void CheckOrdersEnglish() {
        basePage.SetDefaultLanguage();
        pruebasFuncionales.CheckOrders("Your Orders", "#yourOrdersContent > div.a-row > div:nth-child(1) > h1");
    }
}
