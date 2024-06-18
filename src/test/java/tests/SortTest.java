package tests;

import data.JsonReader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;

public class SortTest extends TestBase{

    LoginPage loginObject ;
    HomePage homeObj ;

    String pageTitle = "Products" ;
    String itemSortedByName = "Test.allTheThings() T-Shirt (Red)" ;
    String itemSortedByPrice = "Sauce Labs Fleece Jacket" ;

    @Test(priority = 1)

    public void loginWithValidUser() throws IOException, ParseException, InterruptedException {
        loginObject = new LoginPage(driver) ;
        String username = JsonReader.jsonData("ValidUser","username") ;
        String password = JsonReader.jsonData("ValidUser","password") ;
        loginObject.enterLoginValidData(username,password);
        Assert.assertEquals(loginObject.getAssertionMsg(),pageTitle);
    }

    @Test(priority = 2)

    public void sortByName()
    {
        homeObj = new HomePage(driver) ;
        homeObj.selectSortByName();
        Assert.assertEquals(homeObj.sortAlphaAssertion(),itemSortedByName);

    }

    @Test(priority = 3)

    public void sortByPrice()
    {
        homeObj = new HomePage(driver) ;
        homeObj.selectSortByPrice();
        Assert.assertEquals(homeObj.sortPriceAssertion(),itemSortedByPrice);

    }
}
