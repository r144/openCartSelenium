/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package po;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import po.Store.StoreBasePage;

/**
 *
 * @author renat
 */
public class CanonEos5dPage extends StoreBasePage{
    @FindBy(css = "select.form-control")
    WebElement color;
    
    @FindBy(id = "cart-total")
    WebElement cartText;
    
    @FindBy(id = "button-cart")
    WebElement AddCartButton;
    
    @FindBy(xpath = "//*[@id=\"alert-box\"]/div")
    WebElement FeedBackMessage;
    
    public String cartTextTest = "1 item(s) - $98.00".trim().toLowerCase();
    public String modifiedMessage
            = "Success: You have added Canon EOS 5D to your shopping cart! ×"
                    .trim().toLowerCase();
    public CanonEos5dPage(WebDriver driver) {
        super(driver);
    }
    public CanonEos5dPage SelectRedColor(){
        color.click();
        color.sendKeys(Keys.ARROW_DOWN);
        color.sendKeys(Keys.ENTER);
        return this;
    }
    public CanonEos5dPage AddtoCart(){
        AddCartButton.click();
        return this;
    }
    public String getFeedBackMessage() {
        return FeedBackMessage.getAttribute("innerText").trim().toLowerCase();
    }
    public String getCartText(){
        return cartText.getAttribute("innerText").trim().toLowerCase();
    }
}
