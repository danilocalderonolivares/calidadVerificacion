package PruebasFuncionales;

import Base.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestPruebasFuncionales extends BaseTest {

    @Test(priority = 1)
    @Parameters({"email", "password"})
    public void ChangeLanguageToGerman(String email, String password) throws InterruptedException {
        pruebasHumo.Login(email, password);
        pruebasFuncionales.ChangeLanguage("Alle", "nav-search-label-id", "//span[contains(text(),'Deutsch - DE')]");
    }

    @Test(priority = 2)
    public void ChangeLanguageToSpanish() {
        pruebasFuncionales.ChangeLanguage("Todos", "nav-search-label-id", "//span[contains(text(),'Español - ES')]");
    }

    @Test(priority = 3)
    public void CheckOrdersSpanish() throws InterruptedException {
        pruebasFuncionales.CheckOrders("Tus pedidos", "#yourOrdersContent > div.a-row > div:nth-child(1) > h1");
    }

    @Test(priority = 4)
    @Parameters({"URL"})
    public void CheckOrdersEnglish(String URL) throws InterruptedException {
        basePage.SetDefaultLanguage();
        pruebasFuncionales.CheckOrders("Your Orders", "#yourOrdersContent > div.a-row > div:nth-child(1) > h1");
        basePage.Logout();
        driver.navigate().to(URL);
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void AddItemToCart() throws InterruptedException {
        pruebasFuncionales.AddItemToCart("SSD DRIVE", "1", "//img[contains(@class, 's-image')][1]", "nav-cart-count");
    }

    @Test(priority = 6)
    public void AddAnotherItemToCart() throws InterruptedException {
        pruebasFuncionales.AddItemToCart("USB", "2", "//img[contains(@class, 's-image')][1]", "nav-cart-count");
    }
}
