package ru.bk.akadnikov.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Sample page
 */
public class HomePage extends Page {

  @FindBy(how = How.TAG_NAME, using = "h1")
  @CacheLookup
  public WebElement header;

  @FindBy(id = "text")
  public WebElement text;

  public HomePage(WebDriver webDriver) {

    super(webDriver);

    driver.get("https://yandex.ru/");

  }

  public void test() {
    text.sendKeys("test");
  }

}
