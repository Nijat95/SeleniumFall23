package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium_intro.SmartBearHW;
import utils.Config;

import java.util.List;


public class EditSmartBear {
    // Task DeleteAll
//1. Open a chrome browser
//2. Go to :http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
// 3. Enter username : “Tester”
// 4. Enter password: “test"
// 5. Click on logon button
//6. Click checkAll
//7. Click “Delete Selected”
//8. Assert “List of orders is empty. In order to add new order use  this link.” text is displayed
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }

    @Test
    public void LogIN() {
        WebElement logInInput = driver.findElement(By.cssSelector("input[name=\"ctl00$MainContent$username\"]"));
        WebElement passWordInput = driver.findElement(By.cssSelector("input[name=\"ctl00$MainContent$password\"]"));
        WebElement logInButton = driver.findElement(By.cssSelector("input[name=\"ctl00$MainContent$login_button\"]"));
        logInInput.sendKeys(Config.getProperty("login"));
        passWordInput.sendKeys(Config.getProperty("pass"));
        logInButton.click();


    }
   /*@Test
    public void deleteAllEntries(){
        WebElement checkAllbtn = driver.findElement(By.cssSelector("a[id=\"ctl00_MainContent_btnCheckAll\"]"));
        checkAllbtn.click();
        WebElement deleteBtn = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
        deleteBtn.click();
        WebElement message = driver.findElement(By.cssSelector("div[id=\"ctl00_MainContent_orderMessage\"]"));
        Assert.assertTrue(message.isDisplayed());*/


    @Test
    public void deleteName(){
        //Task 1 —Delete Order
        //1. Open browser and Login to smartBear
        //2. Delete”Mark Smith” from the list
        //3. Assert it is deleted from the list
        String givenName = "Mark Smith";
        //WebElement checkBox = driver.findElement(By.xpath("//table[@class=\"SampleTable\"]/tbody/tr/td[.=\"Mark Smith\"]/../td[1]"));
        WebElement checkBox = driver.findElement(By.xpath("//table[@class=\"SampleTable\"]/tbody/tr/td[.='" + givenName + "']/../td[1]"));
        checkBox.click();
        WebElement deleteBtn1 = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
        deleteBtn1.click();

        List<WebElement> allNames = driver.findElements(By.xpath("//table[@ class=\"SampleTable\"]/tbody/tr/td[2]"));

        for(WebElement names: allNames){
            Assert.assertNotEquals(givenName,names.getText());

        }




    }

    @Test
    public void editOrder(){
        WebElement nameEditButton = driver.findElement(By.xpath("//table[@class=\"SampleTable\"]/tbody/tr/td[.=\"Steve Johns\"]/../td[13]"));
        nameEditButton.click();
        WebElement customerNameInput = driver.findElement(By.xpath("//input[@ id=\"ctl00_MainContent_fmwOrder_txtName\"]"));
        customerNameInput.clear();
        customerNameInput.sendKeys("Philipp Kirkorov");
        WebElement updateButton = driver.findElement(By.xpath("//a[@ id=\"ctl00_MainContent_fmwOrder_UpdateButton\"]")); //
        updateButton.click();
        List<WebElement> allNames = driver.findElements(By.xpath("//table[@ class=\"SampleTable\"]/tbody/tr/td[2]"));
        String givenName = "Philipp Kirkorov";
        for(WebElement names: allNames){
            Assert.assertEquals(names.getText(),givenName);
        }
    }

    public void removeName(WebDriver driver, String givenName){
        SmartBearHW.loginToSmartBear(driver);
        WebElement nameToBeDeleted = driver.findElement(By.xpath("//table[@ class=\"SampleTable\"]/tbody/tr/td[.='"+givenName+"']/../td[1]"));
        nameToBeDeleted.click();
        WebElement deleteSelected = driver.findElement(By.xpath("//input[@ type=\"submit\"]"));
        deleteSelected.click();
        List<WebElement> allNames = driver.findElements(By.xpath("//table[@ class=\"SampleTable\"]/tbody/tr/td[2]"));
        for(WebElement name : allNames){
            Assert.assertNotEquals(givenName,name.getText());
        }

    }
    @Test
    public void verifyRemove(){
        removeName(driver,"Bob Feather");
    }
    @Test
    public void editOrder1(){
        SmartBearHW.loginToSmartBear(driver);
        String givenName = "Steve Johns";
        WebElement editBtn = driver.findElement(By.xpath("//table[@class=\"SampleTable\"]/tbody/tr/td[.='" + givenName + "']/../td[1]"));
        editBtn.click();
        WebElement customerName = driver.findElement(By.xpath("//input[@ id=\"ctl00_MainContent_fmwOrder_txtName\"]"));
        customerName.clear();
        customerName.sendKeys("Phillip Kirkorov");

        WebElement updateButton = driver.findElement(By.xpath("//a[@ id=\"ctl00_MainContent_fmwOrder_UpdateButton\"]"));
        updateButton.click();

        List<WebElement> allNames = driver.findElements(By.xpath("//table[@ class=\"SampleTable\"]/tbody/tr/td[2]"));

        for(WebElement names: allNames){
           if(names.getText().equals("Phillip Kirkorov")){
               Assert.assertEquals(names.getText(),"Phillip Kirkorov", "The name is not on the list");
           }else{
               Assert.fail();
           }
        }
    }

   /*
    @AfterClass
    public void tearDown(){
        driver.quit();
    }*/


}
