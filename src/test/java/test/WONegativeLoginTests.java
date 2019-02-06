package test;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

import java.util.concurrent.TimeUnit;

public class WONegativeLoginTests extends BrowserUtils {

    WebDriver driver;

    @BeforeClass
    public void setUpClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpMethod(){
        //1,2
        driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/ login.aspx");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void titleVerify(){

        //3
        String titleExpected = "Web Orders Login";
        String titleActual = driver.getTitle();
        verifyTextMatches(titleActual, titleExpected);
        System.out.println("Titles are matching");
        String currentURL = driver.getCurrentUrl();
    }

    @Test
    public void wrongUserName(){
        //4
        String currentURL = driver.getCurrentUrl();
        //5
        driver.findElement(By.xpath("//*[@name='ctl00$MainContent$username']")).sendKeys("Test");
        //6
        driver.findElement(By.xpath("//*[@name='ctl00$MainContent$password']")).sendKeys("Test");
        //7
        driver.findElement(By.xpath("//*[@name='ctl00$MainContent$login_button']")).click();
        //8
        titleVerify();
        //9
        String actualURL = driver.getCurrentUrl();
        verifyTextMatches(currentURL, actualURL);
    }

    @Test
    public void wrongPassword(){
        titleVerify();
        String currentURL = driver.getCurrentUrl();
        //5
        driver.findElement(By.xpath("//*[@name='ctl00$MainContent$username']")).sendKeys("Tester");
        //6
        driver.findElement(By.xpath("//*[@name='ctl00$MainContent$password']")).sendKeys("Tester");
        //7
        driver.findElement(By.xpath("//*[@name='ctl00$MainContent$login_button']")).click();
        //8
        titleVerify();

        //9
        String actualURL = driver.getCurrentUrl();
        verifyTextMatches(currentURL, actualURL);
    }

    @Test
    public void blankUsername(){
        titleVerify();
        String currentURL = driver.getCurrentUrl();
        //5
        driver.findElement(By.xpath("//*[@name='ctl00$MainContent$password']")).sendKeys("test");
        //6
        driver.findElement(By.xpath("//*[@name='ctl00$MainContent$login_button']")).click();
        //7
        titleVerify();
        //8
        String actualURL = driver.getCurrentUrl();
        verifyTextMatches(currentURL, actualURL);
    }

    @Test
    public void blankPassword(){
        titleVerify();
        String currentURL = driver.getCurrentUrl();
        //5
        driver.findElement(By.xpath("//*[@name='ctl00$MainContent$username']")).sendKeys("Tester");
        //6
        driver.findElement(By.xpath("//*[@name='ctl00$MainContent$login_button']")).click();
        //7
        titleVerify();
        String actualURL = driver.getCurrentUrl();
        verifyTextMatches(currentURL, actualURL);
    }


}