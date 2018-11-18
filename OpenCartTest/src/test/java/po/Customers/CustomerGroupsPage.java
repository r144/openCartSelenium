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
public class CustomerGroupsPage extends OpenCartBasePage{
    
    @FindBy(xpath = "/html/body/div/div/div[1]/div/div/a")
    WebElement addNew;
    
    @FindBy(xpath = "/html/body/div/div/div[2]/div[1]")
    WebElement createFeedBack;
    
    public String successCreateMessage = "Success: You have modified customer groups! ×".trim().toLowerCase();
    
    public CustomerGroupsPage(WebDriver driver) {
        super(driver);
    }
    
    public CustomerGroupsCreate goToCustomerGroupsCreate(){
        addNew.click();
        return new CustomerGroupsCreate(driver);
    }
    
    public String getCreateFeedBack() {
        return createFeedBack.getAttribute("innerText").trim().toLowerCase();
    }
}
