package pageClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ElementUtil;

public class HomePage {

    // Fields - all private
    private WebDriver driver;
    private final ElementUtil eleUtil;

    // Locators - use simpler strategies when possible
    @FindBy(id = "uid")  // Prefer ID over XPath
    private WebElement usernameField;


    // Constructor
    public HomePage(WebDriver driver) {
        System.out.println("inside LoginPage constructor");
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver cannot be null!");
        }
        this.driver = driver;
        this.eleUtil = new ElementUtil(driver);
        PageFactory.initElements(this.driver, this);
    }


}


