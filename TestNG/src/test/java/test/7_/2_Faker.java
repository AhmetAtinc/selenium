package test.day14;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Faker extends TestBase {


    @Test
    public void test01() throws InterruptedException {

        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");
        //“create new account”  butonuna basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //“firstName” giris kutusuna bir isim yazin
       WebElement isimKutusu= driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();
        String sifrem=faker.internet().password();

        actions.click(isimKutusu).sendKeys(faker.name().name())

        //“surname” giris kutusuna bir soyisim yazin
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
        //“email” giris kutusuna bir email yazin
                .sendKeys(Keys.TAB)
                .sendKeys(email)
        //“email” onay kutusuna emaili tekrar yazin
                .sendKeys(Keys.TAB)
                .sendKeys(email)
        //Bir sifre girin
                .sendKeys(Keys.TAB)
                .sendKeys(sifrem)
                .sendKeys(Keys.TAB)
                .sendKeys(sifrem)
        //Tarih icin gun secin
                .sendKeys(Keys.TAB)
                .sendKeys("11")
        //Tarih icin ay secin
                .sendKeys(Keys.TAB)
                .sendKeys("Ara")
        //Tarih icin yil secin
                .sendKeys(Keys.TAB)
                .sendKeys("1973")
        //Cinsiyeti secin
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT).perform();
        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        //Sayfayi kapatin

    }
}
