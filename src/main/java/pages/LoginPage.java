package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By userNameTxt = By.id("user-name");
    private final By passwordTxt = By.id("password");

    private final By loginBtn = By.id("login-button") ;

    private final By loginAssertion = By.className("title") ;

    public void enterLoginValidData(String userName , String password) throws InterruptedException {
         PageBase.setTxtToElement(driver.findElement(userNameTxt) , userName);

        PageBase.setTxtToElement(driver.findElement(passwordTxt),password);

        PageBase.clickButton(driver.findElement(loginBtn));


    }

    public String  getAssertionMsg()
    {
        return driver.findElement(loginAssertion).getText() ;
    }


}
