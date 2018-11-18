/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package po.Marketing;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import po.OpenCartBasePage;

/**
 *
 * @author renato
 */
public class MarketingPage extends OpenCartBasePage{
    
    @FindBy(xpath = "/html/body/div/div/div[1]/div/div/a")
    WebElement addNew;
    
    @FindBy(xpath = "/html/body/div/div/div[1]/div/div/button[2]")
    WebElement delete;
    
    
    @FindBy(xpath = "/html/body/div/div/div[2]/div[1]")
    WebElement createFeedBack;
    
    
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div[2]/form/div/table/thead/tr/td[1]/input")
    WebElement selectAll;
    
    public String successCreateMessage = "Success: You have modified marketing tracking! ×".trim().toLowerCase();

    public MarketingPage(WebDriver driver) {
        super(driver);
    }
    
    public MarketingCreate goToMarketingCreateOpt() {
        addNew.click();
        return new MarketingCreate(driver);
    }
    
    public String getCreateFeedBack(){
        return createFeedBack.getAttribute("innerText").trim().toLowerCase();
    }
    public void deleteMarketingTracking(){
        selectAll.click();
        delete.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    
    
    
    
}
