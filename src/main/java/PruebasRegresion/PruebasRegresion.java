package PruebasRegresion;

import Base.BasePage;
import model.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class PruebasRegresion extends BasePage {
    By emailInput = By.id("ap_email");
    By continueButton = By.id("continue");
    By passwordInput = By.id("ap_password");
    By loginSubmitButton = By.id("signInSubmit");
    By logoutBtn = FindElementByXpath("//*[@id=\"nav-item-signout\"]");
    By accountBtn = FindElementByXpath("//*[@id=\"nav-al-your-account\"]/a[1]/span");
    By orders = FindElementByXpath("//*[@id=\"a-page\"]/div[2]/div/div[2]/div[1]/a");
    By dropDown = FindElementByXpath("//*[@id=\"a-autoid-1-announce\"]/span");
    By dropDownbtn = By.id("orderFilter_6");
    By cardBtn = FindElementByXpath("//*[@id=\"nav-cart\"]");
    By searchBar = By.id("twotabsearchtextbox");
    By searchButton = By.id("nav-search-submit-button");
    By addToCartButton = By.id("add-to-cart-button");
    By myCartButton = By.id("nav-cart");
    By seeItemInformationbtn = By.id("a-autoid-1-announce");
    By buyAgainBtn = By.id("a-autoid-0");
    String deleteBtnXpath = "submit.delete.";
    String idItem;
    public PruebasRegresion(WebDriver driver) {
        super(driver);
    }

    public void ValidateSession() throws InterruptedException {
        HoverElement("nav-link-accountList");
        Click(logoutBtn);
        Thread.sleep(1500);
        getDriver().navigate().back();
        Thread.sleep(1500);
        getDriver().navigate().refresh();
        Thread.sleep(1500);

        Assert.assertTrue(CheckElementExistsById("nav-flyout-ya-signin"));
    }

    public void ValidateLoginFunctionality(String email, String password) throws InterruptedException {
        HoverElement("nav-link-accountList");
        Click(this.logoutBtn);
        Thread.sleep(1500);
        SendKeys(emailInput, email);
        Click(continueButton);
        SendKeys(passwordInput, password);
        Click(loginSubmitButton);

        Assert.assertTrue(CheckElementExistsById("nav-link-accountList-nav-line-1"));
    }

    public void CheckAllItems(List<Item> itemList) throws InterruptedException {
        for (Item item : itemList) {
            SendKeys(searchBar, item.getItemName());
            Click(searchButton);
            Thread.sleep(1500);
            By firstItem = By.xpath(item.getItemXpath());
            Click(firstItem);
            Click(addToCartButton);
            Click(myCartButton);
        }

        Click(this.cardBtn);
        Thread.sleep(1500);

        Assert.assertTrue(CheckElementExistsById("deselect-all"));
    }

    public void CheckPersistenceAfterDeleteItem() throws InterruptedException {
        this.idItem = getDriver().findElement(By.xpath("//div[@data-item-count='1']")).getAttribute("data-itemid");
        this.deleteBtnXpath = "//input[@name=" + '\'' + this.deleteBtnXpath + this.idItem + '\'' + "]";
        Click(FindElementByXpath(deleteBtnXpath));
        Thread.sleep(4500);
        getDriver().navigate().refresh();
        Thread.sleep(1500);
        Assert.assertFalse(this.CheckElementExistsByXpath(this.deleteBtnXpath));
    }
    public void seePurchasesRecord() throws InterruptedException {
        HoverElement("nav-link-accountList");
        Click(this.accountBtn);
        Click(this.orders);
        Thread.sleep(1500);
        Click(this.dropDown);
        Thread.sleep(1500);
        Click(this.dropDownbtn);
        Assert.assertTrue(CheckElementExistsById("a-autoid-1-announce"));
        Thread.sleep(1500);
    }
    public void seeItemInformation() throws InterruptedException {
        Click(this.seeItemInformationbtn);
        Assert.assertTrue(CheckElementExistsById("a-autoid-0"));
        Thread.sleep(1500);

    }
}
