package day07_assertions.day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_AramaTesti {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. “https://www.saucedemo.com” Adresine gidin

        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna “standard_user” yazdirin

        WebElement username=driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        //3. Password kutusuna “secret_sauce” yazdirin

        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        //4. Login tusuna basin

        driver.findElement(By.id("login-button")).click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin

        WebElement ilkUrun=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String alinanUrun=ilkUrun.getText();
        ilkUrun.click();

        //6. Add to Cart butonuna basin

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        //7. Alisveris sepetine tiklayin

        driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin

        WebElement kontrol=driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        String kontrolText=kontrol.getText();

        if (kontrolText.equals(alinanUrun)){
            System.out.println("Urun ismi testi PASS");
        }else {
            System.out.println("Urun ismi testi FAILED");
        }
        //9. Sayfayi kapatin

       // driver.close();


    }
}
