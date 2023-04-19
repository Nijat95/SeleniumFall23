package selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task6 {
    //Task #6 -- Etsy Title Verification

    public static void main(String[] args) {
        //1. Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //2. Go to https://www.etsy.com/
        driver.get("https://www.etsy.com");

        //        3. Search for gift box
        driver.findElement(By.id("global-enhancements-search-query")).sendKeys("Gift Box", Keys.ENTER);

        //        4. Verify title --> expected Gift box | Etsy
        String ExpectedTitle = "Gift box";
        String ActualTitle = driver.getTitle();
        if(ActualTitle.contains(ExpectedTitle)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }


    }
}
