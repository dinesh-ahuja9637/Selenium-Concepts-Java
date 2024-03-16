package org.dinesh;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MouseEventsDemo {

    WebDriver webDriver;
    @Test
    public void dropDownTest() throws IOException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        webDriver = new ChromeDriver(options);
        webDriver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Actions actions = new Actions(webDriver);
        actions.scrollToElement(webDriver.findElement(By.xpath("//*[text()='Mouse Hover Example']")));
        actions.moveToElement(webDriver.findElement(By.xpath("//*[text()='Mouse Hover']")));
        actions.build().perform();//webDriver.close();
        System.out.println("elemtns at one is:"+webDriver.findElement(By.xpath("//a[text()='Top']")).getText());
actions.release();


    }
}
