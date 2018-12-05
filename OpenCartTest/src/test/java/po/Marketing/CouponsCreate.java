/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package po.Marketing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import po.OpenCartBasePage;

/**
 *
 * @author renat
 */
public class CouponsCreate extends OpenCartBasePage{
    
    @FindBy(name = "name")
    WebElement couponName;
    
    @FindBy(name = "code")
    WebElement couponCode;
    
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/button")
    WebElement saveButton;
    
    
    public CouponsCreate(WebDriver driver) {
        super(driver);
    }
    
    public CouponsCreate setCouponName(String StrCouponName) {
        this.couponName.clear();
        this.couponName.sendKeys(StrCouponName);
        return this;
    }
    
    public CouponsCreate setCode(String StrCouponName) {
        this.couponCode.clear();
        this.couponCode.sendKeys(StrCouponName);
        return this;
    }
    
    public CouponsPage save() {
        saveButton.click();
        return new CouponsPage(driver);
    }
}
