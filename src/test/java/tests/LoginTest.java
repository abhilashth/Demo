package tests;


import SeleniumWrappers.Application;
import Utils.Log;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import pages.BasePage;
import pojo.Login;

import java.io.File;
import java.io.IOException;

/**
 * Created by Abhilash Thaduka on 8/9/2016.
 */
public class LoginTest extends BaseTest {

    BasePage basePage = new BasePage();
    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void test1() throws IOException {
        Login login = mapper.readValue(new File(Application.basedir + "/src/test/testdata/TC1.json"), Login.class);
        Log.info(mapper.writeValueAsString(login));
        basePage.login(login.getUserName(), login.getPassword());


    }
}
