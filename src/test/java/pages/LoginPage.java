package pages;

/**
 * Created by Abhilash Thaduka on 8/10/2016.
 */
public class LoginPage extends BasePage {

    public static final String LOGIN_XPATH = "//input[@type='%s']";
    public static final String LOGIN_PAGE_DIV = "content";
    public static final String ERROR_MESSAGE = "//div[contains(text(),'Please check your username and password')]";
    public static final String LOGO = "//img[@id='logo']";


    public LoginPage() {
        wait.waitTillElementDisplayed(LOGIN_PAGE_DIV, MAX_TIME);
    }

    public boolean isErrorMessagePresent() {
        return element.isElementDisplayed(ERROR_MESSAGE);
    }

    public String getLogoText() {
        return element.getElement(LOGO).getAttribute("alt");
    }

    /**
     * Method to login to app
     *
     * @param userName
     * @param password
     */
    public BasePage login(String userName, String password) {
        wait.waitTillElementDisplayed(String.format(LOGIN_XPATH, "email"), MAX_TIME);
        field.clearAndSetText(String.format(LOGIN_XPATH, "email"), userName);
        field.clearAndSetText(String.format(LOGIN_XPATH, "password"), password);
        item.click(String.format(LOGIN_XPATH, "submit"));
        return this;
    }

}
