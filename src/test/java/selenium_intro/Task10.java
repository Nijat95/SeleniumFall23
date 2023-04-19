package selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task10 {
    public static void main(String[] args) {
        //1. Open browser
        //2. Go to https://amazon.com/
        //3. Enter any search term
        //4. Click search button
        //5. Verify title contains the search term
        //USE CSS SELECTOR TO LOCATE WEBELEMENT

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://amazon.com/");

        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Apple");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        String ExpectedTitle = "Apple";
        String ActualTitle = driver.getTitle();

        System.out.println(ActualTitle);
        if(ActualTitle.contains(ExpectedTitle)){
            System.out.println("Test Pass");
        }else{
            System.out.println("Test Fail");
        }


    }
}
