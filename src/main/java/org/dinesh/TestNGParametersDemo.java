package org.dinesh;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TestNGParametersDemo {

    WebDriver webDriver;

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

    @AfterMethod
    public void captureScreenshot(ITestResult iTestResult) throws IOException {
        if(ITestResult.FAILURE == iTestResult.getStatus()){
        TakesScreenshot src =(TakesScreenshot) webDriver;
        File f = src.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(f,new File("C:\\Users\\91976\\IdeaProjects\\Selenium_Sample_Project\\src\\main\\resources\\"+iTestResult.getName()+".png"));
        webDriver.close();}
        else {
            webDriver.close();
        }
    }
}
