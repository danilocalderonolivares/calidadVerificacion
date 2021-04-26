package PruebasUnitarias;

import Base.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestPruebasUnitarias extends BaseTest {

    @Parameters({"name", "emailNew", "passwordNew", "passwordConfirm", "URL"})
    @Test(priority = 1)
    public void CreateAccount(String Name, String emailNew, String passwordNew, String passwordConfirm, String URL) {
        pruebasUnitarias.CreateAccount(Name, emailNew, passwordNew, passwordConfirm);
        driver.navigate().to(URL);
    }

    @Parameters({"nameFail", "emailNewFail", "passwordNewFail", "passwordConfirmFail", "URL"})
    @Test(priority = 2)
    public void CreateAccountFail(String Name, String emailNew, String passwordNew, String passwordConfirm, String URL) {
        pruebasUnitarias.CreateAccountFail(Name, emailNew, passwordNew, passwordConfirm);
        driver.navigate().to(URL);
    }

    @Parameters({"emailFail", "loginFailText", "URL"})
    @Test(priority = 3)
    public void LoginFail(String email, String loginFailText, String URL) {
        pruebasUnitarias.LoginFail(email, loginFailText, "//span[@class='a-list-item']");
        driver.navigate().to(URL);
    }

    @Parameters({"invalidEmailFormat", "loginFailText"})
    @Test(priority = 4)
    public void LoginFailWithInvalidEmailFormat(String invalidEmailFormat, String loginFailText) {
        pruebasUnitarias.LoginFail(invalidEmailFormat, loginFailText, "//span[@class='a-list-item']");
    }
}
