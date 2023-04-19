package pageObjectTest;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjectModel.AmazonHomePage;
import testNG.Practice;
import testNG.Priority;
import utils.Config;
import utils.Driver;

public class TestAmazonPage {
    AmazonHomePage page = new AmazonHomePage(Driver.getDriver());
    Faker faker = new Faker();
    @BeforeClass
    public void setUp(){
        Driver.getDriver().get(Config.getProperty("urlAmazon"));
    }

    @Test(priority = 1)
    public void searchTest(){
        String book = faker.book().title();
        page.searchAmazon(book);
        Assert.assertTrue(Driver.getDriver().getTitle().contains(book));
        Driver.getDriver().navigate().back();
    }
    @Test(priority = 2)
    public void allCategoriesMenuTest() throws InterruptedException {
        page.allCategoryMenu();
    }


    @AfterTest
    public void tearDown(){
        Driver.quitDriver();
    }
}
