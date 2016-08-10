package pages;

import SeleniumWrappers.Constants;

import java.util.concurrent.TimeUnit;

/**
 * Created by Abhilash Thaduka on 8/9/2016.
 */
public class BasePage extends WebPage implements Constants {

    public static final String LOGIN_XPATH = "//input[@type='%s']";
    public static final String NAVIGATION_HEADER = "//div[@class='zen']/descendant::ul[contains(@class,'zen-tabMenu')]";


    /**
     * Method to open application url
     */
    public void openAppUrl() {
        getDriver().manage().timeouts().implicitlyWait(MAX_TIME, TimeUnit.SECONDS);
        getDriver().get(env.getProperty("appurl"));
        getDriver().manage().window().maximize();
    }

    public boolean isTopNavigationHeaderPresent() {
        return element.isElementDisplayed(NAVIGATION_HEADER);
    }

}
