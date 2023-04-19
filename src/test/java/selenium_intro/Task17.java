package selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task17 {
    public static void main(String[] args) {
        //TC #1: Smartbear   software    link    verification
        //1.Open   browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
       /* WebElement UserNameInput =  driver.findElement(By.xpath("//input[@ name=\"ctl00$MainContent$username\"]"));
        WebElement PasswordInput =  driver.findElement(By.xpath("//input[@ name=\"ctl00$MainContent$password\"]"));
        WebElement LoginButton = driver.findElement(By.xpath("//input[@ name=\"ctl00$MainContent$login_button\"]"));

        UserNameInput.sendKeys("Tester");
        PasswordInput.sendKeys("test");
        LoginButton.click();*/

        List<WebElement> list = driver.findElements(By.xpath("//body//a"));
        int WebElementCount = 0;
        for(WebElement element : list){
            System.out.println(element.getText());
            WebElementCount++;
        }
        System.out.println(WebElementCount);
        //2.Go to  website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        // 3.Enter username: "Tester"
        //4.Enter password: "test"
       // 5.Click to Login button
       // 6. Print out count of all the links on landing page
        //7.Print out each link text on this page

      //  Mini-Task:
       // 1. Create a method called loginToSmartBear
       // 2. This method simply logs in to SmartBear when you call it


    }

    public static void loginToSmartBear(WebDriver driver){
        WebElement username = driver.findElement(By.xpath("//input[@ name=\"ctl00$MainContent$username\"]"));
        WebElement password = driver.findElement(By.xpath("//input[@ name=\"ctl00$MainContent$password\"]"));
        WebElement LoginButton = driver.findElement(By.xpath("//input[@ name=\"ctl00$MainContent$login_button\"]"));

        username.sendKeys("Tester");
        password.sendKeys("test");
        LoginButton.click();


    }
}
