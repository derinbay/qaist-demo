package com.n11.selenium.helpers;

import com.n11.selenium.objects.Buyer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

/**
 * Created by Taylan on 05/04/2017.
 */
public class FailedTestScreenshotTaker extends TestWatcher {

    private static final Logger LOGGER = LogManager.getLogger(FailedTestScreenshotTaker.class);

    @Override
    public void failed(Throwable e, Description d) {
        try {
            TestContext testContext = TestContext.get();
            if (testContext != null) {
                for (Buyer buyer : testContext.getUsers()) {
                    buyer.takeScreenshot();
                }
            }
        } catch (Exception ex) {
            LOGGER.error("Exception on taking screenshot! " + ex);
        }
    }
}
