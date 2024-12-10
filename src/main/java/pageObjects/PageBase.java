package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PageBase {

    private WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void clickButton(WebElement button) {
        try {
            button.click();
        } catch (Exception e) {
            System.out.println("Failed to click button: " + e.getMessage());
        }
    }

    protected void setTextElementText(WebElement textElement, String value) {
        try {
            textElement.sendKeys(value);
        } catch (Exception e) {
            System.out.println("Failed to set text: " + e.getMessage());
        }
    }

    public void clearText(WebElement element) {
        try {
            element.clear();

        } catch (Exception e) {
            System.out.println("Failed to clear text: " + e.getMessage());
        }
    }

    protected void submitTextElement(WebElement textBox) {
        try {
            textBox.submit();
        } catch (Exception e) {
            System.out.println("Failed to submit text element: " + e.getMessage());
        }
    }

    public boolean isTxtExistInTable(WebElement element,String searchTxt){
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        List<WebElement> rows = element.findElements(By.tagName("tr"));
        boolean found = false;
        System.out.println("row size"+rows.size());

        for (WebElement row : rows) {
            // Get all cells in the current row
            List<WebElement> cells = row.findElements(By.tagName("td"));

            for (WebElement cell : cells) {
                if (cell.getText().equals(searchTxt)) { // Replace "DesiredValue" with the value you're searching for
                    System.out.println("Value found in the table!"+cell.getText());
                    found = true;
                    break;
                }

            }
            if (found){
                break;
            }


        }

        return found;

    }

    public String verifyFromAlertMessage() {


      try{

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the alert to appear
        wait.until(ExpectedConditions.alertIsPresent());

        // Switch to the alert
        Alert alert = driver.switchTo().alert();

        // Get alert text
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);

        // Accept the alert
        alert.accept();

        return alertText;


      } catch (Exception e) {
          return "Alert did not appear";
      }

    }

    public void scrollToBottom() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("scrollBy(0,2500)");
        } catch (Exception e) {
            System.out.println("Failed to scroll to bottom: " + e.getMessage());
        }
    }


}
