package Tests;

import Pages.P01_LoginPage;
import Utilittes.DataUtils;
import Utilittes.LogsUtils;
import Utilittes.Utility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;
import static Utilittes.DataUtils.getPropertyValue;
import Listeners.iInvokedMethodListenersClass;
import Listeners.iTestResultListenersClass;

@Listeners({iInvokedMethodListenersClass.class,
        iTestResultListenersClass.class})
public class TC01_LoginPage {
    private final String userName= DataUtils.getJasonData("ValidRegistrationData","UserName");
    private final String password= DataUtils.getJasonData("ValidRegistrationData","Password");

    public TC01_LoginPage() throws FileNotFoundException {
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
    public void ValidLoginCycle() throws IOException {
new P01_LoginPage(getDriver())
        .enterUserName(userName)
        .enterPassword(password)
        .enterLoginBtn();
Assert.assertTrue(new P01_LoginPage(getDriver()).
        assertHomePage(getPropertyValue("Environments.properties", "HOME_URL")));
    }
    @AfterMethod
    public void quit() {
       // quitDriver();
    }
}
