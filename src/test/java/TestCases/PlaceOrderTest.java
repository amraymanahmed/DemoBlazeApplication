package TestCases;

import Utils.Constants;
import Utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageEvents.*;

import java.time.Duration;

public class PlaceOrderTest extends TestBase{

    ProductPageEvents productPage;
    HomePageEvents homePageEvents;
    private CartPageEvents cartPageEvents;
    private PlaceOrderPageEvents placeOrderPage;
    ExtentReports extent;
    ExtentTest test;



    @BeforeMethod
    public void setUp() {

        homePageEvents=new HomePageEvents(driver);
        productPage=new ProductPageEvents(driver);
        cartPageEvents=new CartPageEvents(driver);
        placeOrderPage=new PlaceOrderPageEvents(driver);
        extent = ExtentReportManager.getReportInstance();

        driver.manage().window().maximize();
        driver.get(Constants.HomePageUrl);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));


    }



    @Test
    public void verify_success_Checkout() {
        test = extent.createTest("verify user Do Checkout successfully");
        test.pass("Open DemoBlaze Website");

        homePageEvents.scrollToBottom();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        productPage.addProductToCart("laptops", "Sony vaio i5");
        test.pass("add product to cart ");
        cartPageEvents.clickPlaceOrderBtn();
        test.pass("click on placeOrder button");

        placeOrderPage.enterName("amr");
        placeOrderPage.enterCountry("egypt");
        placeOrderPage.enterCity("cairo");
        placeOrderPage.enterCreditCart("0933");
        placeOrderPage.enterMonth("11");
        placeOrderPage.enterYear("2009");
        test.pass("successfully enter valid data  for placing an order");
        placeOrderPage.clickPurchaseBtn();
        test.pass("click on Purchase button");

        SoftAssert softAssert = new SoftAssert();
        // Perform soft assertion
        String displayedText = placeOrderPage.getConfirmCheckoutMess();
        System.out.println(displayedText);
        softAssert.assertTrue(displayedText.contains(displayedText), "checkout failed....");
        softAssert.assertAll();

       test.pass(" Complete Checkout Successfully" );

    }
}
