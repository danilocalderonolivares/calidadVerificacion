package Base;

import PruebasFuncionales.PruebasFuncionales;
import PruebasHumo.PruebasHumo;
import PruebasIntegracion.PruebasIntegracion;
import PruebasRegresion.PruebasRegresion;
import PruebasUnitarias.PruebasUnitarias;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public PruebasFuncionales pruebasFuncionales;
    public PruebasIntegracion pruebasIntegracion;
    public PruebasUnitarias pruebasUnitarias;
    public PruebasHumo pruebasHumo;
    public PruebasRegresion pruebasRegresion;
    public BasePage basePage;

    @Parameters({"URL"})
    @BeforeClass
    public void TestSetUp(String URL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(URL);
        InitializeComponents();
    }

    @BeforeMethod
    public void methodLevelSetUp() {
    }

    public void InitializeComponents() {
        basePage = new BasePage(driver);
        pruebasFuncionales = new PruebasFuncionales(driver);
        pruebasIntegracion = new PruebasIntegracion(driver);
        pruebasUnitarias = new PruebasUnitarias(driver);
        pruebasHumo = new PruebasHumo(driver);
        pruebasRegresion = new PruebasRegresion(driver);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
