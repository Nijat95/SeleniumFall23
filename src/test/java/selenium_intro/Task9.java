package selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


// Task #9 HerokuApp Url verification
public class Task9 {
    public static void main(String[] args) {
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //2. Go to https://the-internet.herokuapp.com/forgot_password
        driver.get("https://the-internet.herokuapp.com/forgot_password");
        //3. Enter any email into input box
        driver.findElement(By.name("email")).sendKeys("13456@gmail.com");
        //4. Click on Retrieve password
        driver.findElement(By.id("form_submit")).click();
        String ExpectedUrl = "Internal Server Error";
        String ActualUrl = driver.findElement(By.tagName("h1")).getText();
        if(ActualUrl.equals(ExpectedUrl)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
//
//        5. Verify URL contains Expected : -->  "Internal Server Error"
    }
}
