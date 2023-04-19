package selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleLocatorsPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
      /*  driver.findElement(By.linkText("Store")).click();

        driver.navigate().back();*/

        //driver.findElement(By.name("q")).sendKeys("chat gpt");
        driver.findElement(By.className("MV3Tnb")).click();
        driver.get("https://www.etsy.com");
        Thread.sleep(3000);
        driver.findElement(By.id("global-enhancements-search-query")).sendKeys("Jewelery", Keys.ENTER);
        driver.findElement(By.tagName("h3"));


    }
}
