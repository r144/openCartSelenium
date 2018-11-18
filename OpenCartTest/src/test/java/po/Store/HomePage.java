/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package po.Store;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author renat
 */
public class HomePage extends StoreBasePage {

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[2]/div/div[3]/button[3]")
    WebElement IphoneCompare;
    
    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[3]/div/div[3]/button[3]")
    WebElement CannonCompare;
    
    @FindBy(xpath = "//*[@id=\"alert-box\"]/div/a[2]")
    WebElement CompareLink;
    
    @FindBy(xpath = "//*[@id=\"alert-box\"]/div")
    WebElement FeedBackMessage;
    
    @FindBy(xpath = "//*[@id=\"alert-box\"]/div/a[2]")
    WebElement ShoppingCart;    
    
    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[1]")
    WebElement AddMacToCartButton;
    
    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[2]")
    WebElement AddMacToWishListButton;
    
    @FindBy(name = "search")
    WebElement SearchInput;
    
    @FindBy(xpath = "//*[@id=\"search\"]/div/button")
    WebElement searchButton;
    
    @FindBy(xpath = "//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/a/span")
    WebElement MyAccount;
    
    @FindBy(xpath = "//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/div/a[2]")
    WebElement Login;
    
    public String IphoneCompareFeedBack
            = "Success: You have added iPhone to your product comparison! ×"
                    .trim().toLowerCase();
    
    public String MacAddedToCartMessage
            = "Success: You have added MacBook to your shopping cart! ×"
                    .trim().toLowerCase();
    
    public String CanonCompareFeedBack
            = "Success: You have added Canon EOS 5D to your product comparison! ×"
                    .trim().toLowerCase();
    
    public String MacAddedToWishListMessageLogin
            = "You must login or create an account to save MacBook to your wish list! ×"
                    .trim().toLowerCase();
    
    public String pageTitle = "Your Store";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void addIphoneToCompare() {
        IphoneCompare.click();
    }

    public void addCannonToCompare() {
        CannonCompare.click();
    }
    public ProductComparison goToComparedItens(){
        CompareLink.click();
        return new ProductComparison(driver);
    }
    public String getFeedBackMessage(){
        return FeedBackMessage.getAttribute("innerText").trim().toLowerCase();
    }
    public HomePage AddMacToCart(){
        AddMacToCartButton.click();
        return this;
    }
    public HomePage AddMacToWishList(){
        AddMacToWishListButton.click();
        return this;
    }
    public SearchPage search(String text){
        SearchInput.clear();
        SearchInput.sendKeys(text);
        searchButton.click();
        return new SearchPage(driver);
    }
    
    public AccountLogin goToLogin(){
        MyAccount.click();
        Login.click();
        
        return new AccountLogin(driver);
    }
    public ShoppingCart goToShoppingCart(){
        ShoppingCart.click();
        return new ShoppingCart(driver);
    }
    
    

}
