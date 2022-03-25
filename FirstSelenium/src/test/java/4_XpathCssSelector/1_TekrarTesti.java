package day04_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TekrarTesti {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //   sayfasına gidin. https://www. amazon.com/

        driver.get("https://www.amazon.com/");

        //    b. Search(ara) “city bike” yazip aratiniz

        WebElement aramaKutusu=driver.findElement(By.xpath("twotabsearchtextbox"));
        aramaKutusu.sendKeys("city bike" + Keys.ENTER);
      //  aramaKutusu.submit(); istersek Keys.ENTER yerine bu satiri da yazabiliriz


        //    c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın

     //   WebElement sonucYazisiElementi=driver.findElement(By.className("sg-col-inner"));
     //   System.out.println(sonucYazisiElementi.getText());


        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='sg-col-14-of-20 sg-col s-breadcrumb sg-col-10-of-16 sg-col-6-of-12']"));
          System.out.println(sonucYazisiElementi.getText());



        //    e. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.

        //        WebElement ilkResim=driver.findElement(By.className("s-image"));
        //        ilkResim.click();

        // sadece click yapmak gib basit bir islemde kullanacagimiz webElementler icin
        // veriable olusturmadan direk locate edip, istedigimiz islemi yapabiliriz
        driver.findElement(By.className("s-image")).click();
    }
}
//*[@id="search"]/span/div/h1/div/div[1]/div/div/span[1]