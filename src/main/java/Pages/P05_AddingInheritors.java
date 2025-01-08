package Pages;

import Utilittes.LogsUtils;
import Utilittes.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class P05_AddingInheritors {

    //Locators
    private final By memberProfile=By.xpath("//app-inheritors-add//div[2]/a");
    private final By inheritorName=By.cssSelector("[placeholder=\"الاسم\"]");
    private final By nationalId=By.cssSelector("[placeholder=\"الرقم القومي\"]");
    private final By phoneNumber=By.cssSelector("[placeholder=\"الموبايل\"]");
    private final By inheritor_type=By.cssSelector("[formcontrolname=\"inheritor_type\"]");
    private final By address=By.cssSelector("[placeholder=\"العنوان\"]");
    private final By notes=By.cssSelector("[placeholder=\"الملاحظات\"]");
    private final By yasref=By.id("yasref");
    private final By sarf_responsible=By.id("sarf_responsible");
    private final By responsible_id=By.id("id");
    private final By notYasrefReason=By.cssSelector("[formcontrolname=\"not_yasref_reason\"]");
    private final By addInheritor=By.cssSelector("[type=\"submit\"]");
    private final By savaAllInheritors=By.xpath("//app-inheritors-form/div[2]//button");
    private final By successfulMassage=By.xpath("//*[@id=\"swal2-html-container\"]");

    //variables
    private final WebDriver driver;
    //constructors
    public P05_AddingInheritors(WebDriver driver) {
        this.driver=driver;
    }
    //Action
    public P05_AddingInheritors enterInheritorName()
    {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.urlContains("inheritors"));
        Utility.scrollToElement(driver,inheritorName);
        String InheritorName=Utility.generateName();
        Utility.sendData(driver,inheritorName,InheritorName);
        return this;
    }
    public P05_AddingInheritors enterNationalId(int minAge,int maxAge)
    {
        Utility.scrollToElement(driver,nationalId);
        String NationalId =Utility.generateNationalID(minAge,maxAge);
        Utility.sendData(driver,nationalId,NationalId);
        return this;
    }
    public P05_AddingInheritors enterInheritorType(String value)
    {
        Utility.scrollToElement(driver,inheritor_type);
        Utility.clickElement(driver,inheritor_type);
        Utility.selectingFromDropDown(driver,inheritor_type,value);
        return this;
    }
    public P05_AddingInheritors enterAddress()
    {
        Utility.scrollToElement(driver,address);
        String Address =Utility.generateAddress();
        Utility.sendData(driver,address,Address);
        return this;
    }
    public P05_AddingInheritors enterNote()
    {
        Utility.scrollToElement(driver,notes);
        String Notes=Utility.generateRandomFullName();
        Utility.sendData(driver,notes,Notes);
        return this;
    }
    public P05_AddingInheritors enterYasref()
    {
        Utility.scrollToElement(driver,yasref);
        Utility.clickElement(driver,yasref);
        return this;
    }
    public P05_AddingInheritors enterSarf_responsible()
    {
        Utility.scrollToElement(driver,sarf_responsible);
        Utility.clickElement(driver,sarf_responsible);
        return this;
    }
    public P05_AddingInheritors enterResponsible_id(String value)
    {
        Utility.scrollToElement(driver,responsible_id);
        Utility.clickElement(driver,responsible_id);
        Utility.selectingFromDropDownUsingValue(driver,responsible_id,value);
        return this;
    }
    public P05_AddingInheritors enterNotYasrefReason()
    {
        Utility.scrollToElement(driver,notYasrefReason);
        String NotYasrefReason =Utility.generateAddress();
        Utility.sendData(driver,notYasrefReason,NotYasrefReason);
        return this;
    }
    public P05_AddingInheritors enterPhoneNumber()
    {
        Utility.scrollToElement(driver,phoneNumber);
        String PhoneNumber=Utility.generatePhoneNumber();
        Utility.sendData(driver,phoneNumber,PhoneNumber);
        return this;
    }
    public P05_AddingInheritors enterAddInheritors()
    {
        Utility.scrollToElement(driver,addInheritor);
        Utility.clickElement(driver,addInheritor);
        return this;
    }
    public P05_AddingInheritors savingAllInheritors()
    {
        Utility.scrollToElement(driver,savaAllInheritors);
        Utility.clickElement(driver,savaAllInheritors);
        return this;
    }
    public String getSuccessfulMassage()
    {
       String SuccessfulMassage = Utility.getText(driver,successfulMassage);
        LogsUtils.info("Successful Massage IS ="+successfulMassage);
        return SuccessfulMassage;
    }

    //Assertions
    public Boolean assertSuccessfulMassage()
    {
        return getSuccessfulMassage().equals("تمت الاضافه بنجاح");
    }


}
