/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package po.Store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import po.CanonEos5dPage;

/**
 *
 * @author renat
 */
public class ProductComparison extends StoreBasePage{
    @FindBy(xpath = "//*[@id=\"content\"]/table/tbody[2]/tr/td[2]/a")
    WebElement IphoneRemove;

    @FindBy(xpath = "//*[@id=\"button-confirm\"]")
    WebElement CannonAddToCart;
    
    @FindBy(xpath = "//*[@id=\"product-compare\"]/div[1]")
    WebElement FeedBackMessage;
    
    public String modifiedMessage 
            = "Success: You have modified your product comparison! ×"
                    .trim().toLowerCase();
    public ProductComparison(WebDriver driver) {
        super(driver);
    }
    public ProductComparison removeIphone(){
        IphoneRemove.click();
        return this;
    }
    public CanonEos5dPage AddToCartCannon(){
        CannonAddToCart.click();
        return new CanonEos5dPage(driver);
    }
    public String getFeedBackMessage() {
        return FeedBackMessage.getAttribute("innerText").trim().toLowerCase();
    }

    
}
