package pageEvents;

import Utils.ElementsActions;
import org.openqa.selenium.WebDriver;
import pageObjects.CartPageElements;
import pageObjects.PageBase;
import pageObjects.ProductPageElements;

import java.time.Duration;

public class CartPageEvents extends PageBase {

    private ElementsActions Ele_Wait;
    private CartPageElements cartPageElements;
    private WebDriver driver;

    public CartPageEvents(WebDriver driver) {
        super(driver);
        this.Ele_Wait = new ElementsActions(driver);
        cartPageElements=new CartPageElements(driver);
        this.driver=driver;
    }

    public void clickPlaceOrderBtn(){
        Ele_Wait.waitElementToBeVisibleAndClickable(cartPageElements.placeOrderBtn);
        clickButton(cartPageElements.placeOrderBtn);
    }

    public boolean checkItemExistInCart(String item){

         Ele_Wait.waitElementToBeVisible(cartPageElements.productTable);
         boolean found=cartPageElements.isTxtExistInTable(cartPageElements.productTable,item);
         return found;



    }


}
