package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_YoutubeAssertions {
    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
   static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
    }
    @Test
    public void titleTest(){
        //    ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
       String actualTitleElementi=driver.getTitle();
       String expectedTitleElementi="YouTube";
        Assert.assertEquals("aEquals : ",actualTitleElementi,expectedTitleElementi);
        Assert.assertTrue("aTrue : ",actualTitleElementi.equals(expectedTitleElementi));
    }
    @Test
    public void imageTest(){
//    ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement logoTesti=driver.findElement(By.xpath("(//div[@class='style-scope ytd-topbar-logo-renderer'])[1]"));
        Assert.assertTrue("logo test : ",logoTesti.isDisplayed());
    }
    @Test
    public void searchBoxTest(){
        //     ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchTesti=driver.findElement(By.xpath("//div[@id='search-container']"));
        Assert.assertTrue(searchTesti.isEnabled());
    }
    @Test
    public void wrongTitleTest(){
        //    ○ wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin
       String actualTitle=driver.getTitle();
        String expectedTitle="youtube";

        Assert.assertFalse("aFalse : ",actualTitle.equals(expectedTitle));
    }
    @AfterClass
    public static void teardown(){
      // driver.close();
    }

}
