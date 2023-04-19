package selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmartBearMethodTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        SmartBearHW.loginToSmartBear(driver);
        VerifyOrderDate.verifyOrder(driver,"Phillip Kirorov");
        VerifyOrderDate.printNameAndCities(driver);
    }
}
