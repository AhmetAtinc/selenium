package test.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_Allerts {
//● Bir class olusturun: Alerts
//● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
//● Bir metod olusturun: acceptAlert
// ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
//     “You successfully clicked an alert” oldugunu test edin.
//● Bir metod olusturun: dismissAlert
//        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
////        “successfuly” icermedigini test edin.
//● Bir metod olusturun: sendKeysAlert
// //        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
////        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

    WebDriver driver;
    WebElement sonucYazisiElement;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void acceptAlertTesti(){
        //        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının

    driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
    driver.switchTo().alert().accept();
        //        “You successfully clicked an alert” oldugunu test edin.
        sonucYazisiElement=driver.findElement(By.xpath("//p[@id='result']"));

        String actualSonucYazisi=sonucYazisiElement.getText();
        String expectedSonucYazisi="You successfully clicked an alert";
        Assert.assertEquals(actualSonucYazisi,expectedSonucYazisi);

    }

    @Test
    public void dismissAlertTesti(){
        //        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının

    driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
//        “successfuly” icermedigini test edin.
        sonucYazisiElement=driver.findElement(By.xpath("//p[@id='result']"))  ;
        String actualSonucYazisi=sonucYazisiElement.getText();
        String istenmeyenKelime="successfuly";
        Assert.assertFalse(actualSonucYazisi.contains(istenmeyenKelime));
    }

    @Test
    public void sendKeysTesti(){
        //        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
//        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
    driver.switchTo().alert().sendKeys("mehmet");
    driver.switchTo().alert().accept();
    sonucYazisiElement=driver.findElement(By.xpath("//p[@id='result']"));
    String actualSonucYazisi=sonucYazisiElement.getText();
    String exceptedText="mehmet";
        Assert.assertTrue(actualSonucYazisi.contains(exceptedText));
    }
    @AfterClass
    public void teardown(){
        driver.close();
    }
}
