package testNG;

import org.testng.Assert;
import org.testng.annotations.*;

public class FirstPracticeTestNG {
    @BeforeClass
    public void setUp(){
        System.out.println("This is Before class running");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("This is before method running");
    }
    @Test
    public void firstTest(){
        System.out.println("The First test is running");
    }
    @Test
    public void secondTest(){
        System.out.println("The Second test is running");
    }

    @Test
    public void thirdTest(){
        System.out.println("This Third test is running");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("This is After method running");
    }
    @AfterClass
    public void beforeClass(){
        System.out.println("This is After Class running");
    }

    @Test
    public void c_thirdTest(){
       /* System.out.println("This is third test is running");
        if("winter".equals("winter")){
            System.out.println("Test pass");
        }else{
            System.out.println("Test fail");
        }*/
        Assert.assertEquals("one","one","Strings Comparison failed");
        Assert.assertEquals(1,1);
        Assert.assertTrue(true);

    }


}
