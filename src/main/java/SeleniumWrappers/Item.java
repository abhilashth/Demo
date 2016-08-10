package SeleniumWrappers;

import static Utils.Log.*;

/**
 * Created by Abhilash Thaduka on 8/9/2016.
 */
public class Item {
    Element element = new Element();

    /**
     * @param field
     */
    public void click(String field) {
        element.getElement(field).click();
        info("Finished Clicking Item : " + field);
    }


}
