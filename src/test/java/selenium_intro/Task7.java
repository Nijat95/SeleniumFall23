package selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task7 {
    //        Task #7 --> Zero Bank header verification
    public static void main(String[] args) {
        //1. Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");
        //3. Check header textExpected --> "Log in to ZeroBank"
        String ExpectedText = "Log in to ZeroBank";
        String ActualText = driver.findElement(By.tagName("h3")).getText();
        if(ActualText.equals(ExpectedText)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        // 4.CLose the session
        driver.close();




    }
}
