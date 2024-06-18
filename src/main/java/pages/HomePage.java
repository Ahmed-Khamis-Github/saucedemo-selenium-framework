package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver ;




    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By sortSelect = By.className("product_sort_container") ;

    private final By sortAlphaAssertion = By.id("item_3_title_link") ;

    private final By sortPriceAssertion = By.id("item_5_title_link") ;

    private final By item1 = By.id("item_4_title_link") ;
    private final By addToCartBtn = By.id("add-to-cart-sauce-labs-bike-light") ;


    private final By cartBadge = By.className("shopping_cart_badge") ;


    public void selectSortByName()
    {
        PageBase.selectElementByTxt(driver.findElement(sortSelect), "Name (Z to A)" );

    }

    public void selectSortByPrice()
    {
        PageBase.selectElementByTxt(driver.findElement(sortSelect), "Price (high to low)" );

    }

    public void reviewProduct()
    {
        PageBase.clickButton(driver.findElement(item1));
    }

    public void  openCart()
    {
        PageBase.clickButton(driver.findElement(cartBadge));

    }

    public void addToCart()
    {
        PageBase.clickButton(driver.findElement(addToCartBtn));
    }

    public String sortAlphaAssertion ()
    {
        return driver.findElement(sortAlphaAssertion).getText() ;
    }

    public String sortPriceAssertion ()
    {
        return driver.findElement(sortPriceAssertion).getText() ;
    }


    public String cartBadgeIncreasedAssertion ()
    {
      return  driver.findElement(cartBadge).getText() ;
    }


}
