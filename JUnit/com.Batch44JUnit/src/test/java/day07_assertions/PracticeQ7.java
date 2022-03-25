package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.security.Key;
import java.time.Duration;

public class PracticeQ7 {

    // /*
    //    ...Exercise4...
    //    https://www.teknosa.com/ adresine gidiniz
    //    arama cubuguna oppo yazip enter deyiniz
    //    sonuc sayisini yazdiriniz
    //    cikan ilk urune tiklayiniz
    //    sepete ekleyiniz
    //    sepetime git e tiklayiniz
    //    consol da "Sipariş Özeti" webelementinin text ini yazidiriniz
    //    Alisverisi tamamlayiniz
    //    son alarak da "Teknosa'ya hoş geldiniz"  webelementinin text ini yazidiriniz
    //    driver i kapatiniz
    //*/
   static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test(){
        driver.manage().deleteAllCookies();
        //    https://www.teknosa.com/ adresine gidiniz
        driver.get("https://www.teknosa.com/");
        ChromeOptions op = new ChromeOptions();
        //disable notification parameter
        op.addArguments("--disable-notifications");
        driver.findElement(By.id("search-input")).sendKeys("oppo" + Keys.ENTER);
        System.out.println("sonuc yazisi : " +driver.findElement(By.className("plp-info")).getText());
        driver.findElement(By.xpath("(//a[@class ='prd-link'])[1]")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,200)");
        driver.findElement(By.id("addToCartButton")).click();
        driver.findElement(By.xpath("//a[@class ='btn btn-secondary']")).click();
        System.out.println("siparis ozeti yazisi : " + driver.findElement(By.className("cart-sum-title")).getText());
        driver.findElement(By.xpath("//a[@title ='Alışverişi Tamamla']")).click();
        System.out.println("hosgeldiniz yazisi :" + driver.findElement(By.xpath("//div[.='Teknosa’ya hoş geldiniz']")).getText());
        driver.close();


    }

    @AfterClass
    public static void tearDown(){
        //driver.close();

    }


}
