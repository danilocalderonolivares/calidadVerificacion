package PruebasRegresion;

import Base.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestPruebasRegresion extends BaseTest {

//    @Test(priority = 1)
//    @Parameters({"email", "password"})
//    public void validateSession(String email, String password) throws InterruptedException {
//        pruebasHumo.Login(email, password);
//        pruebasRegresion.ValidateSession();
//    }

//    @Test(priority = 2)
//    @Parameters({"email", "password"})
//    public void validateLogin(String email, String password) throws InterruptedException {
//        pruebasHumo.Login(email, password);
//        pruebasRegresion.ValidateLoginFunctionality(email, password);
//    }

    @Test(priority = 1)
    @Parameters({"email", "password"})
    public void checkItemList(String email, String password) throws InterruptedException {
        pruebasHumo.Login(email, password);
        pruebasFuncionales.AddItemToCart("Asus laptop", "1", "//img[contains(@class, 's-image')][1]", "nav-cart-count");
        pruebasFuncionales.AddItemToCart("Iphone", "2", "//img[contains(@class, 's-image')][1]", "nav-cart-count");
        pruebasRegresion.checkAllItems();
    }
}
