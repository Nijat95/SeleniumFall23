package selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task11 {
    //USE XPATH LOCATOR/ OR cssSELETOR FOR ALL WEBELEMENT LOCATORS
    //Hint use isDisplayed() method

    public static void main(String[] args) throws InterruptedException {
        //Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //2. Go to https://the-internet.herokuapp.com/add_remove_elements/
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        //3. Click to “Add Element” button
        driver.findElement(By.xpath("//button")).click();
        //4. Verify “Delete” button is displayed after clicking.
        System.out.println("Button Displayed? :" + driver.findElement(By.xpath("//button[@class]")).isDisplayed());
        Thread.sleep(3000);
        //5. Click to “Delete” button.
        driver.findElement(By.xpath("//button[@class]")).click();
        //6. Verify “Delete” button is NOT displayed after clicking.
        try {
            System.out.println(driver.findElement(By.xpath("//button[@class]")).isDisplayed());
        }catch (Exception e) {
            System.out.println("Button is not displayed");
        }
    }
}
