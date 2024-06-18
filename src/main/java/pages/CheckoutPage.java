package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private final WebDriver driver ;

    private final By fNameTxt = By.id("first-name") ;
    private final By lNameTxt  = By.id("last-name") ;

    private final By postalCodeTxt  = By.id("postal-code") ;

    private final By continueBtn  = By.id("continue") ;
    private final By finishBtn  = By.id("finish") ;

    private final By completeAlert = By.className("complete-header") ;


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCheckoutData(String fName ,String lName , String postalCode)
    {
        PageBase.setTxtToElement(driver.findElement(fNameTxt), fName );
        PageBase.setTxtToElement(driver.findElement(lNameTxt), lName );
        PageBase.setTxtToElement(driver.findElement(postalCodeTxt), postalCode );
        PageBase.clickButton(driver.findElement(continueBtn));
        PageBase.clickButton(driver.findElement(finishBtn));


    }

    public String completeOrderAssertionMsg()
    {
        return driver.findElement(completeAlert).getText() ;
    }
}
