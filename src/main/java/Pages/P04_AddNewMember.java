package Pages;

import Utilittes.LogsUtils;
import Utilittes.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class P04_AddNewMember {

    //Locators
    private final By userName = By.cssSelector("[placeholder=\"الاسم\"]");
    private final By phoneNumber = By.cssSelector("[placeholder=\"الموبايل\"]");
    private final By nationalId = By.cssSelector("[placeholder=\"الرقم القومي\"]");
    private final By address = By.cssSelector("[placeholder=\"العنوان\"]");
    private final By notes = By.cssSelector("[placeholder=\"الملاحظات\"]");
    private final By syndicate_id = By.id("syndicate_id");
    private final By SubSyndicate_id = By.id("sub_syndicate_id");
    private final By SubSyndicate_idName = By.xpath("//*[@id=\"sub_syndicate_id\"]/div//li[2]/div");
    private final By syndicate_idNeme = By.xpath("//*[@id=\"syndicate_id\"]/div//li[2]/div");
    private final By nationalityId = By.xpath("//app-members-form/div/div/form//div[1]/div/div[3]/select");
    private final By file_number = By.cssSelector("[placeholder=\"رقم الملف\"]");
    private final By register_number = By.cssSelector("[placeholder=\"رقم القيد\"]");
    private final By end_work_date = By.cssSelector("[formcontrolname=\"end_work_date\"]");
    private final By end_work_id = By.cssSelector("[formcontrolname=\"end_work_id\"]");
    private final By fileDate = By.cssSelector("[formcontrolname=\"filedate\"]");
    private final By dead_member = By.id("dead_member");
    private final By death_date = By.cssSelector("[formcontrolname=\"death_date\"]");
    private final By file_number_wrasa = By.cssSelector("[formcontrolname=\"file_number_wrasa\"]");
    private final By date_file_warasa = By.cssSelector("[formcontrolname=\"date_file_warasa\"]");
    private final By verifyWarasa = By.id("verify_warasa");
    private final By confirmAddMember = By.cssSelector("[type=\"submit\"]");
    private final By successMassage = By.xpath("//*[@id=\"swal2-html-container\"]");

    //variables
    private final WebDriver driver;

    //constructors
    public P04_AddNewMember(WebDriver driver) {
        this.driver = driver;
    }

    //Action
    public P04_AddNewMember enterUserName() {
        Utility.scrollToElement(driver, userName);
        String UserName = Utility.generateName();
        Utility.sendData(driver, userName, UserName);
        return this;
    }

    public P04_AddNewMember enterPhoneNumber() {
        Utility.scrollToElement(driver, phoneNumber);
        String PhoneNumber = Utility.generatePhoneNumber();
        Utility.sendData(driver, phoneNumber, PhoneNumber);
        return this;
    }

    public P04_AddNewMember enterNationalId() {
        Utility.scrollToElement(driver, nationalId);
        String NationalId = Utility.generateNationalIdForAge(60);
        Utility.sendData(driver, nationalId, NationalId);
        return this;
    }

    public P04_AddNewMember enterAddress() {
        Utility.scrollToElement(driver, address);
        String Address = Utility.generateAddress();
        Utility.sendData(driver, address, Address);
        return this;
    }

    public P04_AddNewMember enterNote() {
        Utility.scrollToElement(driver, notes);
        String Note = Utility.generateRandomFullName();
        Utility.sendData(driver, notes, Note);
        return this;
    }

    public P04_AddNewMember enterSyndicate() {
        Utility.scrollToElement(driver, syndicate_id);
        Utility.clickElement(driver, syndicate_id);
        return this;
    }

    public P04_AddNewMember chooseSyndicate() {
        Utility.scrollToElement(driver, syndicate_idNeme);
        Utility.clickElement(driver, syndicate_idNeme);
        return this;
    }

    public P04_AddNewMember enterSubSyndicate() {
        Utility.scrollToElement(driver, SubSyndicate_id);
        Utility.clickElement(driver, SubSyndicate_id);
        return this;
    }

    public P04_AddNewMember chooseSubSyndicate() {
        Utility.scrollToElement(driver, SubSyndicate_idName);
        Utility.clickElement(driver, SubSyndicate_idName);
        return this;
    }

    public P04_AddNewMember enterRegisterNumber() {
        Utility.scrollToElement(driver, register_number);
        String RegisterNumber = Utility.generateIdS();
        Utility.sendData(driver, register_number, RegisterNumber);
        return this;
    }

    public P04_AddNewMember enterFileNumber() {
        Utility.scrollToElement(driver, file_number);
        String FileNumber = Utility.generateIdS();
        Utility.sendData(driver, file_number, FileNumber);
        return this;
    }

    public P04_AddNewMember enterEndWorkId() {
        Utility.clickElement(driver, end_work_id);
        return this;
    }
    public P04_AddNewMember selectEndWorkID() {
        Utility.selectingFromDropDown(driver, end_work_id, " وفاه ");
        return this;
    }

    public P04_AddNewMember enterEnd_work_date() {
        String endWorkDate = Utility.generateDynamicBirthDate(30, 59);
        try {
            Utility.saveData("EndWorkDate", endWorkDate);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LogsUtils.info("the generated EndWorkDate  is =" + endWorkDate);
        Utility.sendData(driver, end_work_date, endWorkDate);
        return this;
    }



    public P04_AddNewMember enterDeathDate() {
        String deathDate = Utility.getData("EndWorkDate");
        LogsUtils.info("the generated deathDate  is =" + deathDate);
        Utility.sendData(driver, death_date, deathDate);
        return this;
    }

    public P04_AddNewMember enterFileDate() {
        Utility.scrollToElement(driver, fileDate);
        String FileDate = Utility.getTimeStamp();
        Utility.sendData(driver, fileDate, FileDate);
        return this;
    }

    public P04_AddNewMember enterDead_member() {
        Utility.clickElement(driver, dead_member);
        return this;
    }

    public P04_AddNewMember enterFile_number_wrasa() {
        String File_number_wrasa = Utility.generateIdS();
        Utility.sendData(driver, file_number_wrasa, File_number_wrasa);
        return this;
    }

    public P04_AddNewMember enterDate_file_Wrasa() {
        String Date_file_warasa = Utility.getTimeStamp();
        Utility.sendData(driver, date_file_warasa, Date_file_warasa);
        return this;
    }

    public P04_AddNewMember enterVerifyWarasa()
    {
        Utility.scrollToElement(driver,verifyWarasa);
        Utility.clickElement(driver,verifyWarasa);
        return this;
    }
    public P04_AddNewMember ConfirmAddingMember()
    {
        Utility.scrollToElement(driver,confirmAddMember);
        Utility.clickElement(driver,confirmAddMember);
        return this;
    }
    public String getSuccessfulMassage()
    {
        String successfulMassage =Utility.getText(driver,successMassage);
        LogsUtils.info("Massage is :"+ successfulMassage);
        return successfulMassage;
    }


    //Assertions
    public boolean assertSuccessfulMassage()
    {
        return  getSuccessfulMassage().equals("تم بنجاح");
    }

}
