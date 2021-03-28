package PruebasFuncionales;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PruebasFuncionales extends BasePage{

    By changeLanguageButton = By.id("icp-nav-flyout");
    By languageRadioButton;
    By saveChangesButton = By.xpath("//*[@id='icp-btn-save']/span/input");
    By selectBtn = By.xpath("//*[@id=\"a-autoid-0-announce\"]");
    By changeCoin = By.xpath("//*[@id=\"icp-sc-dropdown_63\"]");
    //Login 1 y 2
    By loginButton = By.id("nav-link-accountList");
    By emailInput = By.id("ap_email");
    By continueButton = By.id("continue");
    By passwordInput = By.id("ap_password");
    By loginSubmitButton = By.id("signInSubmit");
    By options = By.xpath("//*[@id=\"nav-hamburger-menu\"]");
    By exit = By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[26]/a");

    //Test 3 Creacion cuenta
    By CreateAccount_Btn = By.xpath("//*[@id=\"createAccountSubmit\"]");
    By nameInput = By.id("ap_customer_name");
    By mailInput = By.id("ap_email");
    By passInput = By.id("ap_password");
    By passConfInput = By.id("ap_password_check");
    By btnPass = By.xpath("//*[@id=\"continue\"]");
    By logout = By.xpath(" //*[@id=\"hmenu-content\"]/ul[1]/li[25]/a");

    //Test 4 y 6 Filtro
    By filterName = By.id("twotabsearchtextbox");
    By btnserch = By.id("nav-search-submit-button");
    By article = By.xpath("//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[12]/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span");
    By shopCar = By.xpath("//*[@id=\"add-to-cart-button\"]");
    By verifShopCar = By.xpath("//*[@id=\"nav-cart\"]");
    By btnMenu = By.xpath("//*[@id=\"nav-hamburger-menu\"]/span");
    By optionMenu1 = By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[7]/a");
    By optionMenu2 = By.xpath("//*[@id=\"hmenu-content\"]/ul[5]/li[4]/a");
    By articleCam = By.xpath("//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[2]/div/span/div/div/div[2]/h2/a/span");
    By addArticle = By.xpath("//*[@id=\"add-to-cart-button\"]");
    By verifShop = By.xpath("//*[@id=\"nav-cart-text-container\"]/span[2]");

    By myAcoountButton = By.id("nav-link-accountList");
    By myOrdersButton = By.cssSelector("#a-page > div.a-container > div > div:nth-child(2) > div:nth-child(1)");

    public PruebasFuncionales(WebDriver driver){
        super(driver);
    }

    public void ChangeLanguage(String expectedValue, String pathToText, String elementXpath){
        click(changeLanguageButton);
        languageRadioButton = findElementByXpath(elementXpath);
        click(languageRadioButton);
        click(saveChangesButton);

        String valueToCompare = GetElementTextByCssSelector(pathToText);
        Assert.assertEquals(valueToCompare, expectedValue);
    }

    public void CheckOrders(){
        click(myAcoountButton);
        click(myOrdersButton);

        String valueToCompare = GetElementTextByCssSelector("#yourOrdersContent > div.a-row > div:nth-child(1) > h1");
        Assert.assertEquals(valueToCompare, "Tus pedidos");
    }

    //Test 1 Inicio de sesión exitoso
    public void Login(String email, String password){
        click(loginButton);
        sendKeys(emailInput, email);
        click(continueButton);
        sendKeys(passwordInput, password);
        click(loginSubmitButton);
    }
    //Test 2 Inicio de sesión fallido
    public void LoginFail(String email, String password){
        click(options);
        click(exit);
        sendKeys(emailInput, email);
        click(continueButton);
        sendKeys(passwordInput, password);
        click(loginSubmitButton);
    }
    //Test 3 Creacion cuenta
    public void CreateAccount(String Name, String emailNew, String passwordNew , String passwordConfirm){
        click(options);
        click(logout);
        click(CreateAccount_Btn);
        sendKeys(nameInput, Name);
        sendKeys(mailInput, emailNew);
        sendKeys(passInput, passwordNew);
        sendKeys(passConfInput, passwordConfirm);
        click(btnPass);
    }
    //Test 4 Filtro busqueda
    public void FilterArticle(String word){
        click(filterName);
        sendKeys(filterName, word);
        click(btnserch);
        click(article);
        click(shopCar);
        click(verifShopCar);
    }
    //Test 5 Cambio de idioma y moneda en la pagina principal
    public void ChangeCoin(){
        click(changeLanguageButton);
        click(languageRadioButton);
        click(selectBtn);
        click(changeCoin);
        click(saveChangesButton);
    }
    //Test 6 Busqueda por articulos especificos
    public void FilterByArticle(){
        click(btnMenu);
        click(optionMenu1);
        click(optionMenu2);
        click(articleCam);
        click(addArticle);
        click(verifShop);
    }


}
