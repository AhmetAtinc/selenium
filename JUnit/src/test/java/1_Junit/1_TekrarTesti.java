package day07_assertions.day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TekrarTesti {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1-C01_TekrarTesti isimli bir class olusturun
        //2- https://www.google.com/ adresine gidin

        driver.get("https://www.google.com");

        //3- cookies uyarisini kabul ederek kapatin



        //4-Sayfa basliginin “Google” ifadesi icerdigini test edin

        String actualSayfaTitle=driver.getTitle();
        String arananKelime="Google";

        if (actualSayfaTitle.contains(arananKelime)){
            System.out.println("Title testi PASS");
        }else System.out.println("Title testi FAILED");

        //5- Arama cubuguna “Nutella” yazip aratin

        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@name='q']"));
        aramaKutusu.sendKeys("nutella"+ Keys.ENTER);

        //6-Bulunan sonuc sayisini yazdirin

        WebElement sonucSayisi= driver.findElement(By.xpath("//div[@id='result-stats']"));

        System.out.println(sonucSayisi.getText());

        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin

        String sonucSayisiString=sonucSayisi.getText();
        String sonucKelimeleri[]=sonucSayisiString.split(" ");
        String sonucNutellaSayisi=sonucKelimeleri[1]; // 78.900.000

        sonucNutellaSayisi=sonucNutellaSayisi.replace(".","");
        System.out.println(sonucNutellaSayisi);

        int nutAramaSonucu=Integer.parseInt(sonucNutellaSayisi);

        if (nutAramaSonucu>10000000){
            System.out.println("Nutella arama tesi PASS");
        }else   System.out.println("Nutella arama tesi FAILED");


        //8-Sayfayi kapatin

        driver.close();
    }
}
