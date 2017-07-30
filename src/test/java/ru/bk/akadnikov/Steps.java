package ru.bk.akadnikov;

import ru.bk.akadnikov.pages.HomePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ru.*;
import java.util.Arrays;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import ru.stqa.selenium.factory.WebDriverPool;
import ru.yandex.qatools.allure.annotations.Attachment;

/**
 * @author Viktor Sidochenko viktor.sidochenko@gmail.com
 */
public class Steps extends CucumberJvmTest{



    @Before
    public void before() {
        System.out.println("Before");

        driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
        driver.get(baseUrl);

    }

    @After
    public void after() {
        System.out.println("After");
    }

    int a;
    int b;
    int c;
    int sum;

    @Дано("^первое число (\\d+)$")
    @Given("^first digit (\\d+)$")
    public void firstDigit(int digit) throws Throwable {
        a = digit;
    }

    @Дано("^второе число (\\d+)$")
    @And("^second digit (\\d+)$")
    public void secondDigit(int digit) throws Throwable {
        b = digit;
    }

    @Дано("^третье число (\\d+)$")
    public void thirdDigit(int digit) throws Throwable {
        c = digit;
    }

    @Когда("^я их складываю$")
    @When("^I multiply it$")
    public void multiply() throws Throwable {
        sum = a + b + c;
    }

    @Тогда("^сумма равна (\\d+)$")
    @Then("^sum is (\\d+)$")
    public void sum(int result) throws Throwable {
        Assert.assertEquals(result, sum);
    }

    @Дано("^сломанный сценарий$")
    public void brokenScenario() throws Throwable {
        try {
            Object o = 1;
            String fail = (String) o;
        } catch (Exception e) {
            this.createAttachment(Arrays.toString(e.getStackTrace()));
            throw e;
        }
    }

    @Когда("^отображается отчет$")
    public void seeTheReport() throws Throwable {

    }

    @То("^видно исключение$")
    public void seeAnException() throws Throwable {

    }

    @То("^ТЕСТ$")
    public void testHomePageHasAHeader() {
        HomePage homepage = PageFactory.initElements(driver, HomePage.class);
        homepage.test();
        Assert.assertFalse("test".equals(homepage.text.getText()));
    }

    @Attachment()
    private byte[] createAttachment(String att) {
        String content = att;
        return content.getBytes();
    }

}
