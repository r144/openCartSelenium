package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import po.Customers.CustomerGroupsCreate;
import po.Customers.CustomerGroupsPage;
import po.Customers.CustomersCreate;
import po.Customers.CustomersPage;
import po.DashboardPage;
import po.LoginPage;
import po.CanonEos5dPage;
import po.Marketing.CouponsCreate;
import po.Marketing.CouponsPage;
import po.Marketing.MarketingCreate;
import po.Marketing.MarketingPage;
import po.Sales.OrdersPage;
import po.Store.Cameras.Cameras;
import po.Store.Components.Components;
import po.Store.Desktop.Desktop;
import po.Store.HomePage;
import po.Store.LaptopsAndNoteBooks.LaptopsAndNotebooks;
import po.Store.Mp3Players.Mp3Players;
import po.Store.PhonesAndPdas.PhonesAndPdas;
import po.Store.ProductComparison;
import po.Store.SearchPage;
import po.Store.Software.Software;
import po.Store.Tablets.Tablets;
import po.Store.AccountLogin;
import po.Store.CheckoutPage;
import po.Store.LoggedPage;
import po.Store.ShoppingCart;

/**
 *
 * @author andreendo
 */
public class CT {

    private WebDriver driver;
    private String user = "teste";
    private String pass = "utfpr";
    LoginPage loginpage;

    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void before() {
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("headless");
        chromeOptions.addArguments("window-size=1200x600");
        chromeOptions.addArguments("lang=en-US");
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void after() {

        driver.close();
    }

    // Criar um rastreamento de mercado 
    @Ignore
    @Test
    public void CT01() {
        loginpage = new LoginPage(driver);
        DashboardPage dashboard = loginpage.doLogin(user, pass);
        MarketingPage marketing = dashboard.getMenu().goToMarketingOpt();

        marketing.deleteMarketingTracking();

        MarketingCreate marketingCreate = marketing.goToMarketingCreateOpt();

        marketing = marketingCreate.setCampaignName("Teste de Market Tracking")
                .setCampaignDescription("Descrição sobre o rastreamento")
                .setTrackingCode("5bb2B328b84b9")
                .setExemples1("http://192.168.0.106/?tracking=5bb28328b84b9")
                .save();
        assertEquals("Success: You have modified marketing tracking! ×".trim().toLowerCase(),
                marketing.getCreateFeedBack());

        marketing.deleteMarketingTracking();
        marketing.getMenu().doLogOut();

    }

    // Cadastrar novo grupo de clientes
    @Ignore
    @Test
    public void CT02() {
        loginpage = new LoginPage(driver);
        DashboardPage dashboard = loginpage.doLogin(user, pass);
        CustomerGroupsPage customergroup = dashboard.getMenu().goToCustomersGroupOpt();
        CustomerGroupsCreate create = customergroup.goToCustomerGroupsCreate();
        customergroup = create
                .setCustomerGroupName("Teste")
                .setDescription("Desccrição do grupo")
                .save();
        assertEquals("Success: You have modified customer groups! ×".trim().toLowerCase(),
                customergroup.getCreateFeedBack());
        customergroup.getMenu().doLogOut();
    }
//    // Cadastrar novo cliente no grupo criado em CT02 

    @Ignore
    @Test
    public void CT03() {
        loginpage = new LoginPage(driver);
        DashboardPage dashboard = loginpage.doLogin(user, pass);
        CustomersPage customersList = dashboard.getMenu().goToCustomersOpt();
        customersList.deleteAllCustomers();
        CustomersCreate create = customersList.goToCustomerCreate();

        CustomersPage customers = create.setFirstName("Xis")
                .setLastName("Y de Z")
                .setEmail("xydez@gmail.com")
                .setTelephone("12345678900")
                .setPassword("senhaxyz")
                .setConfirm("senhaxyz")
                .save();
        assertEquals("Success: You have modified customers! ×".trim().toLowerCase(),
                customers.getCreateFeedBack());
//        customersList.deleteAllCustomers();
        customers.getMenu().doLogOut();

    }
    // Deletar um Cupom de desconto existente no sistema 

    @Ignore
    @Test
    public void CT04() {
        loginpage = new LoginPage(driver);
        DashboardPage dashboard = loginpage.doLogin(user, pass);
        CouponsPage coupons = dashboard.getMenu()
                .goToCouponsOpt();
        CouponsCreate couponscreate = coupons.goToCouponCreate();
        coupons = couponscreate.setCouponName("Discount").setCode("123456").save();
        coupons.deleteMCoupon1();
        assertEquals("Success: You have modified coupons! ×".trim().toLowerCase(),
                coupons.getDeleteFeedBack());

    }

//    // Teste de navegação dos produtos do site 
    @Ignore
    @Test
    public void CT05() {
        loginpage = new LoginPage(driver);
        DashboardPage dashboard = loginpage.doLogin(user, pass);
        HomePage home = dashboard.getMenu().goToYourStore();
        home.changeTabs(1);
        Desktop dsk = home.getMenu().goToDesktopPc();
        assertEquals(dsk.getTitle(), "PC");

        dsk.getMenu().goToDesktopMac();
        assertEquals(dsk.getTitle(), "Mac");

        LaptopsAndNotebooks laptops = dsk.getMenu().goToLaptopsAndNotebooksMacs();
        assertEquals(laptops.getTitle(), "Macs");

        laptops.getMenu().goToLaptopsAndNotebooksWindows();
        assertEquals(laptops.getTitle(), "Windows");

        Components components = laptops.getMenu().goToComponentsMiceAndTrackballs();
        assertEquals(components.getTitle(), "Mice and Trackballs");

        components.getMenu().goToComponentsMonitors();
        assertEquals(components.getTitle(), "Monitors");

        components.getMenu().goToComponentsPrinters();
        assertEquals(components.getTitle(), "Printers");

        components.getMenu().goToComponentsScanners();
        assertEquals(components.getTitle(), "Scanners");

        components.getMenu().goToComponentsWebCameras();
        assertEquals(components.getTitle(), "Web Cameras");

        Tablets tablets = components.getMenu().goToTablets();
        assertEquals(tablets.getTitle(), "Tablets");

        Software software = tablets.getMenu().goToSoftwares();
        assertEquals(software.getTitle(), "Software");

        PhonesAndPdas phones = software.getMenu().goToPhonesAndPdas();
        assertEquals(phones.getTitle(), "Phones & PDAs");

        Cameras cameras = tablets.getMenu().goToCameras();
        assertEquals(cameras.getTitle(), "Cameras");

        Mp3Players mp3 = tablets.getMenu().goToMp3Players();
        assertEquals(mp3.getTitle(), "test 11");
    }

    // Comparar 2 produtos, removê-los da tela de comparação, e adicionar um ao carrinho de compras 
    @Ignore
    @Test
    public void CT06() {
        loginpage = new LoginPage(driver);
        DashboardPage dashboard = loginpage.doLogin(user, pass);
        HomePage home = dashboard.getMenu().goToYourStore();
        home.changeTabs(1);
        home.addIphoneToCompare();
        assertEquals(home.getFeedBackMessage(), "Success: You have added iPhone to your product comparison! ×"
                .trim().toLowerCase());
        home.addCannonToCompare();
        ProductComparison comparison = home.goToComparedItens();
        comparison.removeIphone();
        assertEquals(comparison.getFeedBackMessage(), "Success: You have modified your product comparison! ×".trim().toLowerCase());
        CanonEos5dPage canonpage = comparison.AddToCartCannon();
        canonpage.SelectRedColor();
        canonpage.AddtoCart();
        assertEquals(canonpage.getFeedBackMessage(), "Success: You have added Canon EOS 5D to your shopping cart! ×"
                .trim().toLowerCase());
        System.out.println(canonpage.getCartText());
        assertEquals(canonpage.getCartText(), "1 item(s) - $98.00".trim().toLowerCase());
    }
//    // Adicionar um produto da página principal no carrinho e adicionar a lista de desejo sem estar logado 

    @Ignore
    @Test
    public void CT07() {
        loginpage = new LoginPage(driver);

        DashboardPage dashboard = loginpage.doLogin(user, pass);
        HomePage home = dashboard.getMenu().goToYourStore();        home.changeTabs(1);
        home.AddMacToCart();
        assertEquals(home.getFeedBackMessage(), "Success: You have added MacBook to your shopping cart! ×"
                .trim().toLowerCase());
        home.AddMacToWishList();
        assertEquals(home.getFeedBackMessage(), "You must login or create an account to save MacBook to your wish list! ×"
                .trim().toLowerCase());
    }
//    // Buscar produtos no site pela barra de pesquisa  

//    @Ignore
    @Test
    public void CT08() {
        loginpage = new LoginPage(driver);

        DashboardPage dashboard = loginpage.doLogin(user, pass);
        HomePage home = dashboard.getMenu().goToYourStore();
        home.changeTabs(1);
        SearchPage search = home.search("Mac");
        assertTrue(search.ResultsCount() > 0);

    }
//    // Logar com o usuário xydez@gmail.com cadastrado no caso de teste 03 e comprar um produto 

    @Ignore
    @Test
    public void CT09() {
        loginpage = new LoginPage(driver);

        DashboardPage dashboard = loginpage.doLogin(user, pass);
        HomePage home = dashboard.getMenu().goToYourStore();
        home.changeTabs(1);
        AccountLogin accLogin = home.goToLogin();
        LoggedPage logged = accLogin.Login("xydez@gmail.com", "senhaxyz");
        home = logged.goToHome();
        home.AddMacToCart();
        assertEquals(home.getFeedBackMessage(), "Success: You have added MacBook to your shopping cart! ×"
                .trim().toLowerCase());
        ShoppingCart shopping = home.goToShoppingCart();
        CheckoutPage checkout = shopping.goToChechout();
        checkout.PreencheForm("X", "Y de Z", "companyX", "rua xyz", "Cornélio Procópio", "86300000", "Brasil", "Paraná");
        checkout.ContinueClick().AgreeClick().ContinuePayment();
        // Não foi possivel continuar o teste pois o metodo de pagamento não 
        //pode ser selecionado mais com estes dados por algum motivo estranho

//        customersList.deleteAllCustomers();
    }
//    // Visualizar os pedidos de compra feito em CT09, e alterar o nome do cliente da compra.

    @Ignore
    @Test
    public void CT10() {
        loginpage = new LoginPage(driver);

        DashboardPage dashboard = loginpage.doLogin(user, pass);
        OrdersPage orders = dashboard.getMenu().goToOrdersOpt();
        // Não foi possivel testar esta funcionalidade por falta de comunicação da api. assim, o teste

    }

//    public void testErrorNoData() {
//        HomePage homePage = new HomePage(driver);
//        FindOwnerPage findOwnerPage = homePage.getMenu().goToFindOwners();
//        EditOwnerPage editOwnerPage = findOwnerPage.goToAddOwner();
//        editOwnerPage.addInvalidData();
//        
//        assertEquals(5, editOwnerPage.getNumberOfErrors());
//    }    
//    private void changeTab(WebDriver driver) {
//
//    }
}
