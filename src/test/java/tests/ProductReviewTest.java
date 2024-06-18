package tests;

import data.JsonReader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import org.testng.annotations.BeforeClass;


import java.io.IOException;

public class ProductReviewTest extends TestBase {

    HomePage homeObj;
    ProductPage productObj;

    LoginPage loginObject;

    String username ;
    String password ;
    String pageTitle ;

    String productTitle  ;
    String productDescription  ;
    String productPrice  ;


    @BeforeClass
    public void setupTestData() throws IOException, ParseException {
        pageTitle = JsonReader.jsonData("PageData", "pageTitle");
        productTitle = JsonReader.jsonData("Product", "title");
        productDescription = JsonReader.jsonData("Product", "description");
        productPrice = JsonReader.jsonData("Product", "price");
        username = JsonReader.jsonData("ValidUser", "username");
        password = JsonReader.jsonData("ValidUser", "password");
    }



    @Test(priority = 1)

    public void loginWithValidUser() throws IOException, ParseException, InterruptedException {
        loginObject = new LoginPage(driver);

         loginObject.enterLoginValidData(username, password);
        Assert.assertEquals(loginObject.getAssertionMsg(), pageTitle);
    }

    @Test(priority = 2)

    public void userCanReviewProduct() {
        homeObj = new HomePage(driver);
        productObj = new ProductPage(driver);

        homeObj.reviewProduct();
        Assert.assertEquals(productTitle, productObj.assertProductTitle());
        Assert.assertTrue(productObj.assertProductDescription().contains(productDescription));
        Assert.assertTrue(productObj.assertProductPrice().contains(productPrice));


    }


}
