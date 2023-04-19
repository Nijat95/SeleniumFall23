package selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task15 {
    public static void main(String[] args) {
        //Task #14 - Check all link on the page
        //Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //Go to https://www.technovaschool.com/
        driver.get("https://www.technovaschool.com/");
        driver.manage().window().maximize();
        //Count the number of the links on the web-page (expected 41)
        List<WebElement> list = driver.findElements(By.xpath("//body//a"));
        int linkOnPage = list.size();
        if(linkOnPage == 30){
            System.out.println("Test 1 Pass");
        }else{
            System.out.println("Test 1 Fail");
        }
        int linkWithoutText = 0;
        for(WebElement element : list){
            System.out.println(element.getText());
            if(element.getText().isEmpty()){
                linkWithoutText++;
            }
        }

        if(linkWithoutText == 16){
            System.out.println("Test Pass");
        }else{
            System.out.println("Test Fail");
        }
//        Print out all the texts of the links on the page
//        Count the number of the links that doesn’t have text (expected 19)
    }
}
