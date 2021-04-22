package PruebasIntegracion;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Base.BaseTest;

public class TestPruebasIntegracion extends BaseTest {


    @Test(priority = 1)
    @Parameters({"email", "password"})
    public void ChangeCoin() {
        pruebasIntegracion.ChangeCoinLanguage("Alle", "nav-search-label-id", "//span[contains(text(),'Deutsch - DE')]");
    }

    @Test(priority = 2)
    public void FilterByArticle() throws InterruptedException {
        pruebasIntegracion.FilterByArticle();
    }
    @Test(priority = 3)
    public void FilterByArticle2() throws InterruptedException {
        pruebasIntegracion.FilterByArticle();
    }
    @Test(priority = 4)
    public void FilterByArticle3() throws InterruptedException {
        pruebasIntegracion.FilterByArticle();
    }
    @Parameters({"NameArt1", "URL"})
    @Test(priority = 5)
    public void MethodSetUpFilter1(String word,  String URL) throws InterruptedException {
        pruebasIntegracion.FilterArticle(word);
        driver.navigate().to(URL);
    }
    @Parameters({"NameArt2", "URL"})
    @Test(priority = 6)
    public void MethodSetUpFilter2(String word, String URL) throws InterruptedException {
        pruebasIntegracion.FilterArticle(word);
    }
    @Parameters({"NameArt3", "URL"})
    @Test(priority = 7)
    public void MethodSetUpFilter3(String word, String URL) throws InterruptedException {
        pruebasIntegracion.FilterArticle(word);
    }
    @Parameters({"NameArt4", "URL"})
    @Test(priority = 8)
    public void MethodSetUpFilter4(String word, String URL) throws InterruptedException {
        pruebasIntegracion.FilterArticle(word);
    }


}