package TestCases;

import Utils.Constants;
import Utils.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class TestBase {

    public static WebDriver driver;
    public static int count=0;
    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            // Create ChromeOptions instance
            ChromeOptions options = new ChromeOptions();

            // Add argument to disable the automation info bar
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});


            // Launch Chrome with the options
            driver = new ChromeDriver(options);

        } else if (browserName.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        }


    }

    @AfterSuite
    public void stopDriver() {
        //  driver.quit();
    }

    // take screenshot when test case fail and add it in the Screenshot folder
    @AfterMethod
    public void screenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot....");
            Helper.captureScreenshot(driver, result.getName()+count);
            count++;
        }
    }
}
