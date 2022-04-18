package test.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_Senkronizasyon extends TestBase {


    @Test
    public void test01() throws InterruptedException {
        /*
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-submit")).click();
    */
        /*
        driver.get("https://www.youtube.com");
        driver.findElement(By.xpath("//yt-formatted-string[text()='I Agree']")).click();
*/
        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("(//a[text()='info@techproeducation.com'])[2]")).click();
        Thread.sleep(5000);

        // https://the-internet.herokuapp.com/dynamic_controls sayfasina gidin
        // disable butununa basin
        // disabled yazisinin ciktigini test edin

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//button[text()='Enable']")).click();

     //   Thread.sleep(2000);

        WebElement itsDisabledYaziElementi= driver.findElement(By.xpath("//p[text()=\"It's enabled!\"]"));
        Assert.assertTrue(itsDisabledYaziElementi.isDisplayed());


    }
}