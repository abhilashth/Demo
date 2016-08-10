package tests;


import SeleniumWrappers.Application;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pojo.Login;

import java.io.File;
import java.io.IOException;

/**
 * Created by Abhilash Thaduka on 8/9/2016.
 */
public class LoginTest extends BaseTest {

    BasePage basePage;
    ObjectMapper mapper;
    LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        basePage = new BasePage();
        mapper = new ObjectMapper();
        loginPage = new LoginPage();
    }

    @Test(description = "Testcase to test successful login")
    public void testSuccessfulLogin() throws IOException {
        basePage.openAppUrl();
        Login login = mapper.readValue(new File(Application.basedir + "/src/test/testdata/TC1.json"), Login.class);
        loginPage.login(login.getUserName(), login.getPassword());
        Assert.assertTrue(basePage.isTopNavigationHeaderPresent(), "Navigation Header is not present, Please check");
    }

    @Test(description = "Testcase to test Invalid login")
    public void testInvalidLogin() throws IOException {
        basePage.openAppUrl();
        Login login = mapper.readValue(new File(Application.basedir + "/src/test/testdata/TC2.json"), Login.class);
        loginPage.login(login.getUserName(), login.getPassword());
        Assert.assertTrue(loginPage.isErrorMessagePresent(), "Able to login with invalid credentials also, Please check");
    }

    @Test(description = "Testcase to verify whether logo text is present of not in salesforce")
    public void testWhetherLogoTextIsPresent() throws IOException {
        basePage.openAppUrl();
        Assert.assertEquals("Salesforce", loginPage.getLogoText(), "Image text is not same");
    }
}
