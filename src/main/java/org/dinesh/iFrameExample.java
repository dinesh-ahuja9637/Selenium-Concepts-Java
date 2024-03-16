package org.dinesh;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class iFrameExample {
    WebDriver webDriver;
    @Test
    public void dropDownTest() throws IOException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        webDriver = new ChromeDriver(options);
        webDriver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        JavascriptExecutor javascriptExecutor= (JavascriptExecutor) webDriver;
        WebElement ele = webDriver.findElement(By.xpath("//th[text()='Name']"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();",ele);
        List<WebElement> iframe = webDriver.findElements(By.tagName("iframe"));
        System.out.println("number of iframes in webpage are:"+iframe.size());
        webDriver.switchTo().frame(0);

        System.out.println("text is:"+webDriver.findElement(By.xpath("//a[text()='Home']")).getText());
        webDriver.switchTo().defaultContent();

        System.out.println("text on main page is:"+webDriver.findElement(By.xpath("//legend[text()='Radio Button Example']")).getText());

        System.out.println();
        webDriver.close();



    }
}
