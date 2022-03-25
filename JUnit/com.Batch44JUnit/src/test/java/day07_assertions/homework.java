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

public class homework {



  static   WebDriver driver;
  static WebElement aramaKutusu;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(" http://n11.com");
        aramaKutusu=driver.findElement(By.id("searchData"));

    }
    @Test
    public void test01(){
        //test1
        //n11 sayfasına git,
        //JBL kulaklık arat,
        //gelen ilk ürünü tıkla
        //ürünü sepete ekle
        aramaKutusu.sendKeys("JBL kulaklık"+ Keys.ENTER);
        driver.findElement(By.xpath("(//img[@alt='JBL C200SI Mikrofonlu Kulak İçi Kulaklık'])[1]")).click();
        driver.findElement(By.xpath("(//a[@class='btn btnGrey addBasketUnify'])[1]")).click();
        driver.findElement(By.xpath("//img[@src='https://n11scdn.akamaized.net/a1/org/21/04/01/67/61/13/35/59/54/78/68/68/62194584164326158720.svg']")).click();
    }

    @Test
    public void test02() throws InterruptedException {
        //test2
        //JBL Blutoth hoparlör arat,
        //gelen ilk ürüne tıkla
        //ürünü sepete ekle
     //   driver.findElement(By.xpath("(//button[@class='dn-slide-deny-btn'])[1]")).click();
     //   Thread.sleep(3000);
        aramaKutusu=driver.findElement(By.id("searchData"));
        aramaKutusu.sendKeys("JBL bluetooth"+Keys.ENTER);
        driver.findElement(By.xpath("(//img[@alt='JBL Tune T500BT Bluetooth 4.1 Kulak Üstü Kulaklık'])[1]")).click();
        driver.findElement(By.xpath("(//a[@title='Sepete Ekle'])[1]")).click();

//
     //// driver.findElement(By.xpath("//span[@class='icon iconSearch']")).click();
     //// driver.navigate().back();
     //// Thread.sleep(3000);
     //// aramaKutusu.click();
     // aramaKutusu.sendKeys("JBL bluetooth"+Keys.ENTER);

    }

    @Test
    public void test03(){
        //test3
        //sepete git,
        //kaç tane ürün olduğuna bak,
        //ürünlerin seçilen ürün olup olmadığını doğrula

        driver.findElement(By.xpath("//i[@class='icon iconBasket']")).click();
        driver.findElement(By.xpath("(//span[@class='btn btnBlack'])[1]")).click();

    }

    @AfterClass
    public static void teardown(){
     //   driver.close();
    }
}
