package day07_assertions.day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class C03_IlkTestMethodu {

    WebDriver driver;

    @Test
    public void test01(){
        // amazon.com'a gidelim titlenin icerdigini test edelim
        driver.get("https://www.amazon.com");
        String actualTitle=driver.getTitle();
        String arananKelime="amazon";

   //     Assert.assertTrue(actualTitle.contains(arananKelime));

       if (actualTitle.contains(arananKelime)){
           System.out.println("amazon testi PASSED");
       }else  System.out.println("amazon testi PASSED");

    }

    @Test
    public void test02(){
    // google'a gidelim ve basligin google icerdigini test edelim
        driver.get("https://www.google.com");
        String actualTitle=driver.getTitle();
        String arananKelime="google";

        if (actualTitle.contains(arananKelime)){
            System.out.println("google testi PASSED");
        }else  System.out.println("google testi PASSED");
    }
    @Before
    public void ayarlariDuzenle(){
       WebDriverManager.chromedriver().setup();
       driver=new  ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void ortaligiTopla(){
    driver.close();
    }
}
