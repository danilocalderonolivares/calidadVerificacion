package PruebasIntegracion;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Base.BaseTest;

public class TestPruebasIntegracion extends BaseTest {

    @Parameters({"NameArt1"})
    @Test
    public void MethodSetUpFilter1(String word) {
        pruebasIntegracion.FilterArticle(word);
    }

    @Parameters({"NameArt2", "URL"})
    @Test
    public void MethodSetUpFilter2(String word, String URL) {
        pruebasIntegracion.FilterArticle(word);
        driver.navigate().to(URL);
    }

    @Test
    @Parameters({"email", "password"})
    public void ChangeCoin() {
        pruebasIntegracion.ChangeCoinLanguage("Alle", "nav-search-label-id", "//span[contains(text(),'Deutsch - DE')]");
    }

    @Test
    public void FilterByArticle() {
        pruebasIntegracion.FilterByArticle();
    }
}