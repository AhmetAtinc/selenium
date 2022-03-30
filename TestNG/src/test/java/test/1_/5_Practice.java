package test.day08;

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

public class Homework {
    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin

    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com");
    }
    @Test (priority = 0)
    public void test01(){
        //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String actualTitleTest=driver.getTitle();
        String expectedTitleTest="YouTube";
        Assert.assertTrue(actualTitleTest.contains(expectedTitleTest));
    }
    @Test (priority = 1)
    public void test02(){
        //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement imageTest=driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        imageTest.isDisplayed();
    }
    @Test (priority = 2)
    public void test03(){
        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBoxTest=driver.findElement(By.xpath("(//div[@id='search-container'])[1]"));
        searchBoxTest.isEnabled();
    }

    @Test (priority = 3)
    public void test04(){
        //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualTitleTest=driver.getTitle();
        String expectedTitleTest="youtube";
        Assert.assertFalse(actualTitleTest.contains(expectedTitleTest));

    }

    @AfterClass
    public void teardown(){
        //driver.close();
    }

}
