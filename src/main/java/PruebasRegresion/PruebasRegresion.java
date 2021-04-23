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
    By logoutButton = FindElementByXpath("//*[@id=\"nav-item-signout\"]");
    By accountButton = FindElementByXpath("//*[@id=\"nav-al-your-account\"]/a[1]/span");
    By orders = FindElementByXpath("//*[@id=\"a-page\"]/div[2]/div/div[2]/div[1]/a");
    By dropdown = FindElementByXpath("//*[@id=\"a-autoid-1-announce\"]/span");
    By dropdownButton = By.id("orderFilter_6");
    By cardButton = FindElementByXpath("//*[@id=\"nav-cart\"]");
    By searchBar = By.id("twotabsearchtextbox");
    By searchButton = By.id("nav-search-submit-button");
    By addToCartButton = By.id("add-to-cart-button");
    By myCartButton = By.id("nav-cart");
    By seeItemInformationButton = By.id("a-autoid-1-announce");
    String deleteButtonXpath = "submit.delete.";
    String idItem;

    public PruebasRegresion(WebDriver driver) {
        super(driver);
    }

    public void ValidateSession() throws InterruptedException {
        HoverElement("nav-link-accountList");
        Click(logoutButton);
        Thread.sleep(1500);
        getDriver().navigate().back();
        Thread.sleep(1500);
        getDriver().navigate().refresh();
        Thread.sleep(1500);

        Assert.assertTrue(CheckElementExistsById("nav-flyout-ya-signin"));
    }

    public void ValidateLoginFunctionality(String email, String password) throws InterruptedException {
        HoverElement("nav-link-accountList");
        Click(this.logoutButton);
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

        Click(this.cardButton);
        Thread.sleep(1500);
        Assert.assertTrue(CheckElementExistsById("deselect-all"));
    }

    public void CheckPersistenceAfterDeleteItem() throws InterruptedException {
        this.idItem = getDriver().findElement(By.xpath("//div[@data-item-count='1']")).getAttribute("data-itemid");
        this.deleteButtonXpath = "//input[@name=" + '\'' + this.deleteButtonXpath + this.idItem + '\'' + "]";
        Click(FindElementByXpath(deleteButtonXpath));
        Thread.sleep(4500);
        getDriver().navigate().refresh();

        Thread.sleep(1500);
        Assert.assertFalse(this.CheckElementExistsByXpath(this.deleteButtonXpath));
    }

    public void SeePurchasesRecord() throws InterruptedException {
        HoverElement("nav-link-accountList");
        Click(this.accountButton);
        Click(this.orders);
        Thread.sleep(1500);
        Click(this.dropdown);
        Thread.sleep(1500);
        Click(this.dropdownButton);

        Assert.assertTrue(CheckElementExistsById("a-autoid-1-announce"));
        Thread.sleep(1500);
    }

    public void SeeItemInformation() throws InterruptedException {
        Click(this.seeItemInformationButton);
        Assert.assertTrue(CheckElementExistsById("a-autoid-0"));
        Thread.sleep(1500);
    }
}
