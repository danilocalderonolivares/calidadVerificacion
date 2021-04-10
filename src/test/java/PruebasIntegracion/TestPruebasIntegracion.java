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

    @Parameters({"NameArt1"})
    @Test(priority = 3)
    public void MethodSetUpFilter1(String word) throws InterruptedException {
        pruebasIntegracion.FilterArticle(word);
    }

    @Parameters({"NameArt2", "URL"})
    @Test(priority = 4)
    public void MethodSetUpFilter2(String word, String URL) throws InterruptedException {
        pruebasIntegracion.FilterArticle(word);
        driver.navigate().to(URL);
    }
}