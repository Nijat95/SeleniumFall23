package testWithPOM;

import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.RightClickPage;
import utils.Driver;

public class RightClickTest {
    RightClickPage rightClickPage = new RightClickPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void testRightClick(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");
        actions.contextClick(rightClickPage.Square).perform();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

    }
}
