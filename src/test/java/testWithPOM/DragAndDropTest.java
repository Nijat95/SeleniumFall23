package testWithPOM;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DragAndDrop;
import utils.Driver;

import java.time.Duration;

public class DragAndDropTest {
    DragAndDrop dragAndDrop = new DragAndDrop();
    Actions actions = new Actions(Driver.getDriver());
    @BeforeClass
    public void setUp(){
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");
    }

    @Test
    public void DragDropTest(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        actions.dragAndDrop(dragAndDrop.draggable, dragAndDrop.dropTarget).perform();
        Assert.assertTrue(dragAndDrop.dropTarget.getText().contains("You did great!"));
    }
}
