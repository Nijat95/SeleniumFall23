package pageObjectModel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import utils.Driver;

public class AmazonHomePage {
    WebDriver driver;

    public AmazonHomePage(WebDriver driver) {

        this.driver = driver;
    }
    By searchbox = By.xpath("//input[@type=\"text\"]");
    By searchButton = By.xpath("//input[@ id=\"nav-search-submit-button\"]");

    By allCategoryBtn = By.xpath("//a[@ id=\"nav-hamburger-menu\"]");
    By bestSellersBtn = By.xpath("//a[@ href=\"/gp/bestsellers/?ref_=nav_em_cs_bestsellers_0_1_1_2\"]");

    By newReleasesBtn = By.xpath("//a[@ href=\"/gp/new-releases/?ref_=nav_em_cs_newreleases_0_1_1_3\" ]");

    By moversNShakersBtn = By.xpath("//a [@ href=\"/gp/movers-and-shakers/?ref_=nav_em_ms_0_1_1_4\"]");

    public void searchAmazon(String SearchInput){ 
        try{
            driver.findElement(searchbox).sendKeys(SearchInput);
            driver.findElement(searchButton).click();
        }catch(Exception e){
            System.out.println("Exception Caught: " + e.getMessage());
        }
    }
    public void allCategoryMenu() throws InterruptedException {
        driver.findElement(allCategoryBtn).click();
        driver.findElement(bestSellersBtn).click();
        Thread.sleep(1000);
        driver.navigate().back();
        driver.findElement(allCategoryBtn).click();
        driver.findElement(newReleasesBtn).click();
        driver.navigate().back();
        driver.findElement(allCategoryBtn).click();
        driver.findElement(moversNShakersBtn).click();
        driver.navigate().back();

    }


}
