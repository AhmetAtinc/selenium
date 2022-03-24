package day05_mavenProjeOlusturma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class demoqa {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://demoqa.com");

        driver.findElement(By.id("details-button")).click();

        driver.findElement(By.xpath("//img[@class='banner-image']")).click();

    //    driver.findElement(By.linkText("Browser Windows")).click();

    //    driver.findElement(By.xpath("(//span[@class='text'])[11]")).click();



        driver.findElement(By.id("proceed-link")).click();


    }
}
