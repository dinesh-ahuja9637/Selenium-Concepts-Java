package org.dinesh.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumWaitDemo_ImplicitWait {

    WebDriver webDriver;

    @Test
    public void implicitWaitDemo()
    {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        webDriver = new ChromeDriver(options);
        webDriver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        String page_title = webDriver.getTitle();

        webDriver.findElement(By.xpath("//a[text()='Free Access to InterviewQues/ResumeAssistance/Material']")).click();

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String text = webDriver.findElement(By.xpath("//a[text()='JOIN NOW']")).getText();
        System.out.println("Text is:"+text);


    }

    @AfterMethod
    public void afterMethod()
    {
        webDriver.close();
    }
}
