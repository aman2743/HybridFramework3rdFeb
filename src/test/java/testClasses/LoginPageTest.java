package testClasses;

import constants.AppConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentTest;
import base.BaseClass;
import pageClasses.HomePage;
import utility.ExtentReportManager;

public class LoginPageTest extends BaseClass {

    @Test(description = "Verify user can login with valid credentials")
    public void testValidLogin() {
        ExtentTest test = ExtentReportManager.getTest();
        loginPage.login("jsmith", "demo1234");
        // Verify login success
        boolean isLoggedIn = loginPage.isWelcomeTextShown();
        if (isLoggedIn) {
            System.out.println("Login successful - Welcome text displayed");
        } else {
            System.out.println("Login failed - Welcome text not displayed");
        }
        Assert.assertTrue(isLoggedIn, "Login failed - welcome message not displayed");
    }
}