package org.dinesh.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FluentWaitDemoClass {

    WebDriver webDriver;

    @Test
    public void fluentWait()
    {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        webDriver = new ChromeDriver(options);
        webDriver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        String page_title = webDriver.getTitle();

        webDriver.findElement(By.xpath("//a[text()='Free Access to InterviewQues/ResumeAssistance/Material']")).click();
Wait wait = new FluentWait(webDriver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(1)).ignoring(StaleElementReferenceException.class);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='JOIN NOW']")));
//        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='JOIN NOW']")));
//        //webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String text = webDriver.findElement(By.xpath("//a[text()='JOIN NOW']")).getText();
        System.out.println("Text is:"+text);
        webDriver.close();

    }
}
