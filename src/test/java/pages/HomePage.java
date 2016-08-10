package pages;

import Utils.Log;

/**
 * Created by Abhilash Thaduka on 8/10/2016.
 */
public class HomePage extends BasePage {
    public static final String NAVIGATION_HEADER = "//div[@class='zen']/descendant::ul[contains(@class,'zen-tabMenu')]";
    public static final String HOME_TAB = "//ul[contains(@class,'zen-tabMenu')]/descendant::a[@title='Home Tab']";


    public HomePage() {
        wait.waitTillElementDisplayed(NAVIGATION_HEADER, MAX_TIME);
    }

    /**
     * Method to get font family
     *
     * @return
     */
    public String getfontFamily() {
        return element.getElement(HOME_TAB).getCssValue("font-family").replaceAll("\\s", "");
    }

    /**
     * Method to get font color in hexadecimal
     *
     * @return
     */
    public String getfontColorInHexadecimal() {
        String color = element.getElement(HOME_TAB).getCssValue("color");
        String[] numbers = color.replace("rgba(", "").replace(")", "").split(",");
        int r = Integer.parseInt(numbers[0].trim());
        int g = Integer.parseInt(numbers[1].trim());
        int b = Integer.parseInt(numbers[2].trim());
        System.out.println("r: " + r + " g: " + g + " b: " + b);
        String hex = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
        Log.info(hex);
        return hex;
    }

    /**
     * Method to get font alignment
     *
     * @return
     */
    public String getfontAlignment() {
        return element.getElement(HOME_TAB).getCssValue("text-align");
    }

}
