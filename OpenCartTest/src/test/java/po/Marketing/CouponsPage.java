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
 * @author renat
 */
public class CouponsPage extends OpenCartBasePage{

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/a")
    WebElement addNew;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/button")
    WebElement delete;

    @FindBy(xpath = "//*[@id=\"form-coupon\"]/div/table/tbody/tr[1]/td[1]/input")
    WebElement select1;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[1]")
    WebElement deleteFeedBack;
    
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/a")
    WebElement newButton;
    
    public String successDeleteMessage = "Success: You have modified coupons! ×".trim().toLowerCase();
    public CouponsPage(WebDriver driver) {
        super(driver);
    }
    
    public String getDeleteFeedBack() {
        return deleteFeedBack.getAttribute("innerText").trim().toLowerCase();
    }
    
    public void deleteMCoupon1() {
        select1.click();
        delete.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    
    public CouponsCreate goToCouponCreate() {
        newButton.click();
        return new CouponsCreate(driver);
    }
    
}
