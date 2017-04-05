package com.n11.selenium.objects;

import com.n11.selenium.helpers.TestContext;
import org.openqa.selenium.WebDriver;

import static com.n11.selenium.objects.Config.*;

/**
 * Created by Taylan on 05.04.2017.
 */
public class BuyerPool {

    private BuyerPool() {
    }

    public static Buyer buyerForLoginTest(WebDriver driver) {
        Buyer buyer = new Buyer("seleniummallfront90@mailcatch.com", DEFAULT_PASSWORD, DEFAULT_USERNAME, driver);
        TestContext.get().addBuyer(buyer);
        return buyer;
    }

    public static Buyer buyerForFavoritesTest(WebDriver driver) {
        Buyer buyer = new Buyer("seleniummallfront91@mailcatch.com", DEFAULT_PASSWORD, DEFAULT_USERNAME, driver);
        TestContext.get().addBuyer(buyer);
        return buyer;
    }

    public static Buyer buyerForInvalidLoginTest(WebDriver driver) {
        Buyer buyer = new Buyer("seleniummallfront93@mailcatch.com", INVALID_PASSWORD, DEFAULT_USERNAME, driver);
        TestContext.get().addBuyer(buyer);
        return buyer;
    }
}
