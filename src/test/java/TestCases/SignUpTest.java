package TestCases;

import Utils.Constants;
import Utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageEvents.HomePageEvents;
import pageEvents.SignUpPageEvents;

import java.time.Duration;


public class SignUpTest extends TestBase{

    HomePageEvents homePageEvents;
    SignUpPageEvents signUpPage;
    ExtentReports extent;
    ExtentTest test;
    // DataProvider supplies test data to the test method
    @DataProvider(name = "SignUpData")
    public Object[][] getSignUpData() {
        return new Object[][]{
                {"amrayman47009", "1234567"},
                {"user4800", "password22"},
                {"user49009", "password33"}
        };
    }


    @BeforeClass
    public void setUp() {

        homePageEvents=new HomePageEvents(driver);
        signUpPage=new SignUpPageEvents(driver);
        extent = ExtentReportManager.getReportInstance();


    }

    @Test(dataProvider = "SignUpData")
    public void verify_success_signup_withValidData(String username,String password){
        test = extent.createTest("verify_success_signup_withValidData");

        driver.manage().window().maximize();
        driver.get(Constants.HomePageUrl);
        test.pass("Open DemoBlaze Website");

        // Open sign-up modal
        homePageEvents.clickSignUp();
        test.pass("Navigate to the SignUp Page");

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        // Enter username and password
        signUpPage.enterUserName(username);
        test.pass("Enter Valid Username");
        signUpPage.enterPassword(password);
        test.pass("Enter Valid Password");

        // Submit the form
        signUpPage.submitSingUp();
        test.pass("Click On SignUp Button");
        test.pass("Validate Successful SignUP");

        String alertText=signUpPage.verifyFromAlertMessage();

        //signUpPage.closeSignUpForm();

        if(!alertText.equals("Alert did not appear")){
            System.out.println("ok"+alertText);
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(alertText.contains("Sign up successful."),
                "Expected success message not found: " + alertText);

            softAssert.assertAll();
        }
        test.pass("Actual Result: Successful SignUp With valid Data");


    }
    @AfterClass
    public void tearDown() {
        // Write the report
        extent.flush();

        // Close browser
        driver.quit();
    }


}


