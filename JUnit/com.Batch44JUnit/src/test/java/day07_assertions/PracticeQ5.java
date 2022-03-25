package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class PracticeQ5 {

   static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }
    @Before
    public void testtenonce(){
        driver.get("https://www.google.com");
    }
    @After
    public void testtenSonra(){

    }
    @Test
    public void test01(){
        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Green Mile"+ Keys.ENTER);;

        System.out.println(driver.findElement(By.xpath("//div[@id='result-stats']")).getText());
    }
    @Test
    public void test02(){
        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Premnition"+Keys.ENTER);
        System.out.println(driver.findElement(By.xpath("//div[@id='result-stats']")).getText());
    }
    @Test
    public void test03(){
        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("The Curious Case of Benjamin Button"+Keys.ENTER);
        System.out.println(driver.findElement(By.xpath("//div[@id='result-stats']")).getText());
    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }
}
