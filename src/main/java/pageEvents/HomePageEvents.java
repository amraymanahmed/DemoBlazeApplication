package pageEvents;

import Utils.ElementsActions;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePageElements;
import pageObjects.PageBase;

public class HomePageEvents extends PageBase {

    private HomePageElements homePageElements;
    private ElementsActions Ele_Wait;

    public HomePageEvents(WebDriver driver) {

        super(driver);
        this.homePageElements = new HomePageElements(driver);
        this.Ele_Wait = new ElementsActions(driver);

    }

    public void clickLogin(){

        Ele_Wait.waitElementToBeVisibleAndClickable(homePageElements.loginBtn);
        clickButton(homePageElements.loginBtn);

    }

    public void clickSignUp(){

        Ele_Wait.waitElementToBeVisibleAndClickable(homePageElements.signUpBtn);
        clickButton(homePageElements.signUpBtn);
    }



}
