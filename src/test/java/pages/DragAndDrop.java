package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class DragAndDrop {

    public DragAndDrop() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@ id=\"draggable\"]")
    public WebElement draggable;

    @FindBy(xpath = "//div[@ id=\"droptarget\"]")
    public WebElement dropTarget;
}
