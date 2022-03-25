package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PracticeQ4 {
    // /*
    //   ...Exercise6...
    //// 1. Amazon.com'a gidelim.
    //// 2. DropDown üzerinde Books secelim.(All yazan yerde)
    ////    kategorilerin hepsini konsola yazdiralim
    //// 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
    //// 4. Sonuc sayisini ekrana yazdiralim.
    //// 5. Sonucların Les Miserables i icerdigini assert edelim
    //*/
static WebDriver driver;
    @BeforeClass
    public static void ayar(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }
    @Test
    public void test1(){
        WebElement dropDown=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(dropDown);
        List<WebElement> liste=select.getOptions();

        for (WebElement each:liste) {
            System.out.println(each.getText()+" ");
        }
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Les Miserables"+ Keys.ENTER);

        WebElement sonuclar= driver.findElement(By.xpath(("//div[@class='a-section a-spacing-small a-spacing-top-small']")));
        String actualSonuc=sonuclar.getText();
        Assert.assertTrue(actualSonuc.contains("Les Miserables"));



    }
}
