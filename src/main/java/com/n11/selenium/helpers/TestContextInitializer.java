package com.n11.selenium.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by Taylan on 05/04/2017.
 */
public class TestContextInitializer implements TestRule {

    private static final Logger LOGGER = LogManager.getLogger(TestContextInitializer.class);

    @Override
    public Statement apply(Statement base, Description description) {
        return statement(base, description);
    }

    private Statement statement(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                TestContext.init(description.getClassName(), description.getMethodName());
                LOGGER.info("TEST STARTED: " + description.getClassName() + " - " + description.getMethodName());
                try {
                    base.evaluate();
                } finally {
                    //TestContext.remove();
                }
            }
        };
    }
}
