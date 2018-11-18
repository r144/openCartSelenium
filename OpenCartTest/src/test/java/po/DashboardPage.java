/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author renat
 */
public class DashboardPage extends OpenCartBasePage {

    @FindBy(className = "close")
    WebElement close;
    
    @FindBy(id = "button-move")
    WebElement buttonMove;
    
    public DashboardPage(WebDriver driver) {
        super(driver);
    }
    
    
}
