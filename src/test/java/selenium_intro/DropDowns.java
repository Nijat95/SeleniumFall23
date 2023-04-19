package selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDowns {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");

        WebElement dropdown = driver.findElement(By.xpath("//option[@ value=\"volvo\"]/.."));
        Select select = new Select(dropdown);

        select.selectByVisibleText("Volvo");
        select.selectByIndex(2);
        select.selectByValue("opel");


    }
}
