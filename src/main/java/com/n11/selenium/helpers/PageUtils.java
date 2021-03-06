package com.n11.selenium.helpers;

import com.n11.selenium.pages.Page;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.openqa.selenium.WebElement;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Taylan on 05.04.2017.
 */
public class PageUtils {

    private final Logger logger = Logger.getAnonymousLogger();

    /**
     * This method gets the page element from given string
     * @param elementName is the name of element
     * @param page is the object class of the element
     * @return WebElement
     */
    public WebElement get(String elementName, Page page) {
        Class<?> pageClass = page.getClass();
        Field field = FieldUtils.getField(pageClass, elementName, true);
        field.setAccessible(true);
        WebElement element;
        try {
            element = (WebElement) field.get(page);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Field is not declared on page", ex);
            throw new IllegalStateException("Exception on accessing field {" + elementName + "} of page");
        }
        return element;
    }
}
