package selenium_intro;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Task16 {
    public static void main(String[] args) {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String PhoneNumber = faker.phoneNumber().cellPhone();
        String EmailAddress = faker.expression(firstName + lastName +"@gmail.com");
        String address = faker.address().streetAddress();
        String city = faker.address().cityName();
        String State = faker.address().stateAbbr();
        String zipCode = faker.address().zipCode();


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.guru99.com/test/newtours/register.php");

        WebElement firstNameInput = driver.findElement(By.xpath("//input[@name=\"firstName\"]"));
        WebElement lastNameInput = driver.findElement(By.xpath("//input[@name=\"lastName\"]"));
        WebElement phoneInput = driver.findElement(By.xpath("//input[@name=\"phone\"]"));
        WebElement emailInput = driver.findElement(By.xpath("//input[@name=\"userName\"]"));
        WebElement AddressInput = driver.findElement(By.xpath("//input[@name=\"address1\"]"));
        WebElement cityInput = driver.findElement(By.xpath("//input[@name=\"city\"]"));
        WebElement StateInput = driver.findElement(By.xpath("//input[@name=\"state\"]"));
        WebElement PostalCodeInput = driver.findElement(By.xpath("//input[@name=\"postalCode\"]"));
        WebElement dropdown = driver.findElement(By.xpath("//select[@name='country']"));
        Select select = new Select(dropdown);

        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        phoneInput.sendKeys(PhoneNumber);
        emailInput.sendKeys(EmailAddress);
        AddressInput.sendKeys(address);
        cityInput.sendKeys(city);
        StateInput.sendKeys(State);
        PostalCodeInput.sendKeys(zipCode);
        select.selectByVisibleText("ARUBA");
        //select.selectByIndex(2);
        //select.selectByValue("BARBADOS");
        WebElement firstOption = select.getFirstSelectedOption();
        System.out.println(firstOption.getText());
        List<WebElement> dropDownOption = select.getOptions();

        select.getOptions();


    }
}
