package selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstAutomation {
    public static void main(String[] args) {
        // this line will create connection between Selenium and WebDriver
        WebDriverManager.chromedriver().setup();
        // we create instance of chrome driver
        WebDriver driver = new ChromeDriver();
        String webAddress = "https://www.qa.google.com";
        // next line it will navigate to google website
        driver.get("https://www.google.com");

        System.out.println(driver.getTitle());
        driver.get("https://www.etsy.com");


        driver.navigate().forward();
        System.out.println(driver.getTitle());
        driver.close();
    }


}
