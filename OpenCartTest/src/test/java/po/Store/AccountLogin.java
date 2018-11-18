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
public class AccountLogin extends StoreBasePage{
    @FindBy(name = "email")
    WebElement emailInput;
    
    @FindBy(name = "password")
    WebElement passInput;
    
    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/div/form/input")
    WebElement LoginButton;
    
    public AccountLogin(WebDriver driver) {
        super(driver);
    }
    public LoggedPage Login(String user, String pass){
        emailInput.clear();
        emailInput.sendKeys(user);
        passInput.clear();
        passInput.sendKeys(pass);
        LoginButton.click();
        return new LoggedPage(driver);
    }
    
}
