package selenium_intro;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SmartBearHW {
    public static void main(String[] args) {
        //1.Open   browser
        WebDriverManager.chromedriver().setup();
        //TC#2: Smartbear software order placing
        loginToSmartBear(new ChromeDriver());
        //TC#3: Verify Susan McLaren has order on date “01/05/2010”
        checkOrderList(new ChromeDriver());
        CheckOrderList(new ChromeDriver());
    }

    public static void loginToSmartBear(WebDriver driver){

        //2.Go to  website:http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        WebElement username = driver.findElement(By.xpath("//input[@ name=\"ctl00$MainContent$username\"]"));
        WebElement password = driver.findElement(By.xpath("//input[@ name=\"ctl00$MainContent$password\"]"));
        WebElement LoginButton = driver.findElement(By.xpath("//input[@ name=\"ctl00$MainContent$login_button\"]"));

        //3.Enter username: "Tester"
        username.sendKeys("Tester");
        //4.Enter password: "test"
        password.sendKeys("test");
        //5.Click on Login button
        LoginButton.click();
    }
    public static void checkOrderList(WebDriver driver) {
                Faker faker = new Faker();
                String CustomerName = faker.name().fullName();
                String Street = faker.address().streetName();
                String City = faker.address().city();
                String State = faker.address().state();
                String ZipCode = faker.number().digits(6);
                String DebitCard = faker.number().digits(16);

                loginToSmartBear(driver);
                //6.Click on Order
                WebElement OrderOption = driver.findElement(By.xpath("(//ul[@ id=\"ctl00_menu\"]/li)[3]"));
                OrderOption.click();

                //7.Select familyAlbum from product, set quantity to 2
                WebElement DropDown = driver.findElement(By.xpath("//select[@ id=\"ctl00_MainContent_fmwOrder_ddlProduct\"]"));

                Select select = new Select(DropDown);
                select.selectByValue("FamilyAlbum");
                WebElement QuantityBox = driver.findElement(By.xpath("//input[@ id=\"ctl00_MainContent_fmwOrder_txtQuantity\"]"));
                QuantityBox.sendKeys("2");
                //8.Click to "Calculate"button
                WebElement CalculateButton = driver.findElement(By.xpath("//input[@ type=\"submit\"]"));
                CalculateButton.click();

                //•Generate: name, street, city, state, zip code
                WebElement CustomerNameInput = driver.findElement(By.xpath("//input[@ id=\"ctl00_MainContent_fmwOrder_txtName\"]"));
                WebElement StreetInput = driver.findElement(By.xpath("//input[@ id=\"ctl00_MainContent_fmwOrder_TextBox2\"]"));
                WebElement CityInput = driver.findElement(By.xpath("//input[@ id=\"ctl00_MainContent_fmwOrder_TextBox3\"]"));
                WebElement StateInput = driver.findElement(By.xpath("//input[@ id=\"ctl00_MainContent_fmwOrder_TextBox4\"]"));
                WebElement ZipCodeInput = driver.findElement(By.xpath("//input[@ id=\"ctl00_MainContent_fmwOrder_TextBox5\"]"));
                //9.Fill address Info with JavaFaker
                CustomerNameInput.sendKeys(CustomerName);
                StreetInput.sendKeys(Street);
                CityInput.sendKeys(City);
                StateInput.sendKeys(State);
                ZipCodeInput.sendKeys(ZipCode);
                //10.Click on "visa" radio button
                WebElement RadioButton = driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_fmwOrder_cardList_0\"]"));
                RadioButton.click();
                //11.Generate card number using JavaFaker
                WebElement CardInput = driver.findElement(By.xpath("//input[@ id=\"ctl00_MainContent_fmwOrder_TextBox6\"]"));
                CardInput.sendKeys(DebitCard);
                WebElement ExpireDateInput = driver.findElement(By.xpath("//input[@ id=\"ctl00_MainContent_fmwOrder_TextBox1\"]"));
                ExpireDateInput.sendKeys("12/27");
                 //12.Click on "Process"
                WebElement ProcessButton = driver.findElement(By.xpath("//a[@ id=\"ctl00_MainContent_fmwOrder_InsertButton\"]"));
                ProcessButton.click();
                //13.Verify success message "New order has been successfully added."
                String ConfirmationMessage = driver.findElement(By.xpath("//strong")).getText();
                if(ConfirmationMessage.contains("New order has been successfully added.")){
                    System.out.println("Confirmation Message is Displayed");
                }else{
                    System.out.println("Confirmation Message Absent");
                }
    }

    public static void CheckOrderList(WebDriver driver){
        loginToSmartBear(driver);

        //  2. Click on view all orders
        driver.findElement(By.xpath("//li[@ class=\"selected\"]/a[@ href=\"Default.aspx\"]")).click();
        //3. Verify Susan McLaren has order on date “01/05/2010”
        String ClientName = driver.findElement(By.xpath("//table[@ class=\"SampleTable\"]/tbody/tr[6]/td[2]")).getText();
        String OrderDate = driver.findElement(By.xpath("//table[@ class=\"SampleTable\"]/tbody/tr[6]/td[5]")).getText();
        System.out.println(OrderDate);
        if(ClientName.equals("Susan McLaren") && OrderDate.equals("01/05/2010")){
            System.out.println("Susan Mclaren has an order on 01/05/2010");
        }else{
            System.out.println("Susan Mclaren doesn't have an order on 01/05/2010");
        }

    }


}
