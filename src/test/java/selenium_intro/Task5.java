package selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task5 {
    //        Task #5 -- Basic login authentication
//        1. Open a Chrome browser
//        2. Go to : http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
//        3. Verify title equals -->expected "Web orders Login"
//        4. Enter username : Tester
//        5. Enter Password: test
//        6. Click "Sign In" button
//        7. Verify title equals --> expected Web Orders
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        String ExpectedTitle = "Web Orders Login";
        String ActualTitle = driver.getTitle();
        if(ActualTitle.equals(ExpectedTitle)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        System.out.println(driver.getTitle().contains("Web Orders"));
    }
}
