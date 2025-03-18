package TestNgClasses;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNgClasses.MyListener.class)
public class MyntraTestPage {

    @Test(groups = {"Regression","Sanity","Functional"})
    void test_Login(){
        System.out.println("Login to Myntra...");
    }

    @Test(priority = 2,dependsOnMethods = "test_Login",groups = {"Regression","Sanity","Functional"})
    void test_Search(){
        Assert.fail();
        System.out.println("Search in Myntra...");
    }

   @Test(priority = 3,dependsOnMethods = "test_Search",groups = {"Regression","Sanity","Functional"})
    void test_AdvanceSearch(){
        System.out.println("Advance Search in Myntra...");
    }


    @Test(priority = 4,dependsOnMethods = "test_Login",groups = "Regression Sanity")
    void test_Logout(){
        System.out.println("Logout Myntra...");
    }
}
