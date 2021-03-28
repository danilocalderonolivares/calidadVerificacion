package Base;

import PruebasFuncionales.PruebasFuncionales;
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
    public AmazonLandingPage amazonHomePage;
    public PruebasFuncionales pruebasFuncionales;

    @Parameters({"URL"})
    @BeforeClass
    public void TestSetUp(String URL)
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @BeforeMethod
    public void methodLevelSetUp()
    {
        InitializeComponents();
    }

    public void InitializeComponents(){
        amazonHomePage = new AmazonLandingPage(driver);
        pruebasFuncionales = new PruebasFuncionales(driver);
    }

    @AfterClass
    public void teardown()
    {
        driver.quit();
    }
}
