package tests;

import data.JsonReader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;

public class CheckoutTest extends  TestBase{
    LoginPage loginObject;
    HomePage homeObj ;
    CheckoutPage checkoutObj ;

    ProductPage productObj ;

    CartPage cartObj ;

    String username ;
    String password ;
    String productTitle  ;
    String fnName  ;

    String lnName  ;

    String postalCode  ;


    String pageTitle ;

    @BeforeClass
    public void setupTestData() throws IOException, ParseException {
        pageTitle = JsonReader.jsonData("PageData", "pageTitle");
        username = JsonReader.jsonData("ValidUser", "username");
        password = JsonReader.jsonData("ValidUser", "password");
        productTitle = JsonReader.jsonData("Product", "title");
        fnName = JsonReader.jsonData("checkOutData", "fnName");
        lnName = JsonReader.jsonData("checkOutData", "lnName");
        postalCode = JsonReader.jsonData("checkOutData", "postalCode");
    }



    @Test(priority = 1)

    public void loginWithValidUser() throws IOException, ParseException, InterruptedException {
        loginObject = new LoginPage(driver);

        loginObject.enterLoginValidData(username, password);
        Assert.assertEquals(loginObject.getAssertionMsg(), pageTitle);
    }


    @Test(priority = 2)
    public void userCanAddItemsToCart()
    {
        homeObj = new HomePage(driver) ;
        homeObj.addToCart();
        Assert.assertEquals(homeObj.cartBadgeIncreasedAssertion(),"1");
        homeObj.reviewProduct();
        productObj = new ProductPage(driver) ;
        productObj.addToCart();
        Assert.assertEquals(homeObj.cartBadgeIncreasedAssertion(),"2");
        homeObj.openCart();
        cartObj = new CartPage(driver) ;
        Assert.assertTrue(cartObj.itemOneAssertion().contains(productTitle));

    }

    @Test(priority = 3)
    public void userCanCheckoutOrder()
    {
        cartObj.openCheckoutPage();
        checkoutObj = new CheckoutPage(driver) ;
        checkoutObj.enterCheckoutData(fnName,lnName,postalCode);
        Assert.assertTrue(checkoutObj.completeOrderAssertionMsg().contains("Thank you for your order"));


    }


}
