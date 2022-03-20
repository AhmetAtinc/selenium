package day04_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class odev {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    //   1.  https://id.heroku.com/login sayfasina gidin

        driver.get("https://id.heroku.com/login");

    //   2.  Bir mail adersi giriniz

        WebElement mail=driver.findElement(By.className("form-control"));
        mail.sendKeys("elbercik@gmail.com");

    //   3.  Bir password giriniz

        WebElement sifre=driver.findElement(By.id("password"));
        sifre.sendKeys("123456");

    //   4.  Login butonuna tiklayiniz

        WebElement login=driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block']"));
        login.submit();

    //   5.  "There was a problem with your login." texti gorunur ise

        System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).isDisplayed() ? "kayit yapilmadi" : "kayit yapildi");



    //   6.  "kayit yapilamadi" yazdiriniz
    //   8.  eger yazi gorunur degilse "kayit yapildi" yazdiriniz
    //   9.  Tum sayfalari kapatiniz

        driver.quit();


    }
}
