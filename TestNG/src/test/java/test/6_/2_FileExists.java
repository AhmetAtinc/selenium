package test.day13;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.FileAssert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExists  {

        @Test
    public void test(){

            System.out.println(System.getProperty("user.home"));

            //masaustundedki deneme klasorurnun path'ini al

            // C:\Users\PC\Desktop\deneme

            // yani dinamik olarak masaustundeki deneme klasorunnun pathini yazmak istersem

            String path= System.getProperty("user.home")+"C:\\Users\\PC\\Desktop\\deneme\\selenium.xlsx";



            System.out.println(path);

            // masaustunde deneme klasoru icerisinde selenium.xlsx isminde bir dosya oldugunu test edin

            // 1- once bu dosyaya ulasmak icin gerekli dinamik path olusturalim

            System.out.println("user.dir : "+System.getProperty("user.dir"));

            String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\deneme\\selenium.xlsx";

            System.out.println(Files.exists(Paths.get(dosyaYolu)));

            //projemizde pom.xml oldugunu test edin

            System.out.println(System.getProperty("user.dir")); // projenin yolunu verir

            String pomPath=System.getProperty("user.dir") + "\\pom.xml";

            Assert.assertTrue(Files.exists(Paths.get(pomPath)));


        }


}
