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
    public void CheckItemList() throws InterruptedException {
        Item item1 = new Item("Docker", "//img[contains(@class, 's-image')][1]", "nav-cart-count");
        Item item2 = new Item("java", "//img[contains(@class, 's-image')][1]", "nav-cart-count");
        items.add(item1);
        items.add(item2);
        pruebasRegresion.CheckAllItems(items);
    }

    @Test(priority = 4)
    public void DeleteItem() throws InterruptedException {
        pruebasRegresion.CheckPersistenceAfterDeleteItem();
    }

    @Test(priority = 5)
    public void SeeHistory() throws InterruptedException {
        pruebasRegresion.SeePurchasesRecord();
    }

    @Test(priority = 6)
    public void SeeItemInformation() throws InterruptedException {
        pruebasRegresion.SeeItemInformation();
    }
}
