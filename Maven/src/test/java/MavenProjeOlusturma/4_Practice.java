package day05_mavenProjeOlusturma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Homework {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // //1. Bir class oluşturun: LocatorsIntro
        //    //2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
        //        // a. http://a.testaddressbook.com adresine gidiniz.

        driver.get("http://a.testaddressbook.com");

        //        // b. Sign in butonuna basin

        driver.findElement(By.id("sign-in")).click();

        //        // c. email textbox,password textbox, and signin button elementlerini locate ediniz..

        WebElement textBox=driver.findElement(By.id("session_email"));
        WebElement password=driver.findElement(By.id("session_password"));
        WebElement sign=driver.findElement(By.xpath("//input[@type='submit']"));


        //        // d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        //        // i. Username : testtechproed@gmail.com
       textBox.sendKeys("testtechproed@gmail.com");
        //        // ii.Password : Test1234!
        password.sendKeys("Test1234!");
        sign.click();
        //        // e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).

       WebElement expectedEleman=driver.findElement(By.xpath("//span[@class='navbar-text']"));

       String user="testtechproed@gmail.com";
       String expec=expectedEleman.getText();

        System.out.println(expec.equals(user)? " Pass": "Failed");

        //        // f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).

        WebElement adres= driver.findElement(By.linkText("Addresses"));
        System.out.println(adres.isDisplayed()? " Pass":" Failed");

        WebElement out= driver.findElement(By.linkText("Sign out"));
        System.out.println(out.isDisplayed()? " Pass":" Failed");

        //    //3. Sayfada kac tane link oldugunu bulun.

        List<WebElement> linkAdet= driver.findElements(By.tagName("a"));
        System.out.println(linkAdet.size());

        //    //4.Linklerin yazisini nasil yazdirabiliriz

        for (WebElement e:linkAdet) {
            System.out.println(e.getText());
        }
        //    //5. driver i kapatin

    driver.close();

    }
}
