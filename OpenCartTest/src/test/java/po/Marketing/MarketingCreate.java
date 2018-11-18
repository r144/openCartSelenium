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
public class MarketingCreate extends OpenCartBasePage{

    @FindBy(id = "input-name")
    WebElement campaignName;

    @FindBy(id = "input-description")
    WebElement campaignDescription;

    @FindBy(id = "input-code")
    WebElement trackingCode;

    @FindBy(id = "input-example1")
    WebElement exemples1;

    @FindBy(id = "input-example2")
    WebElement exemples2;

    @FindBy(xpath = "/html/body/div/div/div[1]/div/div/button")
    WebElement save;

    @FindBy(xpath = "/html/body/div/div/div[1]/div/div/a")
    WebElement cancel;

    public MarketingCreate(WebDriver driver) {
        super(driver);
    }

    public MarketingCreate setCampaignName(String StrCampaignName) {
        this.campaignName.clear();
        this.campaignName.sendKeys(StrCampaignName);
        return this;
    }

    public MarketingCreate setCampaignDescription(String StrCampaignDescription) {
        campaignDescription.clear();
        campaignDescription.sendKeys(StrCampaignDescription);
        return this;
    }

    public MarketingCreate setTrackingCode(String StrTrackingCode) {
        trackingCode.clear();
        trackingCode.sendKeys(StrTrackingCode);
        return this;
    }

    public MarketingCreate setExemples1(String StrExemple1) {
        exemples1.clear();
        exemples1.sendKeys(StrExemple1);
        return this;
    }

    public MarketingCreate setExemples2(String StrExemple2) {
        exemples2.clear();
        exemples2.sendKeys(StrExemple2);
        return this;
    }

    public MarketingPage save() {
        save.click();
        return new MarketingPage(driver);
    }

    public MarketingCreate Cancel() {
        cancel.click();
        return this;
    }
}
