package Pages;

import Utilittes.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P03_MemberPage {


    //Locators
    private final By addMemberBtn = By.xpath("//app-members-list//div[2]/a");
    private final By filterBtn = By.xpath("//app-members-list//div[2]/button[1]");

    //variables
    private final WebDriver driver;
    //constructors
    public P03_MemberPage(WebDriver driver) {
        this.driver=driver;
    }
    //Action
    public P04_AddNewMember enterAddNewMember()
    {
        Utility.scrollToElement(driver,addMemberBtn);
        Utility.clickElementJS(driver,addMemberBtn);
        return new P04_AddNewMember(driver);
    }
    public P03_MemberPage enterFilterBtn()
    {
        Utility.scrollToElement(driver,filterBtn);
        Utility.clickElementJS(driver,filterBtn);
        return this;
    }
    //Assertions

}
