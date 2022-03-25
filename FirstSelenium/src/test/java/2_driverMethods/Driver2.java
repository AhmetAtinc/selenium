package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverGetMethodlari {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");

        WebDriver driver=new ChromeDriver();

        driver.get("https://www.amazon.com");

        System.out.println(driver.getTitle()); // sayfanin title'ini getirir

        System.out.println(driver.getCurrentUrl()); // sayfanin url adresini getirir

        System.out.println(driver.getWindowHandle()); // CDwindow-8460A6A73582A773606EB737A4BF0BA9

        System.out.println(driver.getPageSource()); //

    }
}
