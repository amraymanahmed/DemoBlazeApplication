package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPageElements extends PageBase{

    public CartPageElements(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }


    @FindBy(id = "tbodyid")
    public WebElement productTable;

    @FindBy(xpath = "//button[text()='Place Order']")
    public WebElement placeOrderBtn;



}
