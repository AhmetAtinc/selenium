package test.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C04_Dropdown {
    //● Bir class oluşturun: C3_DropDownAmazon
    //● https://www.amazon.com/ adresine gidin.



        WebDriver driver;
    WebElement dropElementi;
    Select select;

        @BeforeClass
        public void setup(){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            //● https://www.amazon.com/ adresine gidin.
            driver.get("https://amazon.com");
        }

        @Test (priority = 1)
        public void dropdownTesti() {
            //- Test 1
            //    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
            WebElement dropDownElementi = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
            select=new Select(dropDownElementi);

            List<WebElement> optionListesi=select.getOptions();

            int actualOptionSayisi=optionListesi.size();
            int expectedOptionSayisi=45;

           Assert.assertEquals(actualOptionSayisi,expectedOptionSayisi);


        }


            @Test (priority = 2)
            public void dropdownTesti2(){
                //-Test 2
                //    1. Kategori menusunden Books secenegini  secin
            select.selectByVisibleText("Books");


                //    2. Arama kutusuna Java yazin ve aratin

                driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);

                //    3. Bulunan sonuc sayisini yazdirin

            WebElement sonucSayisi=driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
                System.out.println(sonucSayisi.getText());

                //    4. Sonucun Java kelimesini icerdigini test edin

               String actualSonucSayisiYazisi=sonucSayisi.getText();
               String expectedSonucYazisi="Java";

               Assert.assertTrue(actualSonucSayisiYazisi.contains(expectedSonucYazisi));

            }



    @AfterMethod
    public void teardown(){
        //driver.close();
    }
}
