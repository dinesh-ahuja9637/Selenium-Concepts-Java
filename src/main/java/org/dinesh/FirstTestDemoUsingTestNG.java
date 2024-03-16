package org.dinesh;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

@Test
public class FirstTestDemoUsingTestNG {

    @Test
    public void firstTest() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//chromedriver.exe");
        System.out.println("This is my first demo test using TestNG");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//chromedriver.exe");
        WebDriver obj = new ChromeDriver();
        obj.get("https://www.google.com");
        System.out.println("title:"+obj.getTitle());
        System.out.println("current URL:"+obj.getCurrentUrl());
        System.out.println("window handle:"+obj.getWindowHandle());
        if(obj.getTitle().equals("Google"))
        {
            System.out.println("test pass");
        } else {
            System.out.println("test fail");
        }
        obj.close();


    }

    @Test
    public void testElementocators() throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver webDriver = new ChromeDriver(options);
        webDriver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        //locating element by id
        Thread.sleep(5000L);
        webDriver.findElement(By.id("name")).sendKeys("Dinesh");


        //locating element by name
        webDriver.findElement(By.name("enter-name"));

        //locating element by className
        webDriver.findElement(By.className("inputs"));

        //locating element by tagName
        webDriver.findElement(By.tagName("legend"));

        //locating element by LinkText and PartialLinkText
        //webDriver.findElement(By.linkText("Free Access to InterviewQues"));
        webDriver.findElement(By.partialLinkText("Free Access to InterviewQues"));

        //locating element by xpath
        webDriver.findElement(By.xpath("//input[@id='name']"));

        //locating element by css ocator
        //webDriver.findElement(By.cssSelector());
        webDriver.close();
    }

    @Test
    public void cssLocatorDemo() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver webDriver = new ChromeDriver(options);
        webDriver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        Thread.sleep(2000L);
        //locating element using css locator tagname and id
        webDriver.findElement(By.cssSelector("input#alertbtn"));
        Thread.sleep(2000L);
        //locating element using css locator tagname and class
        webDriver.findElement(By.cssSelector("input.btn-style"));


        //locating element using css locator tagname and attribute and value
        Thread.sleep(2000L);
        webDriver.findElement(By.cssSelector("input[id=alertbtn]"));

        //css ocator tagname.classname[attribute=vaue]
        Thread.sleep(2000L);
        webDriver.findElement(By.cssSelector("input.btn-style[id=alertbtn]"));
        webDriver.close();

    }

    @Test
    public void locateElementUsingXpath() throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver webDriver = new ChromeDriver(options);
        webDriver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
webDriver.manage().window().fullscreen();
//webDriver.navigate().to();
//webDriver.navigate().to();
//webDriver.switchTo()
        webDriver.switchTo().activeElement();

        Thread.sleep(2000L);
        //locating input box using xpath using multiple attributes
        webDriver.findElement(By.xpath("//input[@id='name'][@class='inputs']"));
        TakesScreenshot src = (TakesScreenshot) webDriver;
        File SrcFile=src.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(SrcFile, new File("c:\\tmp\\screenshot.png"));
        //File DestFile=new File(System.getProperty("user.dir"+"//test//java//Test.png"));
        webDriver.close();
    }

    @Test
    public void navigateDemo() throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver webDriver = new ChromeDriver(options);
        //webDriver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        webDriver.navigate().to("https://www.rahulshettyacademy.com/AutomationPractice/");
        webDriver.manage().window().fullscreen();
        //https://www.rahulshettyacademy.com/AutomationPractice/
        Thread.sleep(2000L);
        TakesScreenshot src = (TakesScreenshot) webDriver;
        File f = src.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(f,new File("c://tmp//navigate1.png"));
        webDriver.findElement(By.xpath("//a[text()='Free Access to InterviewQues/ResumeAssistance/Material']")).click();
        f = src.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(f,new File("c://tmp//course_page.png"));
        webDriver.navigate().back();
        f = src.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(f,new File("c://tmp//home_page.png"));
        webDriver.close();
    }


    @Test
    public void manageDemo()
    {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver webDriver = new ChromeDriver(options);
        webDriver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        webDriver.manage().window().maximize();
        webDriver.close();

    }
}
