/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package po.Store;

import po.Store.Tablets.Tablets;
import po.Store.Software.Software;
import po.Store.PhonesAndPdas.PhonesAndPdas;
import po.Store.Mp3Players.Mp3Players;
import po.Store.Cameras.Cameras;
import po.Store.Components.*;
import po.Store.LaptopsAndNoteBooks.*;
import po.Store.Desktop.Desktop;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import po.BasePage;
import po.Store.Desktop.Mac;
import po.Store.Desktop.Pc;

/**
 *
 * @author renat
 */
public class MenuStore extends BasePage{
    
    @FindBy(linkText = "Your Store")
    WebElement home;
    
    @FindBy(xpath = "//*[@id=\"menu\"]/button")
    WebElement menuButton;
    
//Desktops
    @FindBy(xpath = "//*[@id=\"narbar-menu\"]/ul/li[1]/a")
    WebElement desktops;

    @FindBy(xpath = "//*[@id=\"narbar-menu\"]/ul/li[1]/div/div/ul/li[1]/a")
    WebElement desktopsPc;

    @FindBy(xpath = "//*[@id=\"narbar-menu\"]/ul/li[1]/div/div/ul/li[2]/a")
    WebElement desktopsMac;
//end
    
//Laptops & NoteBooks    
    @FindBy(xpath = "//*[@id=\"narbar-menu\"]/ul/li[2]/a")
    WebElement laptopsAndNotebooks;
    
    @FindBy(xpath = "//*[@id=\"narbar-menu\"]/ul/li[2]/div/div/ul/li[1]/a")
    WebElement laptopsAndNotebooksMac;
    
    @FindBy(xpath = "//*[@id=\"narbar-menu\"]/ul/li[2]/div/div/ul/li[2]/a")
    WebElement laptopsAndNotebooksWindows;
//end
    
//Components
    @FindBy(xpath = "//*[@id=\"narbar-menu\"]/ul/li[3]/a")
    WebElement components;

    @FindBy(xpath = "//*[@id=\"narbar-menu\"]/ul/li[3]/div/div/ul/li[1]/a")
    WebElement componentsMiceAndTrackballs;

    @FindBy(xpath = "//*[@id=\"narbar-menu\"]/ul/li[3]/div/div/ul/li[2]/a")
    WebElement componentsMonitors;

    @FindBy(xpath = "//*[@id=\"narbar-menu\"]/ul/li[3]/div/div/ul/li[3]/a")
    WebElement componentsPrinters;

    @FindBy(xpath = "//*[@id=\"narbar-menu\"]/ul/li[3]/div/div/ul/li[4]/a")
    WebElement componentsScanners;

    @FindBy(xpath = "//*[@id=\"narbar-menu\"]/ul/li[3]/div/div/ul/li[5]/a")
    WebElement componentsWebCameras;
//end
    
    @FindBy(xpath = "//*[@id=\"narbar-menu\"]/ul/li[4]/a")
    WebElement tablets;
    
    @FindBy(xpath = "//*[@id=\"narbar-menu\"]/ul/li[5]/a")
    WebElement software;
    
    @FindBy(xpath = "//*[@id=\"narbar-menu\"]/ul/li[6]/a")
    WebElement phonesAndPdas;
    
    @FindBy(xpath = "//*[@id=\"narbar-menu\"]/ul/li[7]/a")
    WebElement cameras;
    
    @FindBy(xpath = "//*[@id=\"narbar-menu\"]/ul/li[8]/a")
    WebElement mp3Players;
    
    @FindBy(xpath = "//*[@id=\"narbar-menu\"]/ul/li[8]/div/div/ul[1]/li[1]/a")
    WebElement test11;
    
    
    public MenuStore(WebDriver driver) {
        super(driver);
    }
    
    public Desktop goToDesktopPc() {
        clickMenuOption(desktops);
        clickMenuOption(desktopsPc);
        return new Pc(driver);
    }
    public Desktop goToDesktopMac() {
        clickMenuOption(desktops);
        clickMenuOption(desktopsMac);
        return new Mac(driver);
    }

    public LaptopsAndNotebooks goToLaptopsAndNotebooksMacs() {
        clickMenuOption(laptopsAndNotebooks);
        clickMenuOption(laptopsAndNotebooksMac);
        return new Macs(driver);
    }

    public LaptopsAndNotebooks goToLaptopsAndNotebooksWindows() {
        clickMenuOption(laptopsAndNotebooks);
        clickMenuOption(laptopsAndNotebooksWindows);
        return new Windows(driver);
    }

    public Components goToComponentsMiceAndTrackballs() {
        clickMenuOption(components);
        clickMenuOption(componentsMiceAndTrackballs);
        return new MiceAndTrackballs(driver);
    }

    public Components goToComponentsMonitors() {
        clickMenuOption(components);
        clickMenuOption(componentsMonitors);
        return new Monitors(driver);
    }

    public Components goToComponentsPrinters() {
        clickMenuOption(components);
        clickMenuOption(componentsPrinters);
        return new Printers(driver);
    }

    public Components goToComponentsScanners() {
        clickMenuOption(components);
        clickMenuOption(componentsScanners);
        return new Scanners(driver);
    }

    public Components goToComponentsWebCameras() {
        clickMenuOption(components);
        clickMenuOption(componentsWebCameras);
        return new WebCameras(driver);
    }

    public Tablets goToTablets() {
        clickMenuOption(tablets);
        return new Tablets(driver);
    }

    public Software goToSoftwares() {
        clickMenuOption(software);
        return new Software(driver);
    }

    public PhonesAndPdas goToPhonesAndPdas() {
        clickMenuOption(phonesAndPdas);
        return new PhonesAndPdas(driver);
    }

    public Cameras goToCameras() {
        clickMenuOption(cameras);
        return new Cameras(driver);
    }

    public Mp3Players goToMp3Players() {
        clickMenuOption(mp3Players);
        clickMenuOption(test11);
        return new Mp3Players(driver);
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

    
}
