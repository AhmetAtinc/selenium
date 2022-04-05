package test.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Duration;
import java.util.Set;

public class C01_WindowHandle {
     WebDriver driver;
     @BeforeClass
     public void setup(){
         WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

     }

     @Test
    public void handleWindow() throws InterruptedException {
         driver.get("https://www.amazon.com");
         System.out.println("ilk sayfanin window handle degeri : "+driver.getWindowHandle());
         String windowHanleDegeri1= driver.getWindowHandle();

         driver.switchTo().newWindow(WindowType.WINDOW); // yeni bir pencere acilir
         driver.get("https://www.bestbuy.com");
         System.out.println("2. sayfanin handle degeri"+driver.getWindowHandle());
         String windowHanleDegeri2= driver.getWindowHandle();

         Set<String> handleDegerleriSet=driver.getWindowHandles();
         System.out.println(handleDegerleriSet);

         driver.switchTo().newWindow(WindowType.TAB);
         driver.get("https://www.facebook.com");

         // amazonun acik oldugu sayfaya gecin ve nutella icin arama yapin
        Thread.sleep(3000);
         driver.switchTo().window(windowHanleDegeri1);
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("nutella"+ Keys.ENTER);

        // besstbuy acik olan sayfaya gecin ve title 'in bestbuy icerdigini test edin

         driver.switchTo().window(windowHanleDegeri2);
         Assert.assertTrue(driver.getTitle().contains("Best Buy"));

         // facebook'un acik oldugu sayfaya gecin ve URL'nin https://www.facebook.com oldugunu test edin
         // eger acik olan pencerelerden sadece birtanesinin window hndle degeri bilinmiyorsa
         // once tum handle degerlerini bulup bir set'e koyariz

         handleDegerleriSet=driver.getWindowHandles();

         // bu soru icin suanda sette 3 window handle degeri var
         // 1. ve 2. sayfanin window handle degerlerini biliyoruz setimizde olup
         // ilk 2 sayfa olmayan handle degeri 3. sayfanin handle degeri olacaktir

         String windowHanleDegeri3="";
         for (String each:handleDegerleriSet) {
             if (!(each.equals(windowHanleDegeri1)||each.equals(windowHanleDegeri2))){
                 windowHanleDegeri3=each;
             }
         }
         System.out.println(windowHanleDegeri3);
         System.out.println(handleDegerleriSet);

         driver.switchTo().window(windowHanleDegeri3);
         Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");
     }

     @AfterClass
    public void teardown(){
         driver.quit();
     }
}
