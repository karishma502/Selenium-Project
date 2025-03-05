package TestNgClasses;

import org.testng.annotations.Test;

public class FaceBookSignInpage {

    @Test(priority = 1,groups = "Regression")
    void test_Login(){
        System.out.println("Login to Facebook...");
    }

    @Test(priority = 2,dependsOnMethods = "test_Login",groups = "Regression")
    void test_Search(){
        System.out.println("Search in Facebook...");
    }

    @Test(priority = 3,dependsOnMethods = "test_Search",groups = "Regression")
    void test_AdvanceSearch(){
        System.out.println("Advance Search in Facebook...");
    }


    @Test(priority = 4,dependsOnMethods = "test_Login",groups = "Regression")
    void test_Logout(){
        System.out.println("Logout from Facebook...");
    }
}
