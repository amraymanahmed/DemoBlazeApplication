package pageEvents;

import Utils.ElementsActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.PageBase;
import pageObjects.ProductPageElements;


public class ProductPageEvents extends PageBase {

    private ElementsActions Ele_Wait;
    private ProductPageElements productPageElements;
    private WebDriver driver;

    public ProductPageEvents(WebDriver driver) {

        super(driver);
        this.Ele_Wait = new ElementsActions(driver);
        productPageElements=new ProductPageElements(driver);
        this.driver=driver;

    }

    public void selectCategory(String categoryName) {
        switch (categoryName.toLowerCase()) {
            case "laptops":
                Ele_Wait.waitElementToBeVisibleAndClickable(productPageElements.laptopsCategory);
                clickButton(productPageElements.laptopsCategory);
                break;
            case "phones":
                System.out.println("1");
                Ele_Wait.waitElementToBeVisibleAndClickable(productPageElements.phonesCategory);
                clickButton(productPageElements.phonesCategory);
                System.out.println("2");
                break;
            case "monitors":
                Ele_Wait.waitElementToBeVisibleAndClickable(productPageElements.monitorsCategory);
                clickButton(productPageElements.monitorsCategory);
                break;
            default:
                throw new IllegalArgumentException("Category not found: " + categoryName);
        }
    }


    public void selectProduct(String productName){

        WebElement productLink = driver.findElement(org.openqa.selenium.By.linkText(productName));
        Ele_Wait.waitElementToBeVisibleAndClickable(productLink);
        clickButton(productLink);

    }



    public void addSelectedProductToCart() {

        Ele_Wait.waitElementToBeVisibleAndClickable(productPageElements.addToCartBtn);
        clickButton(productPageElements.addToCartBtn);

    }

    public void openCartPage(){
        Ele_Wait.waitElementToBeVisibleAndClickable(productPageElements.cartBtn);
        clickButton(productPageElements.cartBtn);

    }

    public void openHomePage(){
        Ele_Wait.waitElementToBeVisibleAndClickable(productPageElements.homeBtn);
        clickButton(productPageElements.homeBtn);

    }
    public void addProductToCart(String category ,String productName){

        selectCategory(category);
        selectProduct(productName);
        addSelectedProductToCart();
        openCartPage();


    }



}
