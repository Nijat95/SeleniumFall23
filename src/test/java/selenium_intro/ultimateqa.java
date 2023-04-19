package selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ultimateqa {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //Navigate to https://ultimateqa.com/complicated-page
        driver.get("https://ultimateqa.com/complicated-page");
        //Go to section Section of Random Stuff
        //Input Name (use Random value)
        driver.findElement(By.xpath("(//input[@ type=\"text\"])[1]")).sendKeys("Random");
        //Input email
        driver.findElement(By.xpath("(//input[@ type=\"text\"])[2]")).sendKeys("Random@Gmail.com");
        //Input any messages
        driver.findElement(By.xpath("(//textarea)[1]")).sendKeys("This is a Random Text");
        //Add a logic to calculate sum of the 2 numbers(no hard coding please)
        String Number = driver.findElement(By.xpath("(//p[@ class=\"clearfix\"]/span)[1]")).getText();
        //System.out.println(Number.substring(0,2));
        String Number1 = "";
        for(int i = 0; i < Number.length(); i++){
            if(Number.charAt(i) == ' '){
                break;
            }else{
                Number1 += Number.charAt(i);
            }
        }
        String Number2 = "";
        for(int i = Number.length()-1; i > 0; i--){
            if(Number.charAt(i) == ' '){
                break;
            }else{
                Number2 += Number.charAt(i);
            }
        }
        String Number22 = new StringBuilder(Number2).reverse().toString();
        int a = Integer.parseInt(Number1);
        int b = Integer.parseInt(Number22);
        int c = a + b;
        String Answer = Integer.toString(c);
        //Input the value of sum
        driver.findElement(By.xpath("(//input[@ type=\"text\"])[3]")).sendKeys(Answer);
        //Click on submit button
        driver.findElement(By.xpath("(//button[@ type=\"submit\"])[2]")).click();



    }

}
