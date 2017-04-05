package com.n11.selenium.helpers;

import com.n11.selenium.objects.Buyer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taylan on 05/04/2017.
 */
public class TestContext {

    public static final ThreadLocal<TestContext> contexts = new ThreadLocal<>();

    private List<Buyer> users = new ArrayList<>();
    private String testClassName;
    private String testMethodName;

    private TestContext(String testClassName, String testMethodName) {
        this.testClassName = testClassName;
        this.testMethodName = testMethodName;
    }

    public static TestContext get() {
        return contexts.get();
    }

    public static void init(String testClassName, String testMethodName) {
        contexts.set(new TestContext(testClassName, testMethodName));
    }

    public static void remove() {
        contexts.remove();
    }

    public static void closeBrowsers() {
        if (TestContext.get() != null) {
            for (Buyer buyer : TestContext.get().users) {
                buyer.close();
            }
        }
    }

    public List<Buyer> getUsers() {
        return users;
    }

    public void addBuyer(Buyer buyer) {
        users.add(buyer);
    }

    public String getTestMethodName() {
        return testMethodName;
    }

    public String getTestClassName() {
        return testClassName;
    }
}

