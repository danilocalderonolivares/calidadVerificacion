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
        pruebasFuncionales.ChangeLanguage("Wunschlisten",
                "#nav-xshop > a:nth-child(7)",
                "//span[contains(text(),'Deutsch - DE')]");

        pruebasFuncionales.ChangeLanguage("Listas",
                "#nav-xshop > a:nth-child(7)",
                "//span[contains(text(),'Español - ES')]");
    }

    @Test(priority = 3)
    public void CheckOrders() {
        pruebasFuncionales.CheckOrders();
    }

    @Test(priority = 3)
    @Parameters({"NameArt"})
    public void methodSetUpFilter(String word) {
        pruebasFuncionales.FilterArticle(word);
    }

    @Test(priority = 4)
    @Parameters({"emailFail", "passwordFail"})
    public void LoginFail(String email, String password) {
        pruebasFuncionales.LoginFail(email, password);
    }

    @Test(priority = 5)
    @Parameters({"Name", "emailNew","passwordNew","passwordConfirm"})
    public void CreateAccount(String Name, String emailNew, String passwordNew , String passwordConfirm ) {
        pruebasFuncionales.CreateAccount( Name,emailNew,passwordNew,passwordConfirm);
    }
}
