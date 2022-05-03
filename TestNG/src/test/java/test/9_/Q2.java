package test.practice1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q2 {

    /*
birbirine bagimli testler olusturun..
.beforClass olusturup setUp ayarlarini yapin..
  birbirine bagimli testler olusturarak;
      ilk once facebook a gidin
      sonra facebook a bagimli olarak google a gidin,
      daha sonra google a bagimli olarak amazon a gidin
driver i kapatin

 */

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test (dependsOnMethods = "googleTest")
    public void amazonTest(){
        driver.get("https://www.amazon.com");
    }
    @Test (dependsOnMethods = "facebookTest")
    public void googleTest(){
       driver.get("https://www.google.com");
    }
    @Test
    public void facebookTest(){
        driver.get("https://www.facebook.com");
    }

    @AfterClass
    public void teardown(){
        driver.close();
    }
}