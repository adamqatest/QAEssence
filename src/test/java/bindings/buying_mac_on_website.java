package bindings;

import java.util.Map;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.After;
import cucumber.api.DataTable;
import org.junit.AfterClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ChooseMacBookPage;
import pages.CustomiseMacBookPage;
import pages.HomePage;
import pages.ExtrasMacBookPage;
import pages.SearchPage;
import pages.BagPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class buying_mac_on_website {
    public static WebDriver driver;

    public HomePage homePage;
    public SearchPage searchPage;
    public ChooseMacBookPage chooseMacBookPage;
    public CustomiseMacBookPage customiseMacBookPage;
    public ExtrasMacBookPage extrasMacBookPage;
    public BagPage bagPage;

    public static String url;
    public static String productName;
    public Map<String,String>  onlineOrder;

    @Given("^the url ‘(.*?)’$")
    public void setURL(String arg1) throws Throwable {
        url = arg1;
    }

    @Given("^I go to the url$")
    public void i_go_to_the_url() throws Throwable {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium-3.14\\Drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(url);
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
    }

    @When("^I choose a MacBook Pro with the following features and accessories$")
    public void i_choose_a_MacBook_Pro_with_the_following_features_and_accessories(DataTable arg1) throws Throwable {
        productName = "MacBook Pro";
        onlineOrder = arg1.asMap(String.class, String.class);
    }

    @Then("^I can place an order for it\\.$")
    public void i_can_place_an_order_for_it() throws Throwable {
        homePage.order(productName);

        searchPage = new SearchPage(driver);
        searchPage.buyFirstResult();

        chooseMacBookPage = new ChooseMacBookPage(driver);
        if (onlineOrder.containsKey("Screen")) {
            chooseMacBookPage.chooseSize(onlineOrder.get("Screen"));
        }
        if ((onlineOrder.containsKey("Processor")) && (onlineOrder.containsKey("Colour"))) {
            chooseMacBookPage.chooseSpeedAndFinish(onlineOrder.get("Processor"), onlineOrder.get("Colour"));
            chooseMacBookPage.selectModel(onlineOrder.get("Processor"), onlineOrder.get("Colour"));
        }

        customiseMacBookPage = new CustomiseMacBookPage(driver);
        if (onlineOrder.containsKey("Memory RAM")) {
            customiseMacBookPage.customiseMemory(onlineOrder.get("Memory RAM"));
        }
        if (onlineOrder.containsKey("Graphics")) {
            customiseMacBookPage.customiseGraphics(onlineOrder.get("Graphics"));
        }
        if (onlineOrder.containsKey("Storage")) {
            customiseMacBookPage.customiseStorage(onlineOrder.get("Storage"));
        }
        if (onlineOrder.containsKey("Software")) {
            customiseMacBookPage.customiseSoftware(onlineOrder.get("Software"));
        }
        customiseMacBookPage.addToBagButton().click();

        extrasMacBookPage = new ExtrasMacBookPage(driver);
        if (onlineOrder.containsKey("Display adapter")) {
            extrasMacBookPage.orderExtra(onlineOrder.get("Display adapter"));
        }

        homePage.goHome();
        //TODO - verify bag icon indicator shows order placed
    }

    @Given("^when I choose the following items:$")
    public void when_I_choose_the_following_items(DataTable arg1) throws Throwable {
        //TODO - refactor feature file - datatable irrelevant, as assumed prev scenario run
        if (productName == null) {
            throw new IllegalStateException("Nothing has been ordered previously");
        } else if (!productName.equalsIgnoreCase("MacBook Pro")) {
            throw new IllegalStateException("Scenario 1 should be run first to order MacBook Pro: not=>" +productName+"<");
        }
   }

    @When("^I proceed to the checkout$")public void i_proceed_to_the_checkout() throws Throwable {
        homePage = new HomePage(driver);
        homePage.goCheckout();
    }

    @Then("^a total price of (£\\d+\\.\\d+) will be displayed$")
    public void a_total_price_of_£_will_be_displayed(String expTotal) throws Throwable {
        String actTotal;

        bagPage = new BagPage(driver);
        actTotal = bagPage.getTotal();
        assertEquals(expTotal, actTotal);
    }


    @Then("^(£\\d+\\.\\d+) will be listed for VAT$")
    public void £_will_be_listed_for_VAT(String expVAT) throws Throwable {
        String actVAT;

        bagPage = new BagPage(driver);
        actVAT = bagPage.getVAT();
        assertEquals(expVAT, actVAT);
        homePage.goHome();
    }

    @After
    public static void resetSystem() {
        //TODO - Proper reset
        //TODO - System status and screenshot
        //TODO - Clear basket (optional)
        //TODO - Return to home page
        //TODO - close website (optional)
        //System.out.println("Ran resetSystem");
    }

    @AfterClass
    public static void teardown() {
        //TODO - Proper teardown
        //System.out.println("Ran teardown");
    }
}
