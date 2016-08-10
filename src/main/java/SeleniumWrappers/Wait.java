package SeleniumWrappers;

import Utils.Log;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Abhilash Thaduka on 8/10/2016.
 */
public class Wait {
    Element element = new Element();

    public void waitTillElementDisplayed(final String identifier, final int timeout) {
        Log.info("Waiting for element to be displayed " + identifier);

        new WebDriverWait(Application.getDriver(), timeout).until(ExpectedConditions
                .visibilityOfElementLocated(element.getElementBy(identifier)));


    }
}
