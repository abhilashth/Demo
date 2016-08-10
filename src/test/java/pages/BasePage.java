package pages;

import SeleniumWrappers.Constants;

import java.util.concurrent.TimeUnit;

/**
 * Created by Abhilash Thaduka on 8/9/2016.
 */
public class BasePage extends WebPage implements Constants {

    public static final String LOGIN_XPATH = "//input[@type='%s']";
    public static final String PASSWORD = "//input[@type='password']";
    public static final String SIGNIN_LINK = "//input[@type='submit']";

    //input[@name='username']


    /**
     * Method to open url
     */
    public void openAppUrl() {
        getDriver().manage().timeouts().implicitlyWait(MAX_TIME, TimeUnit.SECONDS);
        getDriver().get(env.getProperty("appurl"));
        getDriver().manage().window().maximize();
    }

    /**
     * Method to login to app
     *
     * @param userName
     * @param password
     */
    public void login(String userName, String password) {
        wait.waitTillElementDisplayed(String.format(LOGIN_XPATH, "email"), MAX_TIME);
        field.clearAndSetText(String.format(LOGIN_XPATH, "email"), userName);
        field.clearAndSetText(String.format(LOGIN_XPATH, "password"), password);
        item.click(String.format(LOGIN_XPATH, "submit"));

    }
}
