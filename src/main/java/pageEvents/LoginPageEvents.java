package pageEvents;

import Utils.Constants;
import Utils.ElementsActions;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPageElements;
import pageObjects.PageBase;

public class LoginPageEvents extends PageBase {

    private LoginPageElements loginPageElements;
    private ElementsActions Ele_Wait;
    private WebDriver driver;
    private HomePageEvents homePageEvents;
    public LoginPageEvents(WebDriver driver) {

        super(driver);
        loginPageElements=new LoginPageElements(driver);
        this.Ele_Wait = new ElementsActions(driver);
        this.driver=driver;
        homePageEvents=new HomePageEvents(driver);

    }

    public void enterUserName(String name){
        Ele_Wait.waitElementToBeVisibleAndClickable(loginPageElements.loginUserNameTxtBox);
        setTextElementText(loginPageElements.loginUserNameTxtBox,name);
    }

    public void clearUserName(){
        Ele_Wait.waitElementToBeVisibleAndClickable(loginPageElements.loginUserNameTxtBox);
        clearText(loginPageElements.loginUserNameTxtBox);
    }


    public void enterPassword(String password){
        Ele_Wait.waitElementToBeVisibleAndClickable(loginPageElements.loginPasswordTxtBox);
        setTextElementText(loginPageElements.loginPasswordTxtBox,password);
    }

    public void clearPassword(){
        Ele_Wait.waitElementToBeVisibleAndClickable(loginPageElements.loginPasswordTxtBox);
        clearText(loginPageElements.loginPasswordTxtBox);
    }

    public void submitLogin(){
        Ele_Wait.waitElementToBeVisibleAndClickable(loginPageElements.loginSubmit);
        clickButton(loginPageElements.loginSubmit);
    }

    public void closeLoginForm(){

        Ele_Wait.waitElementToBeVisibleAndClickable(loginPageElements.loginCloseBtn);
        clickButton(loginPageElements.loginCloseBtn);

    }

    public String getLoginUserName(){
        Ele_Wait.waitElementToBeVisible(loginPageElements.loginUserName);
        return loginPageElements.loginUserName.getText().toString();
    }

    public void clickLogout(){
        Ele_Wait.waitElementToBeVisibleAndClickable(loginPageElements.logoutBtn);
        clickButton(loginPageElements.logoutBtn);

    }

    public void doLogin(String username ,String password){
        driver.manage().window().maximize();
        driver.get(Constants.HomePageUrl);

        // Open sign-up modal
        homePageEvents.clickLogin();
        clearUserName();
        clearPassword();
        // Enter username and password
        enterUserName(username);
        enterPassword(password);

        // Submit the form
        submitLogin();

    }
}
