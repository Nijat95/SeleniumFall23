package selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VerifyOrderDate {
    public static void main(String[] args) {
        //TC#3
        //1. Open browser and login to smartbear software
        //2 . Click on view all orders
        //3. Verify Susan McLaren has order on date “01/05/2010”
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Scanner sc = new Scanner(System.in);
        String name = sc.next();

        verifyOrderDate(new ChromeDriver());
        verifyOrder(new ChromeDriver(),name);
        //printNameAndCities(new ChromeDriver());
        editOrder(driver);


    }
    public static void verifyOrderDate(WebDriver driver){
        SmartBearHW.loginToSmartBear(driver);

        WebElement susanDateInTable = driver.findElement(By.xpath("//td[.=\"Susan McLaren\"]/../td[5]"));

        String actualDate = susanDateInTable.getText();
        String expectedDate = "01/05/2010";

        if (actualDate.equals(expectedDate)) {
            System.out.println("Test Pass");
        } else {
            System.out.println("Test Fail");
        }

    }

    public static void verifyOrder(WebDriver driver, String Givenname) {
        SmartBearHW.loginToSmartBear(driver);
        List <WebElement> allNames = driver.findElements(By.xpath("//table[@ class=\"SampleTable\"]/tbody/tr/td[2]"));

        for(WebElement name : allNames){
            if(name.getText().equals(Givenname)){
                System.out.println(Givenname + " exists on the list");

            }else{
                System.out.println("The name does not exist on the list");
            }
            return;
        }




    }

    public static void printNameAndCities(WebDriver driver) {
        SmartBearHW.loginToSmartBear(driver);
        List<WebElement> webName = driver.findElements(By.xpath("//table[@class=\"SampleTable\"]/tbody/tr/td[2]"));
        List<WebElement> cityName = driver.findElements(By.xpath("//table[@class=\"SampleTable\"]/tbody/tr/td[7]"));

        for (int i = 0; i < cityName.size(); i++) {
            System.out.println("Name : " + webName.get(i).getText() + " | City : " + cityName.get(i).getText());
        }


    }
    public static void editOrder(WebDriver driver){
        SmartBearHW.loginToSmartBear(driver);
        WebElement nameEditButton = driver.findElement(By.xpath("//table[@class=\"SampleTable\"]/tbody/tr/td[.=\"Steve Johns\"]/../td[13]"));
        nameEditButton.click();
        WebElement customerNameInput = driver.findElement(By.xpath("//input[@ id=\"ctl00_MainContent_fmwOrder_txtName\"]"));
        customerNameInput.clear();
        customerNameInput.sendKeys("Philipp Kirkorov");
        WebElement updateButton = driver.findElement(By.xpath("//a[@ id=\"ctl00_MainContent_fmwOrder_UpdateButton\"]"));
        updateButton.click();

    }

}
