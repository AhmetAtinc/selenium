package day07_assertions.day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class Deneme {
    static WebDriver driver;

    @BeforeClass
    public static void aramaMotoru(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void demoqa(){
        driver.get("https://www.google.com");
      WebElement aramaMotoru= driver.findElement(By.xpath("//input[@name='q']"));
        aramaMotoru.sendKeys("demoqa"+ Keys.ENTER);
       driver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']")).click();
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.id("proceed-link")).click();
        driver.findElement(By.xpath("(//div[@class='card-up'])[1]")).click();
        driver.findElement(By.xpath("(//span[@class='text'])[1]")).click();
        WebElement username=driver.findElement(By.xpath("//input[@autocomplete='off']"));
        username.sendKeys("samuel");
        WebElement email=driver.findElement(By.xpath("(//input[@autocomplete='off'])[2]"));
        email.sendKeys("samuel@gmail.com");
        WebElement adress=driver.findElement(By.xpath("//textarea[@placeholder='Current Address']"));
        adress.sendKeys("nyc");
        WebElement permanentAdress=driver.findElement(By.xpath("(//textarea[@rows='5'])[2]"));
        permanentAdress.sendKeys("bos");
    //    WebElement reklamKaldir= driver.findElement(new By.ByCssSelector("path[d='M0,0l15,0l0,15l-15,0Z']"));
    //    reklamKaldir.click();
        driver.findElement(By.xpath("//img[@src='https://ad.plus/adplus-advertising.svg']")).click(); //reklam asagi indir
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
    }

    @Test
    public void test2(){
        // tum girilen bilgileri kontrol edin
        WebElement actualName=driver.findElement(By.xpath("//p[@id='name']"));
        String expectedName="samuel";
        System.out.println(actualName.getText().contains(expectedName)? " Name testi PASS": " Name testi FAILED");
        driver.findElement(By.xpath("(//span[@class='text'])[2]")).click();
        driver.findElement(By.cssSelector("svg[class='rct-icon rct-icon-expand-close']")).click();
        WebElement checkBox=driver.findElement(By.cssSelector("svg[class='rct-icon rct-icon-uncheck']"));
      //  checkBox.click();
        Assert.assertTrue(checkBox.isEnabled());
    }

    @AfterClass
    public static void kapat(){
        //driver.close();
    }
}
