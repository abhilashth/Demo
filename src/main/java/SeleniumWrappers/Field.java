package SeleniumWrappers;

import Utils.Log;
import org.openqa.selenium.WebElement;

/**
 * Created by Abhilash Thaduka on 8/10/2016.
 */
public class Field {
    Element element = new Element();

    /**
     *
     * @param identifier
     * @param text
     */
    public void clearAndSetText(String identifier, String text) {
        Log.info("Clear field " + identifier + " enter " + text);
        WebElement webElement = element.getElement(identifier);
        webElement.clear();
        webElement.sendKeys(text);
    }
}
