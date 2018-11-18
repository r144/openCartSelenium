/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package po.Store;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author renat
 */
public class SearchPage extends StoreBasePage{
    
    @FindBy(xpath = "//h4[contains(text(), Mac)]")
    List<WebElement> listSearch;
    
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    public int ResultsCount(){
        return listSearch.size();
    }
    
    
}
