package PruebasRegresion;

import Base.BaseTest;
import model.Item;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestPruebasRegresion extends BaseTest {

    public List<Item> items = new ArrayList<>();

    @Test(priority = 1)
    @Parameters({"email", "password"})
    public void ValidateSession(String email, String password) throws InterruptedException {
        pruebasHumo.Login(email, password);
        pruebasRegresion.ValidateSession();
    }

    @Test(priority = 2)
    @Parameters({"email", "password"})
    public void ValidateLogin(String email, String password) throws InterruptedException {
        pruebasHumo.Login(email, password);
        pruebasRegresion.ValidateLoginFunctionality(email, password);
    }

    @Test(priority = 3)
    @Parameters({"email", "password"})
    public void CheckItemList(String email, String password) throws InterruptedException {
        Item item1 = new Item("Asus laptop", "//img[contains(@class, 's-image')][1]", "nav-cart-count");
        Item item2 = new Item("headsets", "//img[contains(@class, 's-image')][1]", "nav-cart-count");
        items.add(item1);
        items.add(item2);
        pruebasRegresion.CheckAllItems(items);
    }

    @Test(priority = 4)
    public void DeleteItem() throws InterruptedException {
        pruebasRegresion.CheckPersistenceAfterDeleteItem();
    }
}
