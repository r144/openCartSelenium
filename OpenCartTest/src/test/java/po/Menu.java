/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package po;

import po.Sales.OrdersPage;
import po.Marketing.CouponsPage;
import po.Customers.CustomersPage;
import po.Marketing.MarketingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import po.Customers.CustomerGroupsPage;
import po.Store.HomePage;

/**
 *
 * @author renat
 */
public class Menu extends BasePage {
    // personal menu
    @FindBy(xpath = "//*[@id=\"header\"]/div/ul/li[1]/a")
    WebElement personalMenu;
    
    @FindBy(xpath = "//*[@id=\"header\"]/div/ul/li[1]/div/a[1]")
    WebElement yourProfile;
    
    @FindBy(xpath = "//*[@id=\"header\"]/div/ul/li[1]/div/a[2]")
    WebElement YourStore;

    
    @FindBy(linkText = "Dashboard")
    WebElement dashboardMenu;

    @FindBy(id = "button-menu")
    WebElement menuButton;
    
    // Marketing
    @FindBy(xpath = "/html/body/div[1]/nav/ul/li[7]/a")
    WebElement marketingMenu;

    @FindBy(xpath = "/html/body/div[1]/nav/ul/li[7]/ul/li[1]/a")
    WebElement marketingOpt;
    
    @FindBy(xpath = "//*[@id=\"collapse6\"]/li[2]/a")
    WebElement couponsOpt;
    // end
    
    @FindBy(xpath = "//*[@id=\"menu-sale\"]/a")
    WebElement Sales;
    
    @FindBy(xpath = "//*[@id=\"collapse4\"]/li[1]/a")
    WebElement OrdersOpt;
    
    // Customers
    @FindBy(xpath = "/html/body/div[1]/nav/ul/li[6]/a")
    WebElement customersMenu;
    
    @FindBy(xpath = "/html/body/div[1]/nav/ul/li[6]/ul/li[1]/a")
    WebElement customersOpt;
    
    @FindBy(xpath = "/html/body/div[1]/nav/ul/li[6]/ul/li[2]/a")
    WebElement customerGroupsOpt;
    
    @FindBy(xpath = "/html/body/div[1]/header/div/ul/li[2]/a")
    WebElement logoutButton;

    
//<editor-fold defaultstate="collapsed" desc="comment">
//    @FindBy(linkText = "Catalog")
//    WebElement catalogMenu;
//
//    @FindBy(linkText = "Extensions")
//    WebElement extensionsMenu;
//
//    @FindBy(linkText = "Designs")
//    WebElement designsMenu;
//
//    @FindBy(linkText = "Sales")
//    WebElement salesMenu;
//
    
//
//    @FindBy(linkText = "System")
//    WebElement systemMenu;
//
//    @FindBy(linkText = "Reports")
//    WebElement reportsMenu;
//
//    @FindBy(linkText = "Dashboard")
//    WebElement dashboard;
//
//    @FindBy(linkText = "Catalog")
//    WebElement catalog;
//
//    @FindBy(linkText = "Extensions")
//    WebElement extensions;
//
//    @FindBy(linkText = "Designs")
//    WebElement designs;
//
//    @FindBy(linkText = "Sales")
//    WebElement sales;
//
//    @FindBy(linkText = "Customers")
//    WebElement customers;
//
//    @FindBy(linkText = "Marketing")
//    WebElement marketing;
//
//    @FindBy(linkText = "System")
//    WebElement system;
//
//    @FindBy(linkText = "Reports")
//    WebElement reports;
//
//</editor-fold>
    public Menu(WebDriver driver) {
        super(driver);
    }

    public MarketingPage goToMarketingOpt() {
        clickMenuOption(marketingMenu);
        clickMenuOption(marketingOpt);
        return new MarketingPage(driver);
    }

    public CouponsPage goToCouponsOpt() {
        clickMenuOption(marketingMenu);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(couponsOpt));
        clickMenuOption(couponsOpt);
        return new CouponsPage(driver);
    }

    public LoginPage doLogOut() {
        logoutButton.click();
        return new LoginPage(driver);
    }

    public CustomerGroupsPage goToCustomersGroupOpt() {
        clickMenuOption(customersMenu);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(customerGroupsOpt));
        clickMenuOption(customerGroupsOpt);
        return new CustomerGroupsPage(driver);
    }

    public CustomersPage goToCustomersOpt() {
        clickMenuOption(customersMenu);
        clickMenuOption(customersOpt);
        return new CustomersPage(driver);
    }
    
    public OrdersPage goToOrdersOpt() {
        clickMenuOption(Sales);
        clickMenuOption(OrdersOpt);
        return new OrdersPage(driver);
    }

    private void clickMenuOption(WebElement menuOption) {
        //menu hides the options -- responsive page
        if (!menuOption.isDisplayed()) {
            menuButton.click();
        }
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(menuOption));
        menuOption.click();
    }
    
    public YourProfilePage goToYourProfile() {
        clickMenuOption(personalMenu);
        clickMenuOption(yourProfile);
        return new YourProfilePage(driver);
    }
    
    public HomePage goToYourStore() {
        clickMenuOption(personalMenu);
        clickMenuOption(YourStore);
        return new HomePage(driver);
    }
}
