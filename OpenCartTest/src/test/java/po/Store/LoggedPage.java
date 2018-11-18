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
public class LoggedPage extends StoreBasePage{
    
    @FindBy(xpath = "//*[@id=\"logo\"]/h1/a")
    WebElement YourStore;
    
    public LoggedPage(WebDriver driver) {
        super(driver);
    }
    
    public HomePage goToHome(){
        YourStore.click();
        return new HomePage(driver);
    }
    
}
