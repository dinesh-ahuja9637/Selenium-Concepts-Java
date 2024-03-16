package org.dinesh;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HiddenElementDemo {
    WebDriver webDriver;
    @Test(retryAnalyzer = org.dinesh.RetryAnalyzer.class)
    public void dropDownTest() throws IOException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        webDriver = new ChromeDriver(options);
        webDriver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        boolean visible =webDriver.findElement(By.xpath("//*[@id='displayed-text']")).isDisplayed();

if(!visible)
{
    webDriver.findElement(By.xpath("//*[@id='show-textbox']")).click();
}

    webDriver.findElement(By.xpath("//*[@id='displayed-text']")).sendKeys("Hi");

webDriver.close();
webDriver.getTitle();


    }
}
