package test.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.security.Key;
import java.time.Duration;

public class Homework {
    //Yeni bir Class Olusturun : D11_SoftAssert1
    //1. “https://www.hepsiburada.com/” Adresine gidin


    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test01(){
        driver.get("https://www.hepsiburada.com/");
        //2. Basliginin “Turkiye’nin En Buyuk Alisveris Sitesi" icerdigini dogrulayin

        SoftAssert softAssert=new SoftAssert();

        String actualTitle= driver.getTitle();
             String exceptedTitle="Türkiye'nin En Büyük Alışveriş Sitesi";
           softAssert.assertEquals(actualTitle,exceptedTitle,"title hatali*************************");

    //    String exceptedTitle="Türkiye'nin En Büyük Online Alışveriş Sitesi";
    //    softAssert.assertTrue(actualTitle.contains(exceptedTitle));


        //3. search kutusuna araba yazip arattirin

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("araba"+ Keys.ENTER);
        //4. bulunan sonuc sayisini yazdirin
       WebElement actualSonucElementi= driver.findElement(By.xpath("(//div[@class='searchResultSummaryBar-summary'])[1]"));

    //  String actualSonuc=actualSonucElementi.getText();
      System.out.println(driver.findElement(By.xpath("(//div[@class='searchResultSummaryBar-summary'])[1]")).getText());

        //5. sonuc yazisinin "araba" icerdigini dogrulayin
        String actualSonuc=actualSonucElementi.getText();
            String expectedSonuc="araba";
           softAssert.assertTrue(actualSonuc.contains(expectedSonuc),"araba hata");

        //6. Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin
        String expectedSonuc1="oto";
        softAssert.assertFalse(actualSonuc.contains(expectedSonuc1),"oto hata");

        softAssert.assertAll();
    }

    @AfterClass
    public void teardown(){
        driver.close();
    }

}
