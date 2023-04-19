package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmartBearLogin {
    WebDriver driver;

    By userName = By.xpath("//input[@ name=\"ctl00$MainContent$username\"]");
    By password = By.xpath("//input[@ name=\"ctl00$MainContent$password\"]");
    By submitBtn = By.xpath("//input[@ name=\"ctl00$MainContent$login_button\"]");
    public SmartBearLogin(WebDriver driver){
        this.driver = driver;

    }
    public void loginSmartBear(String UserNameInput) {
        driver.findElement(userName).sendKeys(UserNameInput);
    }
    public void enterPassword(String PasswordInput) {
        driver.findElement(password).sendKeys(PasswordInput);
    }

    public void ClickSubmitBtn(){
        driver.findElement(submitBtn).click();
    }
}
