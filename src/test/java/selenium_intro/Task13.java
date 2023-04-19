package selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task13 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/checkbox");
        driver.findElement(By.xpath("(//button)[4]")).click();
        driver.findElement(By.xpath("(//span[@class=\"rct-checkbox\"])[1]")).click();
        if(driver.findElement(By.xpath("//div[@id=\"result\"]")).isDisplayed()){
            System.out.println("Test Pass");
        }else{
            System.out.println("Test Fail");
        }

    }
}
