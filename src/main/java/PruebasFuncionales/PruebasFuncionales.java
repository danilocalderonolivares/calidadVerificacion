package PruebasFuncionales;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Base.BasePage;
import org.openqa.selenium.WebElement;

public class PruebasFuncionales extends BasePage{

    By changeLanguageButton = By.id("icp-nav-flyout");
    By languageRadioButton = By.xpath("//span[contains(text(),'Español - ES')][1]");

    public PruebasFuncionales(WebDriver driver){
        super(driver);
    }

    public void ChangeLanguage(){
        click(changeLanguageButton);
        click(languageRadioButton);
    }
}
