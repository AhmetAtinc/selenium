package test.day14;

import org.openqa.selenium.*;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;

public class C04_Screenshot extends TestBase {


    @Test
    public void screenTest(){

        driver.get("https://www.google.com");
        // 1. adim screenshot almak icin obje olusturalim ve deger olarak deger olarak driver'imizi atayalim
        // deger olarak driver'imi kabul etmesi icin casting yapmamiz gerekir
        TakesScreenshot screenshot=(TakesScreenshot) driver;


        // 2. adim tum sayfanin screenshot'ini almak icin bir file olusturalim ve
        // dosya yolunu belirtelim

        File tumSayfaSS=new File("src//tumSayfa.png");

        // 3. adim olusturdugumuz file ile takescreenshot objesini iliskilendirelim

        tumSayfaSS=screenshot.getScreenshotAs(OutputType.FILE);

        // eger spesifik bir webelementin screenshot'ini almak istiyorsaniz

        WebElement logoElementi=driver.findElement(By.xpath("(//img[@alt='Google'])[1]"));

     //  File logoResmi=new File();
     //  logoResmi=logoElementi.getScreenshotAs()

    }
}
