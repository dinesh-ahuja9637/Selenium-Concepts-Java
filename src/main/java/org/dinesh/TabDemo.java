package org.dinesh;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TabDemo {

    WebDriver webDriver;
    @Test
    public void dropDownTest() throws IOException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        webDriver = new ChromeDriver(options);
        webDriver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//button[@id='openwindow']"));


        String parentWindow = webDriver.getWindowHandle();
        System.out.println("parentWindow:"+parentWindow);
        webDriver.findElement(By.xpath("//a[text()='Open Tab']")).click();

        Set<String> windows = webDriver.getWindowHandles();
        System.out.println(windows.size());
        for(String windowName : windows){
        webDriver.switchTo().window(windowName);
        if(webDriver.getTitle().equals("QAClick Academy - A Testing Academy to Learn, Earn and Shine"))
        break;}

        webDriver.close();
        webDriver.switchTo().window(parentWindow);
        JavascriptExecutor javascriptExecutor =(JavascriptExecutor) webDriver;

        ((JavascriptExecutor) webDriver).executeScript("window.open(0);");
        webDriver.get("https://www.google.com/");
        //webDriver.close();



    }

}
