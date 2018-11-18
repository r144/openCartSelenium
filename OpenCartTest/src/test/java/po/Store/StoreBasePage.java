/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package po.Store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import po.BasePage;

/**
 *
 * @author renat
 */
public class StoreBasePage extends BasePage {
    @FindBy(tagName = "h2")
    WebElement title;
    
    public MenuStore menu;
    public StoreBasePage(WebDriver driver) {
        super(driver);
        menu = new MenuStore(driver);
    }

    public MenuStore getMenu() {
        return menu;
    }
    public String getTitle() {
        return title.getText();
    }
}
