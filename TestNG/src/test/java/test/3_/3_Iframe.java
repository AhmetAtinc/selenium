package test.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C03_Iframe {
    // ● Bir class olusturun: IframeTest


    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void iFrmeTesti() {

        //   ● https://the-internet.herokuapp.com/iframe adresine gidin.
        //   ● Bir metod olusturun: iframeTest
        //        ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda    yazdirin.

    driver.get("https://the-internet.herokuapp.com/iframe");
    WebElement istenenYaziElementi=driver.findElement(By.tagName("h3"));

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(istenenYaziElementi.isDisplayed(),"iframe yazisi gorunmuyor");
        System.out.println(istenenYaziElementi.getText());


        //        ○ Text Box’a “Merhaba Dunya!” yazin.

        // yazi yazmak istedigimiz text kutusu iframe'nin icinde oldugundan direk ulasamiyoruz
        // once iframe'yi locate edip, onun icine swtich yapmaliyiz
        WebElement iframe=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);

        WebElement textBox=driver.findElement(By.tagName("p"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya!");

        //        ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu     dogrulayin ve  konsolda yazdirin.

        // yukarida iframenin icine switch yaptigimizda yeniden disari cikmak istedigimizde ansayfaya donmeliyiz
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();

        // sponsored yazisi yeni sayfada oldugundan ve driver eski sayfada oldugundan yaziyi locate edemedi
        WebElement sponsoredYazisi=driver.findElement(By.xpath("//p[text()='Sponsored by ']"));
        softAssert.assertTrue(sponsoredYazisi.isDisplayed(),"Sponsored yazisi gorunmuyor");

    softAssert.assertAll();
    }




    @AfterClass
    public void teardown(){
      //  driver.quit();
    }

}
