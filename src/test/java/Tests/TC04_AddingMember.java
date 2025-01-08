package Tests;

import Pages.P01_LoginPage;
import Pages.P04_AddNewMember;
import Utilittes.DataUtils;
import Utilittes.LogsUtils;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.getDriver;
import static DriverFactory.DriverFactory.setUpBrowser;
import static Utilittes.DataUtils.getPropertyValue;
import Listeners.iInvokedMethodListenersClass;
import Listeners.iTestResultListenersClass;

@Listeners({iInvokedMethodListenersClass.class,
        iTestResultListenersClass.class})
public class TC04_AddingMember {
    private final String userName= DataUtils.getJasonData("ValidRegistrationData","UserName");
    private final String password= DataUtils.getJasonData("ValidRegistrationData","Password");

    public TC04_AddingMember() throws FileNotFoundException {
    }

    @BeforeMethod
    public void setUp() throws IOException {

        //we create here this new if condition to mack sure that we can run anything using MVN command
        //the If condition is = condition ? true : false

        String browser = System.getProperty("browser") != null
                ? System.getProperty("browser")
                : getPropertyValue("Environments.properties", "BROWSER");
        LogsUtils.info(System.getProperty("browser"));
        setUpBrowser(browser);
        LogsUtils.info(browser + "driver is opened");
        getDriver().get(getPropertyValue("Environments.properties", "LOGIN_URL"));
        LogsUtils.info("Page is redirected to URL");
        getDriver().manage().timeouts().
                implicitlyWait(Duration.ofSeconds(5));
    }
    @Test
    @Description("Adding Member End Work reason Coming of age (Age = 60)")
    public void ValidAddingMember() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUserName(userName)
                .enterPassword(password)
                .enterLoginBtn()
                .enterMemberPage()
                .enterAddNewMember()
                .enterUserName()
                .enterPhoneNumber()
                .enterNationalId(60)
                .enterAddress()
                .enterNote()
                .enterSyndicate()
                .chooseSyndicate()
                .enterSubSyndicate()
                .chooseSubSyndicate()
                .enterRegisterNumber()
                .enterFileNumber()
                .enterFileDate()
                .ConfirmAddingMember();
        Assert.assertTrue(new P04_AddNewMember(getDriver()).assertSuccessfulMassage());
    }

    @Test
    @Description("in Valid Adding Member ")
    public void inValidAddingMember() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUserName(userName)
                .enterPassword(password)
                .enterLoginBtn()
                .enterMemberPage()
                .enterAddNewMember()
                .enterUserName()
                .enterPhoneNumber()
                .enterNationalId(56)
                .enterAddress()
                .enterNote()
                .enterSyndicate()
                .chooseSyndicate()
                .enterSubSyndicate()
                .chooseSubSyndicate()
                .enterRegisterNumber()
                .enterFileNumber()
                .enterFileDate()
                .ConfirmAddingMember();
        Assert.assertFalse(new P04_AddNewMember(getDriver()).assertAgeErrorMassage(),
                "This member age is not = 60 years old ");
    }

    @Test
    @Description("Adding Death Member")
    public void ValidAddingDeathMember() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUserName(userName)
                .enterPassword(password)
                .enterLoginBtn()
                .enterMemberPage()
                .enterAddNewMember()
                .enterUserName()
                .enterPhoneNumber()
                .enterNationalId(60)
                .enterAddress()
                .enterNote()
                .enterSyndicate()
                .chooseSyndicate()
                .enterSubSyndicate()
                .chooseSubSyndicate()
                .enterRegisterNumber()
                .enterFileNumber()
                .enterEndWorkId()
                .selectEndWorkID()
                .enterEnd_work_date(30,59)
                .enterFileDate()
                .enterDynamicDeathDate()
                .enterFile_number_wrasa()
                .enterDate_file_Wrasa()
                .enterVerifyWarasa()
                .ConfirmAddingDeathMember();
        Assert.assertTrue(new P04_AddNewMember(getDriver()).assertSuccessfulMassage());
    }

    @Test
    @Description("Adding INValid Death Member")
    public void InValidAddingDeathMember() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUserName(userName)
                .enterPassword(password)
                .enterLoginBtn()
                .enterMemberPage()
                .enterAddNewMember()
                .enterUserName()
                .enterPhoneNumber()
                .enterNationalId(60)
                .enterAddress()
                .enterNote()
                .enterSyndicate()
                .chooseSyndicate()
                .enterSubSyndicate()
                .chooseSubSyndicate()
                .enterRegisterNumber()
                .enterFileNumber()
                .enterEndWorkId()
                .selectEndWorkID()
                .enterEnd_work_date(30,40)
                .enterFileDate()
                .enterManuelDeathDate(51,59)
                .enterFile_number_wrasa()
                .enterDate_file_Wrasa()
                .enterVerifyWarasa()
                .ConfirmAddingDeathMember();
        Assert.assertFalse(new P04_AddNewMember(getDriver()).assertDeathDateErrorMassage(),
                "The death date is different end work date ");
    }

    @AfterMethod
    public void quit() {
        // quitDriver();
    }
}
