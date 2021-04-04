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

    @Parameters({"Name", "emailNew", "passwordNew", "passwordConfirm"})
    @Test
    public void CreateAccount(String Name, String emailNew, String passwordNew, String passwordConfirm) {
        //pruebasUnitarias.CreateAccount(Name, emailNew, passwordNew, passwordConfirm);
    }
}