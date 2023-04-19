package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
1. Navigate to etsy.com
        2. Verify the title of the current window
        3. Search for a product "wooden gift box"
        4. Click on the product any product
        5. Swithc the driver focus to new tab
        7. Get the name of the product in printout
*/

public class Task1 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test
    public void checkTabName(){
        driver.get("https://www.etsy.com/");
        Assert.assertTrue(driver.getTitle().contains("Etsy"));
        WebElement searchBar = driver.findElement(By.xpath("//input[@id=\"global-enhancements-search-query\"]"));
        searchBar.sendKeys("wooden gift Box", Keys.ENTER);
        WebElement selectionOption = driver.findElement(By.xpath("(//div[@data-search-results]//ol/li)[1]"));
        selectionOption.click();

        String mainWindow = driver.getWindowHandle();
        for(String window : driver.getWindowHandles()){
            if(!window.equals(mainWindow)){
                driver.switchTo().window(window);
            }
        }
        System.out.println(driver.getTitle());
    }
}
