package TestCases;

import Utils.Constants;
import Utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageEvents.CartPageEvents;
import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;
import pageEvents.ProductPageEvents;

import java.time.Duration;

public class ProductTest extends TestBase{

    HomePageEvents homePageEvents;
    LoginPageEvents loginPage;
    ProductPageEvents productPage;
    CartPageEvents cartPageEvents;
    ExtentReports extent;
    ExtentTest test;


    @DataProvider(name = "ProductData")
    public Object[][] getProductData() {
        return new Object[][]{
                {"phones", "Nokia lumia 1520"},
                {"laptops", "Sony vaio i5"},
                {"monitors", "ASUS Full HD"}
        };
    }

    @BeforeMethod
    public void setUp() {

        homePageEvents=new HomePageEvents(driver);
        loginPage=new LoginPageEvents(driver);
        productPage=new ProductPageEvents(driver);
        cartPageEvents=new CartPageEvents(driver);
        extent = ExtentReportManager.getReportInstance();


    }



    @Test(dataProvider = "ProductData")
    public void verify_success_AddingProductsToTheCart(String category,String productName){
        test = extent.createTest("Verify the correct products are displayed in the cart");

        driver.manage().window().maximize();
        driver.get(Constants.HomePageUrl);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        test.pass("Open DemoBlaze Website");
        loginPage.scrollToBottom();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        productPage.selectCategory(category);
        test.pass("select category ");
        productPage.selectProduct(productName);
        test.pass("open product page details ");
        productPage.addSelectedProductToCart();

        test.pass("click add product to cart ");
        String alertText=loginPage.verifyFromAlertMessage();
        SoftAssert softAssert = new SoftAssert();

        if(!alertText.equals("Alert did not appear")){
            softAssert.assertTrue(alertText.contains("Product added"),
                    "Expected success message not found: " + alertText);

        }
        test.pass("Successfully added "+ productName+ "from " +category+" category");

        productPage.openCartPage();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        boolean found=cartPageEvents.checkItemExistInCart(productName);

        softAssert.assertTrue(found,"this "+productName+" not exist");
        softAssert.assertAll();
        test.pass("the correct products are displayed in the cart");

    }
}
