package TestCases;

import Utils.Constants;
import Utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;

import java.time.Duration;

public class LoginTest extends TestBase{

    HomePageEvents homePageEvents;
    LoginPageEvents loginPage;
    ExtentReports extent;
    ExtentTest test;

    // DataProvider supplies test data to the test method
    @DataProvider(name = "LoginData")
    public Object[][] getLoginData() {
        return new Object[][]{
                {"amrayman4700", "1234567"},
                {"user48", "password22"},
                {"user4900", "password33"}
        };

    }

    @BeforeClass
    public void setUp() {

        homePageEvents=new HomePageEvents(driver);
        loginPage=new LoginPageEvents(driver);
        extent = ExtentReportManager.getReportInstance();

    }

    @Test(dataProvider = "LoginData")
    public void verify_success_Login_withValidData(String username,String password){
        test = extent.createTest("verify success Login with Valid Data");

        driver.manage().window().maximize();
        driver.get(Constants.HomePageUrl);
        test.pass("Open DemoBlaze Website");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));


        homePageEvents.clickLogin();
        test.pass("Navigate to the Login Page");

        // Enter username and password
        loginPage.enterUserName(username);
        test.pass("Enter Valid Username");
        loginPage.enterPassword(password);
        test.pass("Enter Valid Password");
        // Submit the form
        loginPage.submitLogin();
        test.pass("Click On Login Button");
        test.pass("Validate Successful Login");


        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        SoftAssert softAssert = new SoftAssert();
        // Perform soft assertion
        String displayedText = loginPage.getLoginUserName();
        softAssert.assertTrue(displayedText.contains(username), "Username is not displayed correctly in the navbar.");
        softAssert.assertAll();

        loginPage.clickLogout();
        test.pass("Do Logout");
        test.pass("Actual Result: Successful Login With valid Data");


    }

    @AfterClass
    public void tearDown() {
        // Write the report
        extent.flush();

        // Close browser
        driver.quit();
    }

}
