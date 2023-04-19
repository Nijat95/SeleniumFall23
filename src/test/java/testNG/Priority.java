package testNG;

import org.testng.annotations.Test;

public class Priority {

    @Test(priority = 1)
    public void test1() {
        System.out.println("Test 1 is Running");
    }
    @Test(priority = 2)
    public void test2() {
        System.out.println("Test 2 is Running");
    }
    @Test(priority = 3)
    public void test3() {
        System.out.println("Test 3 is Running");
    }
    @Test(priority = 4)
    public void test4() {
        System.out.println("Test 4 is Running");
    }
    @Test(dependsOnMethods = "test2")
    public void test5() {
        System.out.println("Test 5 is Running");
    }
}
