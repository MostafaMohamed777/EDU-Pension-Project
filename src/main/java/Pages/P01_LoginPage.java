package Pages;

import Utilittes.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {


    //Locators
    private final By userName=By.cssSelector("[placeholder=\"اسم المستخدم\"]");
    private final By password=By.cssSelector("[placeholder=\"كلمة المرور\"]");
    private final By loginBtn=By.cssSelector("[type=\"submit\"]");

    //variables
    private WebDriver driver;
    //constructors
    public P01_LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    //Action
    public P01_LoginPage enterUserName(String UserName){
        Utility.sendData(driver,userName,UserName);
        return this;
    }
    public P01_LoginPage enterPassword(String Password){
        Utility.sendData(driver,password,Password);
        return this;
    }
    public P02_HomePage enterLoginBtn()
    {
        Utility.clickElement(driver,loginBtn);
        return new P02_HomePage(driver);
    }
    //Assertions
    public boolean assertHomePage(String expectedValue)
    {
        return   Utility.VerifyUrl(driver,expectedValue);
    }

}
