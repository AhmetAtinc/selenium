package day07_assertions.day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SezgiHocaText {
             //. amazon.com'a git
             // . Belçika'ya teslim et'e tıklayın
            ///3. adrese girmek için tıklayın
            //.e-postanı yaz ve devam et'e tıkla
            ///5.hata sayfasını görürseniz yeni hesap oluşturmak için tıklayın
            //adını yaz
            //7. e-postanı yaz
            ///8.bir şifre oluştur
            // 9. şifrenizi yeniden yazın ve devam edin
            //sayfayı kapat
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void test1(){
          driver.get("https://www.amazon.com");
          driver.findElement(By.id("nav-packard-glow-loc-icon")).click();
//          driver.findElement(By.xpath("//i[@class='a-icon a-icon-dropdown']")).click();
        driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']")).click();
          driver.findElement(By.xpath("//a[text()='Turkey']")).click();
          driver.findElement(By.id("GLUXSignInButton")).click();
          driver.findElement(By.id("createAccountSubmit")).click();// hesap olustur


    }
    @AfterClass
    public static void teardown(){
        //driver.close();
    }

}
