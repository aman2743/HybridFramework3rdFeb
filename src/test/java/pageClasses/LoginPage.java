package pageClasses;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ElementUtil;

public class LoginPage {

    // Fields - all private
    private WebDriver driver;
    private final ElementUtil eleUtil;

    // Locators - use simpler strategies when possible
    @FindBy(id = "uid")  // Prefer ID over XPath
    private WebElement usernameField;

    @FindBy(id = "passw")
    private WebElement passwordField;

    @FindBy(name = "btnSubmit")  // Prefer name over XPath
    private WebElement loginButton;

    @FindBy(xpath="/html/body/table[2]/tbody/tr/td[2]/div/h1")
    private WebElement welcomeTextElement;

    // Constructor
    public LoginPage(WebDriver driver) {
        System.out.println("inside LoginPage constructor");
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver cannot be null!");
        }
        this.driver = driver;
        this.eleUtil = new ElementUtil(driver);
        PageFactory.initElements(this.driver, this);
    }

    // Page actions
    public void login(String username, String password) {
        eleUtil.doSendKeys(usernameField, username);
        eleUtil.doSendKeys(passwordField, password);
        eleUtil.doClick(loginButton);
    }

    // Alternative: Fluent pattern (returns next page)
    public HomePage loginAndGoToHome(String username, String password) {
        login(username, password);
        return new HomePage(driver);
    }

    // Optional: Verification method
    public String currentURL() {
         return eleUtil.doGetCurrentUrl();
    }

    public boolean isWelcomeTextShown() {
            String str=eleUtil.getTextFromElement(welcomeTextElement);
            if(!str.isEmpty()){
                return true;
            }
            else{
                return false;
            }
    }
}


