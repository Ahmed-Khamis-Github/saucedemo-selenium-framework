package tests;

import data.JsonReader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;

import java.io.IOException;

public class AddToCartTest extends TestBase{

    LoginPage loginObject;
    HomePage homeObj ;

    ProductPage productObj ;

    CartPage cartObj ;

    String username ;
    String password ;
    String productTitle  ;

    String pageTitle ;

    @BeforeClass
    public void setupTestData() throws IOException, ParseException {
        pageTitle = JsonReader.jsonData("PageData", "pageTitle");
        username = JsonReader.jsonData("ValidUser", "username");
        password = JsonReader.jsonData("ValidUser", "password");
        productTitle = JsonReader.jsonData("Product", "title");
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

    public void userCanRemoveItemsFromCart()
    {
        cartObj.removeItemOne();
        cartObj.removeItemTwo();
        Assert.assertFalse(cartObj.isItemOnePresent(), "Item one was not removed from the cart.");
        Assert.assertFalse(cartObj.isItemTwoPresent(), "Item two was not removed from the cart.");

    }


}
