/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package po.Customers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import po.OpenCartBasePage;

/**
 *
 * @author renat
 */
public class CustomersCreate extends OpenCartBasePage{
    
    @FindBy(id = "input-customer-group")
    WebElement customerGroup;
    
    @FindBy(id = "input-firstname")
    WebElement firstName;
    
    @FindBy(id = "input-lastname")
    WebElement lastName;
    
    @FindBy(id = "input-email")
    WebElement email;
    
    @FindBy(id = "input-telephone")
    WebElement telephone;
    
    @FindBy(id = "input-password")
    WebElement password;
    
    @FindBy(id = "input-confirm")
    WebElement confirm;
    
    @FindBy(xpath = "/html/body/div/div/div[1]/div/div/button")
    WebElement save;
    
    public CustomersCreate(WebDriver driver) {
        super(driver);
    }
    
    public CustomersCreate setFirstName(String name){
        firstName.clear();
        firstName.sendKeys(name);
        return this;
    }
    
    public CustomersCreate setLastName(String last){
        lastName.clear();
        lastName.sendKeys(last);
        return this;
    }
    
    public CustomersCreate setEmail(String e){
        email.clear();
        email.sendKeys(e);
        return this;
    }
    
    public CustomersCreate setTelephone(String tel){
        telephone.clear();
        telephone.sendKeys(tel);
        return this;
    }
    
    public CustomersCreate setPassword(String pass){
        password.clear();
        password.sendKeys(pass);
        return this;
    }
    
    public CustomersCreate setConfirm(String confPass){
        confirm.clear();
        confirm.sendKeys(confPass);
        return this;
    }
    public CustomersPage save() {
        save.click();
        return new CustomersPage(driver);
    }
    
    
}
