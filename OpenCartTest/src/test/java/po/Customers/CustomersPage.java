/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package po.Customers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import po.OpenCartBasePage;

/**
 *
 * @author renat
 */
public class CustomersPage extends OpenCartBasePage{
    
    @FindBy(xpath = "/html/body/div/div/div[1]/div/div/a")
    WebElement addNew;
    
    @FindBy(xpath = "/html/body/div/div/div[2]/div[1]")
    WebElement createFeedBack;

    @FindBy(xpath = "//*[@id=\"form-customer\"]/div/table/thead/tr/td[1]/input")
    WebElement selectAll;
    
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/button[2]")
    WebElement deleteButton;
    
    public String successCreateMessage = "Success: You have modified customers! ×".trim().toLowerCase();
    public CustomersPage(WebDriver driver) {
        super(driver);
    }
    
    public String getCreateFeedBack() {
        return createFeedBack.getAttribute("innerText").trim().toLowerCase();
    }
    
    public CustomersCreate goToCustomerCreate() {
        addNew.click();
        return new CustomersCreate(driver);
    }
    
    
    public CustomersPage deleteAllCustomers(){
        selectAll.click();
        deleteButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }
    
}
