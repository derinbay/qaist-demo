package com.n11.selenium.helpers;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by Taylan on 05/04/2017.
 */
public class StopOrCloseFixtures implements TestRule {

    @Override
    public Statement apply(Statement base, Description description) {
        return statement(base);
    }

    private Statement statement(final Statement base) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    base.evaluate();
                } finally {
                    TestContext.closeBrowsers();
                }
            }
        };
    }
}
