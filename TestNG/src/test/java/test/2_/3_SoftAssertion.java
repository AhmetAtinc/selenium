package test.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C03_SoftAssertion {

 //   WebDriver driver;
 //   @BeforeClass
 //   public void setup(){
 //       WebDriverManager.chromedriver().setup();
 //       driver=new ChromeDriver();
 //       driver.manage().window().maximize();
 //       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        }

    @Test
    public void test01(){
        int a=10;
        int b=20;
        int c=30;

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(a,b,"1. test basarisiz"); // failed
        softAssert.assertTrue(a>b ,"2. test basarisiz"); // failed
        softAssert.assertTrue(a<c,"3. test basarisiz"); // passed
        softAssert.assertTrue(c>b,"4. test basarisiz"); // passed
        softAssert.assertTrue(c<a,"5. test basarisiz"); // failed

        // assertAll demezsek class calisir ve passed yazar, cunku aslinda raporlama yapmaz sadece kodlar calismis olur

        softAssert.assertAll();
        System.out.println("eger softassert'lerden fail olan varsa bu satir calismaz");

    }

 //   @AfterClass
 //   public void teardown(){
 //       //driver.close();
 //   }
}
