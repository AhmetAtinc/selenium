package test.day12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class C02_MouseActions extends TestBase {

    // amazon anasayfaya gidin sag ustte hello sign in elementinin uzerinde maouse bekletin acilan menude
    // new list linkine tiklayin ve new list sayfasinin acildigini test edin

    @Test
    public void amazonList() throws InterruptedException {
    driver.get("https://www.amazon.com");
        Actions actions=new Actions(driver);
        WebElement helloElement=driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        actions.moveToElement(helloElement).perform();

  //  Thread.sleep(3000);
        WebElement listeElementi=driver.findElement(By.xpath("//span[text()='Create a List']"));
        actions.click(listeElementi).perform();

        String actualTitle= driver.getTitle();
        String arananMetin="Your List";

        Assert.assertTrue(actualTitle.contains(arananMetin));
    }

}
