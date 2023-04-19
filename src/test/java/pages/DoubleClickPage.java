package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class DoubleClickPage {

    public DoubleClickPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//p[@ id=\"demo\"]")
    public WebElement colorText;

    @FindBy(xpath = "//iframe[@ id=\"iframeResult\"]")
    public WebElement iFrame;
}
