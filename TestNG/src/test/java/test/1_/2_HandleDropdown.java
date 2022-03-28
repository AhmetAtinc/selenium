package test.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C02_HandleDropdown {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void dropdownTesti(){
        //Dropdown'da var olan seceneklerden birini secmek icin
        // 1. adim: Dropdown webelementini locate edip bir degiskene atiyoruz
        driver.get("https://www.amazon.com");
        WebElement dropdownElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        // 2. adim : Select class'indan bir obje olusturalim ve parametre olarak locate ettigimiz webelementi yazalim
        Select select=new Select(dropdownElementi);

        // 3. adim : Select objesini kullanarak select Class'indan var olan 3 secim methodundan
        // istedigimizi kullanarak dropdown'da var olan ğption'lardan birini secebiliriz
        // secim yapmamiza yardim eden bu 3 method void'dir dolayisiyla bize bir sey dondurmezler

        select.selectByIndex(3);

        // eger sectigimiz option degerini yazdirmak istersek getFirstSelectedOption() donus verir
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByVisibleText("Deals");

        select.selectByValue("search-alias=arts-crafts-intl-ship");

        List<WebElement> optionList =select.getOptions();
    String str="";
        for (WebElement each: optionList) {

            System.out.println(each.getText()+" ");
            str+=each.getText();
        }
        System.out.println(str+" ");
    }
    @AfterMethod
    public void teardown(){
        driver.close();
    }

}
