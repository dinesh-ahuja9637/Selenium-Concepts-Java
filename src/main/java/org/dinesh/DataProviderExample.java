package org.dinesh;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProviderExample {

    WebDriver webDriver;

    @Test(dataProvider = "dataProviderFunc")
    public void dummyDataProviderTest(String URL, String name)
    {
        System.out.println("URL:"+URL);
        System.out.println("Name:"+name);
    }
    @Test
    @Parameters({"URL","name"})

    public void parameterDemo(String url,String name)
    {
        System.out.println("name is:"+name);
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        webDriver = new ChromeDriver(options);
        webDriver.get(url);
        String page_title = webDriver.getTitle();

        //hard assert
        Assert.assertTrue(page_title.contains("dinesh"),"Title does not contains dinesh");
        //webDriver.close();
    }

    @DataProvider
    public Object[][] dataProviderFunc()
    {
        Object[][] data = new Object[2][2];
        data[0][0]="https://www.google.com"; data[0][1]="Dinesh";
        data[1][0]="https://www.google.com"; data[1][1]="Pranav";
return data;

    }
}
