package work;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Q1 {
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void test(){
        WebElement checkBox1=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkBox2=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        System.out.println(checkBox1.isEnabled());
        System.out.println(checkBox2.isEnabled());
        System.out.println(checkBox1.isSelected());
        System.out.println(checkBox2.isSelected());
        //c. Checkbox1 seçili değilse onay kutusunu tıklayın
        Assert.assertFalse(checkBox1.isSelected());
        checkBox1.click();

    }

    @After
    public void teardown(){
       driver.close();
    }

}
