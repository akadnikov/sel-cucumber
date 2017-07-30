package ru.bk.akadnikov;

import com.github.mkolisnyk.cucumber.runner.AfterSuite;
import com.github.mkolisnyk.cucumber.runner.BeforeSuite;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import ru.stqa.selenium.factory.WebDriverPool;

import java.io.IOException;
import java.net.URL;

/**
 * @author Viktor Sidochenko viktor.sidochenko@gmail.com
 */
@RunWith(ExtendedCucumber.class)
@CucumberOptions(features = {"src/test/resources/"}, tags = {"@testTag"})
public class CucumberJvmTest {

    public static URL gridHubUrl;
    public static String baseUrl;
    public static Capabilities capabilities;

    public WebDriver driver;

    @BeforeSuite
    public static void setUp() throws IOException {
        System.out.println("BeforeSuite");

        SuiteConfiguration config = new SuiteConfiguration();
        baseUrl = config.getProperty("site.url");
        if (config.hasProperty("grid.url") && !"".equals(config.getProperty("grid.url"))) {
            gridHubUrl = new URL(config.getProperty("grid.url"));
        }
        capabilities = config.getCapabilities();

    }

    @AfterSuite
    public static void tearDown() {
        System.out.println("AfterSuite");

        WebDriverPool.DEFAULT.dismissAll();
    }



}
