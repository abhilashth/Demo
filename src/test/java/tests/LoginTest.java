package tests;


import SeleniumWrappers.Application;
import Utils.Log;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.Assert;
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
        Login login = mapper.readValue(new File(Application.basedir + "/src/test/testdata/TC1.json"), Login.class);
        Log.info(mapper.writeValueAsString(login));
        loginPage.login(login.getUserName(), login.getPassword());
    }

    @Test(description = "Testcase to test Invalid login")
    public void testInvalidLogin() throws IOException {
        Login login = mapper.readValue(new File(Application.basedir + "/src/test/testdata/TC2.json"), Login.class);
        loginPage.login(login.getUserName(), login.getPassword());
        Assert.assertTrue("Able to login with invalid credentials also, Please check", loginPage.isErrorMessagePresent());
    }

    @Test(description = "Testcase to verify whether logo text is present of not in salesforce")
    public void testWhetherLogoTextIsPresent() throws IOException {
        Assert.assertEquals("Salesforce", loginPage.getLogoText());
    }
}
