package selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {
    //        Task# 3
//        1. Open a Chrome browser
//        2. GO to https://google.com/
//        3. Click Gmail from top right
//        4. Verify title contains Expected Gmail
//        5. Go back to Google by using back() command
//        6. Verify title contains "Google"
//        7. Go back to Gmail using forward button
//        8. Verify title contains Expected Gmail

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        driver.findElement(By.linkText("Gmail")).click();
        System.out.println(driver.getTitle().contains("Gmail"));
        driver.navigate().back();
        System.out.println(driver.getTitle().contains("Google"));
        driver.navigate().forward();
        System.out.println(driver.getTitle().contains("Gmail"));
    }
}
