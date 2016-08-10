package tests;

import SeleniumWrappers.Application;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import pojo.Login;

import java.io.File;
import java.io.IOException;

/**
 * Created by Abhilash Thaduka on 8/10/2016.
 */
public class HomeTest extends BaseTest {

    BasePage basePage;
    ObjectMapper mapper;
    HomePage homePage;

    @BeforeClass
    public void setUp() {
        basePage = new BasePage();
        mapper = new ObjectMapper();
    }


    @Test(description = "Testcase to verify font color in hexaDecimal")
    public void testVerifyFontColor() throws IOException {
        basePage.openAppUrl();
        LoginPage loginPage = new LoginPage();
        Login login = mapper.readValue(new File(Application.basedir + "/src/test/testdata/TC1.json"), Login.class);
        loginPage.login(login.getUserName(), login.getPassword());
        homePage = new HomePage();
        Assert.assertEquals(homePage.getfontColorInHexadecimal(), "#353535", "font color is not macthing, please check!!!11");

    }

    @Test(description = "Testcase to verify font alignment")
    public void testVerifyFontAlignment() throws IOException {
        basePage.openAppUrl();
        LoginPage loginPage = new LoginPage();
        Login login = mapper.readValue(new File(Application.basedir + "/src/test/testdata/TC1.json"), Login.class);
        loginPage.login(login.getUserName(), login.getPassword());
        homePage = new HomePage();
        Assert.assertEquals(homePage.getfontAlignment(), "left", "font alignment is not macthing, please check!!!11");

    }

    @Test(description = "Testcase to verify font family")
    public void testVerifyFontFamily() throws IOException {
        basePage.openAppUrl();
        LoginPage loginPage = new LoginPage();
        Login login = mapper.readValue(new File(Application.basedir + "/src/test/testdata/TC1.json"), Login.class);
        loginPage.login(login.getUserName(), login.getPassword());
        homePage = new HomePage();
        Assert.assertEquals(homePage.getfontFamily(), "Arial,Helvetica,sans-serif", "font family is not macthing, please check!!!11");
    }
}
