package pages;

import SeleniumWrappers.*;
import org.openqa.selenium.WebDriver;


/**
 * Created by Abhilash Thaduka on 8/9/2016.
 */
public class WebPage {

    protected final Field field = new Field();
    protected final Item item = new Item();
    protected final Element element = new Element();
    protected final Application env = new Application();
    protected final Wait wait = new Wait();

    protected WebDriver getDriver() {
        return Application.getDriver();
    }
}
