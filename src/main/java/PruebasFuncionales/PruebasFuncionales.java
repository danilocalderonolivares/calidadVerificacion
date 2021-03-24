package PruebasFuncionales;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PruebasFuncionales extends BasePage{

    By changeLanguageButton = By.id("icp-nav-flyout");
    By languageRadioButton = By.xpath("//span[contains(text(),'Español - ES')][1]");
    By saveChangesButton = By.xpath("//*[@id='icp-btn-save']/span/input");

    public PruebasFuncionales(WebDriver driver){
        super(driver);
    }

    public void ChangeLanguage(){
        click(changeLanguageButton);
        click(languageRadioButton);
        click(saveChangesButton);

        String valueToCompare = GetElementTextByCssSelector("#nav-xshop > a:nth-child(7)");
        Assert.assertEquals(valueToCompare, "Listas");
    }
}
