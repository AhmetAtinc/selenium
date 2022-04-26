package test.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class C02_ScreenshotWebelement extends TestBase {


    @Test
    public void nutellaTesti() throws IOException {

        // amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
        // nutella icin arama yapalim
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYazisi=sonucYazisiElementi.getText();
        System.out.println(sonucYazisi);
        Assert.assertTrue(sonucYazisi.contains("Nutella"));

        // testin calistiginin ispati icin sonuc yazsisi Webelementinin screenshot'ini alalim

        // onuc yazsisi Webelementinin screenshot icin 4 adim gerekli
        // 1- adim screenshot cekecegimiz webelementi locate edelim

        TakesScreenshot tss=(TakesScreenshot) driver;

        // 2. adim screenshot'i kaydedecegimiz bir file olusturalim

        File webelementsSS=new File("target/screenShot/webelement.jpeg");
        // 3.adim

        File geciciResim=sonucYazisiElementi.getScreenshotAs(OutputType.FILE);


        // 4.adim gecici resmi kayit yapacagimiz asil dosyaya kopyalayalim

        FileUtils.copyFile(geciciResim,webelementsSS);

    }

}
