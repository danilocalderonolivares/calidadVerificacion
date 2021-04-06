package PruebasUnitarias;

import Base.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestPruebasUnitarias extends BaseTest {

    @Parameters({"emailFail", "passwordFail"})
    @Test
    public void LoginFail(String email, String password) {
        pruebasUnitarias.LoginFail(email, password);
    }

    @Parameters({"Name", "emailNew", "passwordNew", "passwordConfirm", "URL"})
    @Test
    public void CreateAccount(String Name, String emailNew, String passwordNew, String passwordConfirm, String URL) {
        pruebasUnitarias.CreateAccount(Name, emailNew, passwordNew, passwordConfirm);
        driver.navigate().to(URL);
    }

    @Parameters({"NameFail", "emailNewFail", "passwordNewFail", "passwordConfirmFail", "URL"})
    @Test
    public void CreateAccountFail(String Name, String emailNew, String passwordNew, String passwordConfirm, String URL) {
        pruebasUnitarias.CreateAccountFail(Name, emailNew, passwordNew, passwordConfirm);
        driver.navigate().to(URL);
    }
}
