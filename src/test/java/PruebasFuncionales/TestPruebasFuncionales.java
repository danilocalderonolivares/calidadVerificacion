package PruebasFuncionales;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Base.BaseTest;

public class TestPruebasFuncionales extends  BaseTest{

/*AL MOMENTO DE PROBAR UN CASO DE MANERA INDEPENDIENTE SE DEBE DE CAMBIAR EL PARAMETRO DE PRIORIDAD Y COMENTAR EL RESTO
* PARA QUE EL SISTEMA NO CORRA EL PROCESO N VECES  */

    @Test(priority = 1)
    @Parameters({"email", "password"})
    public void Login(String email, String password){
      pruebasFuncionales.Login(email, password);
    }
    @Test(priority = 2)
    public void ChangeLanguage(){
      pruebasFuncionales.ChangeLanguage();
    }

    //Test 4 Filtro de busqueda
    @Test(priority = 2)
    @Parameters({"NameArt"})
    public void methodSetUpFilter(String word)
    {
        pruebasFuncionales.FilterArticle(word);
    }

    @Test(priority = 4)
    @Parameters({"emailFail", "passwordFail"})
    public void LoginFail(String email, String password){
      pruebasFuncionales.LoginFail(email, password);
    }

    @Test(priority = 5)
    @Parameters({"Name", "emailNew","passwordNew","passwordConfirm"})
    public void CreateAccount(String Name, String emailNew, String passwordNew , String passwordConfirm )
    {
        pruebasFuncionales.CreateAccount( Name,emailNew,passwordNew,passwordConfirm);
    }






}
