package com.n11.selenium.helpers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.n11.selenium.objects.Config.MAIN_URL;

/**
 * Created by taylan.derinbay on 05.04.2017.
 */
public class BaseTest {

    @Rule
    public TestRule chain = RuleChain.outerRule(new TestContextInitializer())
            .around(new StopOrCloseFixtures())
            .around(new FailedTestScreenshotTaker());
    protected WebDriver driver;

    @Before
    public void startUp() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        try {
//          ChromeDriverManager.getInstance().setup();
//          driver = new ChromeDriver(capabilities);
            driver = new RemoteWebDriver(new URL("http://172.20.0.223:4444/wd/hub"), capabilities);
            driver.manage().window().maximize();
            driver.get(MAIN_URL);
        } catch (MalformedURLException e) {
            throw new Error();
        }
    }
}
