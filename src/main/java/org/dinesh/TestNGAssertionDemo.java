package org.dinesh;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGAssertionDemo {

    @Test
    public void testHarAssertDemo()
    {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver webDriver = new ChromeDriver(options);
        webDriver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        String page_title = webDriver.getTitle();

       //hard assert
        Assert.assertTrue(page_title.contains("page"),"Title does not contains dinesh");
        webDriver.close();
        Assert.assertEquals(page_title,"Practise page","False");

    }

    @Test public void softAssertTest()
    {
        SoftAssert softAssert = new SoftAssert();
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver webDriver = new ChromeDriver(options);
        webDriver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        String page_title = webDriver.getTitle();

        //hard assert
        softAssert.assertTrue(page_title.contains("Page"),"Title does not contains dinesh");
        webDriver.close();
        softAssert.assertEquals(page_title,"Practise page","False");
softAssert.assertAll("soft asserted");
    }
}
