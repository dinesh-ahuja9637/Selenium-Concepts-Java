package org.dinesh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandle {


    WebDriver webDriver;
    @Test
    public void dropDownTest() throws IOException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        webDriver = new ChromeDriver(options);
        webDriver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String parentWindow=webDriver.getWindowHandle();
        //button[@id='openwindow']
        webDriver.findElement(By.xpath("//button[@id='openwindow']")).click();

        Set<String> windows = webDriver.getWindowHandles();
       for(String window : windows)
       {
           webDriver.switchTo().window(window);
           if(webDriver.getTitle().contains("QAClick Academy - A Testing Academy to Learn, Earn and Shine")){
               break;
           }
       }
       webDriver.close();

        webDriver.switchTo().window(parentWindow);
        webDriver.close();


    }
}
