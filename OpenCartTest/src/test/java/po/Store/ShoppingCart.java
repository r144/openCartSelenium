/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package po.Store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author renat
 */
public class ShoppingCart extends StoreBasePage{
    @FindBy(xpath = "//*[@id=\"content\"]/div[3]/div[2]/a")
    WebElement checkoutButton;
    
    public ShoppingCart(WebDriver driver) {
        super(driver);
    }
    
    public CheckoutPage goToChechout(){
        checkoutButton.click();
        return new CheckoutPage(driver);
    }
    
}
