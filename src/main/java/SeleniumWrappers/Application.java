package SeleniumWrappers;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Properties;

/**
 * Created by Abhilash Thaduka on 8/9/2016.
 */
public class Application {

    private static Logger Log = Logger.getLogger(Application.class);
    public static String basedir = ".";
    private static WebDriver webDriver;
    private final static Properties PROPERTIES = new Properties();

    static {
        PropertyConfigurator.configure("./conf/log4j.properties");
        try {
            PROPERTIES.load(new FileReader("./conf/application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void setWebDriver(WebDriver webDriver) {
        Application.webDriver = webDriver;
    }

    public static WebDriver getDriver() {
        return webDriver;
    }

    public String getProperty(String name) {
        return PROPERTIES.getProperty(name);
    }

    public void launchBrower(String browser) {
        initDriver(browser);
    }

    protected void initDriver(String browser) {
        if ("firefox".equalsIgnoreCase(browser))
            initFirefoxDriver();
        else if ("ie".equalsIgnoreCase(browser)) {
            initIEDriver();
        } else if ("chrome".equalsIgnoreCase(browser))
            initChromeDriver();
        else
            throw new InvalidParameterException("unknown browser: " + browser);

    }

    private void initFirefoxDriver() {
        FirefoxDriver driver = new FirefoxDriver();
        webDriver = driver;
    }

    private void initChromeDriver() {
        Log.info("Driver is set to Chrome.");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        webDriver = driver;
    }

    private void initIEDriver() {
        Log.info("Driver is set to IE.");
        System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        InternetExplorerDriver driver = new InternetExplorerDriver(capabilities);
        webDriver = driver;
    }
}
