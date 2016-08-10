package tests;

import SeleniumWrappers.Application;
import org.testng.annotations.BeforeSuite;
import pages.BasePage;

/**
 * Created by Abhilash Thaduka on 8/9/2016.
 */
public class BaseTest {


    public static Application application = new Application();
    BasePage basePage = new BasePage();


    @BeforeSuite
    public void init() {
        application.launchBrower(application.getProperty("browser"));
        basePage.openAppUrl();
    }
}
