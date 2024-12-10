package pageEvents;

import Utils.ElementsActions;
import org.openqa.selenium.WebDriver;
import pageObjects.PageBase;
import pageObjects.PlaceOrderPageElements;

public class PlaceOrderPageEvents extends PageBase {

    private ProductPageEvents productPageEvents;
    private ElementsActions Ele_Wait;
    private PlaceOrderPageElements placeOrderPage;
    public PlaceOrderPageEvents(WebDriver driver) {

        super(driver);
        this.Ele_Wait = new ElementsActions(driver);
        productPageEvents=new ProductPageEvents(driver);
        placeOrderPage=new PlaceOrderPageElements(driver);
    }

    public void enterName(String name){
        Ele_Wait.waitElementToBeVisibleAndClickable(placeOrderPage.nameTxtBox);
        setTextElementText(placeOrderPage.nameTxtBox,name);
    }

    public void enterCountry(String country){
        Ele_Wait.waitElementToBeVisibleAndClickable(placeOrderPage.countryTxtBox);
        setTextElementText(placeOrderPage.countryTxtBox,country);
    }
    public void enterCity(String city){
        Ele_Wait.waitElementToBeVisibleAndClickable(placeOrderPage.cityTxtBox);
        setTextElementText(placeOrderPage.cityTxtBox,city);
    }
    public void enterCreditCart(String creditCart){
        Ele_Wait.waitElementToBeVisibleAndClickable(placeOrderPage.creditCardTxtBox);
        setTextElementText(placeOrderPage.creditCardTxtBox,creditCart);
    }
    public void enterMonth(String month){
        Ele_Wait.waitElementToBeVisibleAndClickable(placeOrderPage.monthTxtBox);
        setTextElementText(placeOrderPage.monthTxtBox,month);
    }
    public void enterYear(String year){
        Ele_Wait.waitElementToBeVisibleAndClickable(placeOrderPage.yearTxtBox);
        setTextElementText(placeOrderPage.yearTxtBox,year);
    }
    public void clickPurchaseBtn(){
        Ele_Wait.waitElementToBeVisibleAndClickable(placeOrderPage.purchaseBtn);
        clickButton(placeOrderPage.purchaseBtn);
    }

    public String getConfirmCheckoutMess(){

        Ele_Wait.waitElementToBeVisible(placeOrderPage.confirmMessage);
        return placeOrderPage.confirmMessage.getText().toString();
    }

}
