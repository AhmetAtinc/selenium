package work;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q2 {

    @Test
    public void test() throws InterruptedException {
        /*
        ...Exercise1...
        BeforeClass ile driver ı olusturun ve class icinde static yapin
        Maximize edin, 15 sn bekletin
        http://www.google.com adresine gidin
        arama kutusuna "Green Mile" yazip, cikan sonuc sayisini yazdirin
        arama kutusuna  "Premonition" yazip, cikan sonuc sayisini yazdirin
        arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
        AfterClass ile kapatın
     */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("http://www.google.com");
        WebElement searchBox=driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("Green Mile"+ Keys.ENTER);
        System.out.println(driver.findElement(By.xpath("//div[@id='result-stats']")).getText());

        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='q']")).clear();

        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Premonition"+ Keys.ENTER);
        System.out.println(driver.findElement(By.xpath("//div[@id='result-stats']")).getText());

        driver.findElement(By.xpath("//input[@name='q']")).clear();
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("The Curious Case of Benjamin Button"+ Keys.ENTER);
        System.out.println(driver.findElement(By.xpath("//div[@id='result-stats']")).getText());



    }


}
