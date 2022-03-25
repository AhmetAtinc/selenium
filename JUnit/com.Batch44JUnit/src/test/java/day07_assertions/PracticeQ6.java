package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


public class PracticeQ6 {

     /*
     ...Exercise3...
    // http://the-internet.herokuapp.com/add_remove_elements/
    // click on the "Add Element" button 100 times
    // write a function that takes a number, and clicks the "Delete" button
    // given number of times, and then validates that given number of
    // buttons was deleted
    1.method : createButtons(100)
    2.deleteButtonsAndValidate()
 */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");


        createButton(driver,100);

        deleteButton(driver,60);
    }
    private static void createButton(WebDriver driver, int eklenecekSayi) {
        WebElement addElement=driver.findElement(By.xpath("//button[@onclick='addElement()']"));

        for (int i = 0; i < eklenecekSayi; i++) {
            addElement.click();
        }

    }

    private static void deleteButton(WebDriver driver, int silinecekSayi) {

        List<WebElement> elements=driver.findElements(By.xpath("(//button[@class='added-manually'])"));
        int sizeBeforeElement=elements.size();

        List<WebElement> buttonsDelete=driver.findElements(By.xpath("(//button[@class='added-manually'])"));
        int sayac=0;

        for (WebElement w:buttonsDelete) {
            sayac++;
            if (sayac>silinecekSayi){
                break;
            }
            w.click();
        }

          List<WebElement> elementAfter= driver.findElements(By.xpath("(//button[@class='added-manually'])"));
            int sizeafterDelete=elementAfter.size();

            if ((sizeBeforeElement-silinecekSayi)==sizeafterDelete){
                System.out.println("sizeAfterDelete = "+sizeafterDelete);
                System.out.println("Success");
            }else {
                System.out.println("Fail");
            }

    }



}


