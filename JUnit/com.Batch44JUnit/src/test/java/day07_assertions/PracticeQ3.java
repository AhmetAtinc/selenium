package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PracticeQ3 {
    ///*
    //...Exercise2...
    //   http://www.bestbuy.com 'a gidin,
    //   Sayfa basliginin "Best" icerdigini(contains) dogrulayin
    //   Ayrica Relative Locator kullanarak;
    //       logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
    //       mexicoLinkTest => Linkin gorunutulenip goruntulenmedigini dogrulayin
    //
    //*/
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test
    public void test(){
        driver.get("http://www.bestbuy.com");
        String title=driver.getTitle();
        Assert.assertTrue(title.contains("Best"));
        WebElement logo=driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
        WebElement mexico=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(mexico.isDisplayed());

    }

}
