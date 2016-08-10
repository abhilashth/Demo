package SeleniumWrappers;

import Utils.Log;
import org.openqa.selenium.*;

/**
 * Created by Abhilash Thaduka on 8/9/2016.
 */
public class Element {

    protected WebDriver getDriver() {
        return Application.getWebDriver();
    }

    /**
     *
     * @param by
     * @return
     */
    public WebElement getElement(By by) {
        try {
            WebElement ele = getDriver().findElement(by);
            return ele;
        } catch (StaleElementReferenceException ser) {
            Log.info("ERROR: Stale element. " + by.toString());
            throw ser;
        } catch (NoSuchElementException nse) {
            Log.info("ERROR: No such element. " + by.toString());
            throw nse;
        } catch (ElementNotVisibleException env) {
            Log.info("ERROR: Element not visible " + by.toString());
            throw env;
        } catch (Exception e) {
            Log.info(e.getMessage());
            throw new RuntimeException(e);
        }
    }


    public WebElement getElement(String identifier) {
        return getElement(getElementBy(identifier));
    }

    /**
     * Get Element Identifier like xpath, css, className, Name, linkText or Id
     *
     * @param identifier
     * @return
     */
    public By getElementBy(String identifier) {
        if (identifier.indexOf("/") == 0)
            return By.xpath(identifier);
        else if ((identifier.indexOf("css:") == 0)) {
            String selector = identifier.substring("css:".length());
            return By.cssSelector(selector);
        } else if ((identifier.indexOf("class:") == 0)) {
            String selector = identifier.substring("class:".length());
            return By.className(selector);
        } else if ((identifier.indexOf("name:") == 0)) {
            String selector = identifier.substring("name:".length());
            return By.name(selector);
        } else if ((identifier.indexOf("linkText:") == 0)) {
            String selector = identifier.substring("linkText:".length());
            return By.linkText(selector);
        } else
            return By.id(identifier);
    }

}
