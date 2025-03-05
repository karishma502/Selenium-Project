package TestNgClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonSignInPage {

    @Test(priority = 1,
    groups = "Sanity")
    void test_Login(){
        System.out.println("Login to Amazon...");
    }

    @Test(priority = 2,dependsOnMethods = "test_Login",groups = "Sanity")
    void test_Search(){
        System.out.println("Search in Amazon...");
    }

    @Test(priority = 3,dependsOnMethods = "test_Search",groups = "Sanity")
    void test_AdvanceSearch(){
        System.out.println("Advance Search in Amazon...");
    }


    @Test(priority = 4,dependsOnMethods = "test_Login",groups = "Sanity")
    void test_Logout(){
        System.out.println("Logout from  Amazon...");
    }
}

