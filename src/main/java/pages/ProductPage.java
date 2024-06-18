package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    private final WebDriver driver ;

    private final By productTitle=  By.cssSelector(".inventory_details_name");

    private final By productDesc=  By.cssSelector(".inventory_details_desc");


    private final By productPrice=  By.cssSelector(".inventory_details_price");


    private  final  By addToCartBtn = By.id("add-to-cart") ;




    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }


    public void addToCart()
    {
        PageBase.clickButton(driver.findElement(addToCartBtn));
    }


    public String assertProductTitle ()
    {
        return  driver.findElement(productTitle).getText() ;
    }

    public String assertProductDescription ()
    {
        return  driver.findElement(productDesc).getText() ;
    }

    public String assertProductPrice ()
    {
        return  driver.findElement(productPrice).getText() ;
    }


}
