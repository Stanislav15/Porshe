package utilities;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class TestBase3 {

    protected WebDriver driver;
    protected Actions actions;
    protected SoftAssert softAssert;
    protected Faker faker;
    protected Random random;
    protected Select list;


    @BeforeClass
    public void setUpClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpMethod(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        softAssert = new SoftAssert();
        actions = new Actions(driver);
        driver.manage().window().maximize();
        faker = new Faker();
        random = new Random();

    }

    @AfterMethod
    public void tearDownMethod(){
        //driver.quit();
        softAssert.assertAll();
    }

}




