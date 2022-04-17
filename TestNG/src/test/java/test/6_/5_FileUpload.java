package test.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;

public class C05_FileUpload extends TestBase {


    @Test
    public void test01(){

        //Tests packagenin altina bir class oluşturun : C05_UploadFile
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        //Yuklemek istediginiz dosyayi secelim.

        // File secme butonunu locate edelim
        WebElement filesecButonu=driver.findElement(By.id("file-upload"));
        // yukleyecegimiz dosyanin dinamik path'ini hazirlayalim

        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\deneme\\selenium.xlsx";

        // sendKeys() ile dinamik path'i dosya sec butonunu yollayalim
        filesecButonu.sendKeys(dosyaYolu);
        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //“File Uploaded!” textinin goruntulendigini test edelim
        
        WebElement sonucYaziElementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(sonucYaziElementi.isDisplayed());



    }

}
