package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPageElements extends PageBase{

    public ProductPageElements(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "cat")
    public List<WebElement> categoryListItems;

    @FindBy(linkText = "Phones")
    public WebElement phonesCategory;

    @FindBy(linkText = "Laptops")
    public WebElement laptopsCategory;

    @FindBy(linkText = "Monitors")
    public WebElement monitorsCategory;

    @FindBy(linkText = "Add to cart")
    public WebElement addToCartBtn;


    @FindBy(linkText = "Cart")
    public WebElement cartBtn;

    @FindBy(linkText = "Home ")
    public WebElement homeBtn;

}
