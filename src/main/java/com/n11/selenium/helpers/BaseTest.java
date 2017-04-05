package com.n11.selenium.helpers;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.n11.selenium.objects.Config.MAIN_URL;

/**
 * Created by taylan.derinbay on 05.04.2017.
 */
public class BaseTest {

    protected WebDriver driver;

    @Before
    public void startUp() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(MAIN_URL);
    }

    @Rule
    public TestRule chain = RuleChain.outerRule(new TestContextInitializer())
            .around(new StopOrCloseFixtures())
            .around(new FailedTestScreenshotTaker());

//    @After
//    public void tearDown() {
//        driver.quit();
//    }
}
