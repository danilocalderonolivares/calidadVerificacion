package PruebasIntegracion;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PruebasIntegracion extends BasePage {

    By selectBtn = By.xpath("//*[@id=\"a-autoid-0-announce\"]");
    By changeCoin = By.xpath("//*[@id=\"icp-sc-dropdown_63\"]");
    By filterName = By.id("twotabsearchtextbox");
    By btnSearch = By.id("nav-search-submit-button");
    By article = By.xpath("//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[12]/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span");
    By shopCar = By.xpath("//*[@id=\"add-to-cart-button\"]");
    By verifyShopCar = By.xpath("//*[@id=\"nav-cart\"]");
    By btnMenu = By.xpath("//*[@id=\"nav-hamburger-menu\"]/span");
    By optionMenu1 = By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[7]");
    By optionMenu2 = By.xpath("//*[@id=\"hmenu-content\"]/ul[5]/li[4]/a");
    By articleCam = By.xpath("//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[2]/div/span/div/div/div[2]/h2/a/span");
    By addArticle = By.xpath("//*[@id=\"add-to-cart-button\"]");
    By verifyShop = By.xpath("//*[@id=\"nav-cart-text-container\"]/span[2]");
    By saveChangesButton = By.xpath("//*[@id='icp-btn-save']/span/input");
    By changeLanguageButton = By.id("icp-nav-flyout");
    By languageRadioButton;

    public PruebasIntegracion(WebDriver driver) {
        super(driver);
    }

    public void FilterByArticle() throws InterruptedException {
        Click(btnMenu);
        Thread.sleep(2000);
        Click(optionMenu1);
        Thread.sleep(2000);
        Click(optionMenu2);
        Click(articleCam);
        Click(addArticle);
        Click(verifyShop);
    }

    public void ChangeCoinLanguage(String expectedValue, String pathToText, String elementXpath) {
        Click(changeLanguageButton);
        languageRadioButton = FindElementByXpath(elementXpath);
        Click(languageRadioButton);
        Click(selectBtn);
        Click(changeCoin);
        Click(saveChangesButton);

        String valueToCompare = GetElementTextById(pathToText);
        Assert.assertEquals(valueToCompare, expectedValue);
    }

    public void FilterArticle(String word) throws InterruptedException {
        Click(filterName);
        SendKeys(filterName, word);
        Click(btnSearch);
        Click(article);
        Thread.sleep(2000);
        Click(shopCar);
        Click(verifyShopCar);
        CleanInputs("twotabsearchtextbox");
    }
}
