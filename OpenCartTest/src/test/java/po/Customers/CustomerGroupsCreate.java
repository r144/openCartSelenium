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
public class CustomerGroupsCreate extends OpenCartBasePage{
    
    @FindBy(css = "input.form-control:nth-child(2)")
    WebElement customerGroupName;
    
    @FindBy(css = "#input-description1")
    WebElement description;
    
    @FindBy(xpath = "/html/body/div/div/div[1]/div/div/button")
    WebElement save;
    
    public CustomerGroupsCreate(WebDriver driver) {
        super(driver);
    }
    
    public CustomerGroupsCreate setCustomerGroupName(String name){
        customerGroupName.clear();
        customerGroupName.sendKeys(name);
        return this;
    }
    public CustomerGroupsCreate setDescription(String desc){
        description.clear();
        description.sendKeys(desc);
        return this;
    }
    public CustomerGroupsPage save(){
        save.click();
        return new CustomerGroupsPage(driver);
    }
}
