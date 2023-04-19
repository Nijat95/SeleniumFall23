package selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ComplicatedPage {
    public static void main(String[] args) {
        //Navigate to https://ultimateqa.com/complicated-page
        //Input Name (use Random value)
        //Input email
        //Input any messages
        //Add a logic to calculate sum of the 2 numbers(no hard coding please)
        //Input the value of sum
        //Click on submit button

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://ultimateqa.com/complicated-page");
        //Go to section Section of Random Stuff

        WebElement nameFromSectionOne = driver.findElement(By.xpath("//input[@id=\"et_pb_contact_name_0\"]"));
        WebElement emailFromSectionOne = driver.findElement(By.xpath("//input[@id=\"et_pb_contact_email_0\"]"));
        WebElement textBox = driver.findElement(By.xpath("//textarea[@id=\\\"et_pb_contact_message_0\\\"]"));
        WebElement TextOfNumbers = driver.findElement(By.xpath("(//span[@class=\"et_pb_contact_captcha_question\"])[1]"));
        WebElement SumOfNumbers = driver.findElement(By.xpath("//input[@class=\"input et_pb_contact_captcha\"]"));
        WebElement SubmitButton = driver.findElement(By.xpath("//*[@id=\\\"et_pb_contact_form_0\\\"]//button[@type=\\\"submit\\\"]"));


        nameFromSectionOne.sendKeys("Andrew");
        emailFromSectionOne.sendKeys("Andrew@gmail.com");
        textBox.sendKeys("This is a Message to you");
        String textValueOfNumbers = TextOfNumbers.getText();

        int plusSign = textValueOfNumbers.indexOf("+");
        String numOne = textValueOfNumbers.substring(0, plusSign-1);
        String numTwo = textValueOfNumbers.substring(plusSign + 2);

        int one = Integer.parseInt(numOne);
        int two = Integer.parseInt(numTwo);

        int sum = one + two;

        String TotalAmount = Integer.toString(sum);
        SumOfNumbers.sendKeys(TotalAmount);
        SubmitButton.click();
        //String.valueOf()
        //indexOf()
    }
}
