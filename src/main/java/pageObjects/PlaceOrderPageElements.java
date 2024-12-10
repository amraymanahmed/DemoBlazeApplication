package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrderPageElements extends PageBase{

    public PlaceOrderPageElements(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "name")
    public WebElement nameTxtBox;

    @FindBy(id = "country")
    public WebElement countryTxtBox;

    @FindBy(id = "city")
    public WebElement cityTxtBox;

    @FindBy(id = "card")
    public WebElement creditCardTxtBox;

    @FindBy(id = "month")
    public WebElement monthTxtBox;

    @FindBy(id = "year")
    public WebElement yearTxtBox;

    @FindBy(xpath = "//button[text()='Purchase']")
    public WebElement purchaseBtn;

    @FindBy(xpath = "//div//h2[text()='Thank you for your purchase!']")
    public WebElement confirmMessage;

}
