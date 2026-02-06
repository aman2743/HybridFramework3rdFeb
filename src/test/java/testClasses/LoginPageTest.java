package testClasses;
import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageClasses.LoginPage;

public class LoginPageTest extends BaseClass {

    @Test
    public void testValidLogin() {
        System.out.println("inside testValidLogin");
        loginPage.login("jsmith", "demo1234");

    }
}