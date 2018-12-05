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
 * @author renato
 */
public class LoginPage extends BasePage{
    
    @FindBy(id = "input-username")
    WebElement username;
    
    @FindBy(id = "input-password")
    WebElement password;
    
    @FindBy(xpath = "/html/body/div/div/div/div/div/div/div[2]/form/div[3]/button")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get("http://192.168.0.105/admin/index.php?route=common/login");
    }
    
    public DashboardPage doLogin(String user, String pass){
        username.clear();
        password.clear();
        username.sendKeys(user);
        password.sendKeys(pass);
        loginButton.click();
        return new DashboardPage(driver);
    }
    
}
