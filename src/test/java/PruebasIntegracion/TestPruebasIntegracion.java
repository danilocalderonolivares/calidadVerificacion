package PruebasIntegracion;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Base.BaseTest;

public class TestPruebasIntegracion extends BaseTest {

    @Parameters({"NameArt"})
    @Test
    public void MethodSetUpFilter(String word) {
        pruebasIntegracion.FilterArticle(word);
    }

    @Test
    public void ChangeCoin() {
        pruebasIntegracion.ChangeCoin();
    }

    @Test
    public void FilterByArticle() {
        pruebasIntegracion.FilterByArticle();
    }
}
