package selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task4 {
    //Task #4
//            1. Open Chrome browser
//2. Go to google.com
//3. Write "apple" in search box
//4. Click google search button
//5. Verify title it should contain a word "apple"
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("apple");
        //alternate driver.findElement(By.name("q")).sendKeys("apple", Keys.ENTER);
        driver.findElement(By.name("btnK")).click();
        System.out.println(driver.getTitle().contains("apple"));
        String expectedTitle = "apple";
        String actualTitle = driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Test Pass");
        }else{
            System.out.println("Test Fail");
        }
    }
}
