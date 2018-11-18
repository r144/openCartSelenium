/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package po.Store;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author renat
 */
public class CheckoutPage extends StoreBasePage{
    
    @FindBy(name = "firstname")
    WebElement firstnameInput;
    
    @FindBy(name = "lastname")
    WebElement lastnameInput;
            
    @FindBy(name = "company")
    WebElement companyInput;
    
    @FindBy(name = "address_1")
    WebElement address_1Input;
    
    @FindBy(name = "city")
    WebElement cityInput;
    
    @FindBy(name = "postcode")
    WebElement postcodeInput;
    
    @FindBy(name = "country_id")
    WebElement country_idInput;
    
    @FindBy(name = "zone_id")
    WebElement zone_idInput;
           
    @FindBy(id = "button-payment-address")
    WebElement ContinueButton;
    
    @FindBy(name = "agree")
    WebElement checkBoxAgree;
    
    @FindBy(id = "button-payment-method")
    WebElement paymentMethodButton;
    
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    
    public CheckoutPage PreencheForm(String firstname, String lastname, String company, String address_1, String city, String postcode, 
            String country_id, String zone_id){
        firstnameInput.clear();
        lastnameInput.clear();
        companyInput.clear();
        address_1Input.clear();
        cityInput.clear();
        postcodeInput.clear();
        
        firstnameInput.sendKeys(firstname);
        lastnameInput.sendKeys(lastname);
        companyInput.sendKeys(company);
        address_1Input.sendKeys(address_1);
        cityInput.sendKeys(city);
        postcodeInput.sendKeys(postcode);
        
        country_idInput.click();
        country_idInput.sendKeys(country_id);
        country_idInput.sendKeys(Keys.ENTER);
        
        zone_idInput.click();
        zone_idInput.sendKeys(zone_id);
        zone_idInput.sendKeys(Keys.ENTER);
        return this;
    }
    public CheckoutPage ContinueClick(){
        ContinueButton.click();
        return this;
    }
    public CheckoutPage ContinuePayment(){
        paymentMethodButton.click();
        return this;
    }
    public CheckoutPage AgreeClick(){
        checkBoxAgree.click();
        return this;
    }
    
    
}
