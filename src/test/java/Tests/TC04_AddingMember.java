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
                .enterNationalId()
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
    public void ValidOpenFiltersPage() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUserName(userName)
                .enterPassword(password)
                .enterLoginBtn()
                .enterMemberPage()
                .enterFilterBtn();
    }
    @Test
    @Description("Adding Member End Work reason Coming of age (Age = 60)")
    public void ValidAddingDeathMember() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUserName(userName)
                .enterPassword(password)
                .enterLoginBtn()
                .enterMemberPage()
                .enterAddNewMember()
                .enterUserName()
                .enterPhoneNumber()
                .enterNationalId()
                .enterAddress()
                .enterNote()
                .enterSyndicate()
                .chooseSyndicate()
                .enterSubSyndicate()
                .chooseSubSyndicate()
                .enterRegisterNumber()
                .enterFileNumber()
                .enterFileDate();
                //.ConfirmAddingMember();
        Assert.assertTrue(new P04_AddNewMember(getDriver()).assertSuccessfulMassage());
    }

    @AfterMethod
    public void quit() {
        // quitDriver();
    }
}
