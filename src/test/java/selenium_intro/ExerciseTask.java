package selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciseTask {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2ftestcomplete12%2fweborders%2fDefault.aspx");

        driver.findElement(By.cssSelector("input[name*=\"username\"]")).sendKeys("Tester");
        driver.findElement(By.cssSelector("input[name=\"ctl00$MainContent$password\"]")).sendKeys("test");
        driver.findElement(By.cssSelector("input[class*=\"button\"]")).click();


    }


}

class ExerciseTask2{
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2ftestcomplete12%2fweborders%2fDefault.aspx");

        driver.findElement(By.xpath("//div[@class]/input[@name=\"ctl00$MainContent$username\"]")).sendKeys("Tester");
        driver.findElement(By.xpath("//div[@class]/input[@name=\"ctl00$MainContent$password\"]")).sendKeys("test");
        driver.findElement(By.xpath("//div[@class]/input[@ name=\"ctl00$MainContent$login_button\"]")).click();



    }
}