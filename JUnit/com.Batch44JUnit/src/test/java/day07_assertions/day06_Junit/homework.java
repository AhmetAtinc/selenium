package day07_assertions.day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

////● https://www.amazon.com/ adresine gidin.
////            - Test 1
////    Arama kutusunun yanindaki kategori menusundeki kategori
////    sayisinin 45 oldugunu test edin
////-Test 2
////            1. Kategori menusunden Books secenegini secin
////2. Arama kutusuna Java yazin ve aratin
////3. Bulunan sonuc sayisini yazdirin
////4. Sonucun Java kelimesini icerdigini test edin
//}
public class homework {
  static WebDriver driver;

    @Test
    public  void test01(){

    List<WebElement> actualKategoriElementi= driver.findElements(By.xpath("//option"));
    int expectedKategoriElementi=45;
        System.out.println(" Kategori sayisi : "+actualKategoriElementi.size());
        System.out.println(actualKategoriElementi.size()==expectedKategoriElementi? "Kategori sayisi testi PASS":" Kategori sayisi testi FAILED");

    }
    @Test
    public void test02(){
       driver.findElement(By.xpath("//option[6]")).click();
       driver.findElement(By.xpath("//div[@class='nav-search-scope nav-sprite']")).click();
       WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
       aramaKutusu.sendKeys("java"+Keys.ENTER);
       WebElement bulunanSonucSayisi=driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
       System.out.println(bulunanSonucSayisi.getText());
       WebElement actualSonuc=driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
       String expectedSonuc="java";
       System.out.println(actualSonuc.getText().contains(expectedSonuc)? " Sonuc testi PASS": " Sonuc testi FAILED");

     //   System.out.println("Test 02");
     //   driver.findElement(By.xpath("(//option)[6]")).click();
     //   WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
     //   searchBox.sendKeys("Java" + Keys.ENTER);
     //   List<WebElement> javaResultNumber = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
     //   System.out.println("Result Numbers : " + javaResultNumber.size());
     //   String actualWriting = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).getText();
     //   String expected = "Java";
     //   System.out.println(actualWriting.contains(expected) ? "Java testi PASSED" : "Java testi FAILED");
    }

    @BeforeClass
    public static void ayar(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");

    }

    @AfterClass
    public static void son(){
        driver.close();
    }
}
