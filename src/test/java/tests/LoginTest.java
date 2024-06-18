package tests;

import data.JsonReader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;

public class LoginTest extends TestBase {

    LoginPage loginObject;


    String pageTitle = "Products" ;


    @Test

    public void loginWithValidUser() throws IOException, ParseException, InterruptedException {
        loginObject = new LoginPage(driver) ;
        String username = JsonReader.jsonData("ValidUser","username") ;
        String password = JsonReader.jsonData("ValidUser","password") ;
        loginObject.enterLoginValidData(username,password);
        Assert.assertEquals(loginObject.getAssertionMsg(),pageTitle);
    }


}
