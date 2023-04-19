package selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task14 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //RadioButons:
        //--> 1. Navigate to
        driver.get("https://demoqa.com/radio-button");
       // 2. Select "Impresive" button
        driver.findElement(By.xpath("//label[@for=\"impressiveRadio\"]")).click();
       // 3. Verify the Text is dispalyed
        if(driver.findElement(By.xpath(" //span[.=\"Impressive\"]")).isDisplayed()){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
       // 4. Verify No button is disabled
        WebElement noRadio = driver.findElement(By.xpath("//label[@ for=\"noRadio\"]"));
        if(!noRadio.isEnabled()){
            System.out.println("Test Pass");
        }else{
            System.out.println("Test failed");
        }

    }
}
