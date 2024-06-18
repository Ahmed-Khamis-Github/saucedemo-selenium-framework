package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;


public class CartPage {

    private final WebDriver driver ;

    private final By item1 = By.id("item_4_title_link") ;

    private final By item2 = By.id("item_0_title_link") ;

    private final By itemOneRemoveBtn = By.id("remove-sauce-labs-backpack") ;

    private final By itemTwoRemoveBtn = By.id("remove-sauce-labs-bike-light") ;

    private final By checkOutBtn = By.id("checkout") ;



    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void removeItemOne()
    {
        PageBase.clickButton(driver.findElement(itemOneRemoveBtn));
    }

    public void removeItemTwo()
    {
        PageBase.clickButton(driver.findElement(itemTwoRemoveBtn));
    }

    public void openCheckoutPage()
    {
        PageBase.clickButton(driver.findElement(checkOutBtn));
    }

    public String itemOneAssertion()
    {
        return  driver.findElement(item1).getText() ;
    }

    public String itemTwoAssertion()
    {
        return  driver.findElement(item2).getText() ;
    }


    public boolean isItemOnePresent() {

        try {
            driver.findElement(By.id("item1"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isItemTwoPresent() {

        try {
            driver.findElement(By.id("item2"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
