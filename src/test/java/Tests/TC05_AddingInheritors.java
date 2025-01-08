package Tests;

import Pages.P01_LoginPage;
import Pages.P04_AddNewMember;
import Pages.P05_AddingInheritors;
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
public class TC05_AddingInheritors {
    private final String userName= DataUtils.getJasonData("ValidRegistrationData","UserName");
    private final String password= DataUtils.getJasonData("ValidRegistrationData","Password");

    public TC05_AddingInheritors() throws FileNotFoundException {
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
    @Description("Adding Full cycle Death Member with inheritors ")
    public void ValidAddingDeathMemberWithInheritorsFullCycle() throws IOException {
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
                .ConfirmAddingDeathMember()
                .enterInheritorName()
                .enterNationalId(30,35)
                .enterPhoneNumber()
                .enterInheritorType(" ارمله ")
                .enterAddress()
                .enterNote()
                .enterYasref()
                .enterSarf_responsible()
                .enterAddInheritors()
                .savingAllInheritors();
        Assert.assertTrue(new P05_AddingInheritors(getDriver()).assertSuccessfulMassage());
    }




    @AfterMethod
    public void quit() {
        // quitDriver();
    }
}
