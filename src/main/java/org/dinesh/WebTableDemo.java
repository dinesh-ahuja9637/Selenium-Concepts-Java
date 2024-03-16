package org.dinesh;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTableDemo {
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
        List<WebElement> th = webDriver.findElements(By.xpath("//div[@class='tableFixHead']//table[@id='product']//th"));
        List<WebElement> tr = webDriver.findElements(By.xpath("//div[@class='tableFixHead']//table[@id='product']//tbody//tr"));



        //div[@class='tableFixHead']//table[@id='product']//th
        System.out.println("number of columns are:"+th.size());
        System.out.println("number of rows are:"+tr.size());
//div[@class='tableFixHead']//table[@id='product']//tbody//tr[3]/td[1]

            for(int j =1;j<= tr.size();j++)
            {
                System.out.println("Name in row["+j+"] is"+webDriver.findElement(By.xpath("//div[@class='tableFixHead']//table[@id='product']//tbody//tr["+j+"]/td[1]")).getText());
            }

        for(WebElement header : th)
        {
            System.out.println("Heading is:"+header.getText());
        }

        for(WebElement row : tr)
        {
            System.out.println("name is:"+row.getText());
        }
       webDriver.close();



    }
}
