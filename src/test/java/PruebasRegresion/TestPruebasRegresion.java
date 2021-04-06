package PruebasRegresion;

import Base.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestPruebasRegresion extends BaseTest {

    @Test(priority = 1)
    @Parameters({"email", "password"})
    public void validateSession(String email, String password) throws InterruptedException {
        pruebasHumo.Login(email, password);
        pruebasRegresion.ValidateSession();
    }

    @Test(priority = 2)
    @Parameters({"email", "password"})
    public void validateLogin(String email, String password) throws InterruptedException {
        pruebasHumo.Login(email, password);
        pruebasRegresion.ValidateLoginFunctionality(email, password);
    }
}
