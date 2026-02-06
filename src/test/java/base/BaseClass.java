package base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import factory.BrowserFactory;
import pageClasses.*;
import utility.ElementUtil;

public class BaseClass {
    protected Properties prop;
    protected LoginPage loginPage;
    protected ElementUtil eleUtil;
    protected SoftAssert softAssert;
    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

	public BaseClass() {
        System.out.println("inside BaseClass constructor");
		File f = new File(".\\src\\test\\resources\\config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(f);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
            throw new RuntimeException("Failed to load configuration", e);
		}
        softAssert=new SoftAssert();
	}

	@BeforeTest
	public void init() {
            String browserName = prop.getProperty("browser");
            String url = prop.getProperty("url");
            WebDriver driver = BrowserFactory.createInstance(browserName);
            drivers.set(driver);
        if (getDriver() == null) {
            throw new RuntimeException("Driver initialization failed!");
        }
            getDriver().manage().deleteAllCookies();
            getDriver().get(url);
            getDriver().manage().window().maximize();
            loginPage = new LoginPage(getDriver());
	}

	public WebDriver getDriver() {
		return drivers.get();
		
	}

//@AfterTest
//public void tearDown() {
//    if (getDriver() != null) {
//        getDriver().quit();
//    }
//    drivers.remove();  // Critical for thread cleanup
//}
}
