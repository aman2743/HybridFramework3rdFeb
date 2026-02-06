package utility;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

public class ElementUtil  {

	public WebDriver driver;
    private Actions act;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
        System.out.println("ElementUtil initialized with driver: " + driver);
		act = new Actions(driver);
//		js = (JavascriptExecutor) driver;
	}

	public void doSendKeys(WebElement element,String value) {
		element.sendKeys(value);
	}
	
  public void doClick(WebElement element) {
		element.click();
	}

    public void doSelectRadioButton(WebElement element) {
        element.click();
    }

    public String doElementGetText(WebElement element){
        String elementText = element.getText();
        System.out.println("Element text is ====>" + elementText);
        return elementText;
    }


    public boolean checkElementIsDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public String getElementAttribute(WebElement element, String attrName) {
        return element.getAttribute(attrName);
    }

    public boolean checkElementIsDisabled(WebElement element) {
        String disabledValue = element.getAttribute("disabled");
        assert disabledValue != null;
        if (disabledValue.equals("true")) {
            return true;
        }
        return false;
    }

}
