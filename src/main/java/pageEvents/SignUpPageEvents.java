package pageEvents;

import Utils.ElementsActions;
import org.openqa.selenium.WebDriver;
import pageObjects.PageBase;
import pageObjects.SignUpPageElements;

public class SignUpPageEvents extends PageBase {

    private SignUpPageElements signUpPageElements;
    private ElementsActions Ele_Wait;

    public SignUpPageEvents(WebDriver driver) {
        super(driver);

        this.Ele_Wait = new ElementsActions(driver);
        signUpPageElements=new SignUpPageElements(driver);
    }

    public void enterUserName(String name){
        Ele_Wait.waitElementToBeVisibleAndClickable(signUpPageElements.SignUpUserNameTxtBox);
        setTextElementText(signUpPageElements.SignUpUserNameTxtBox,name);
    }

    public void clearUserName(){
        Ele_Wait.waitElementToBeVisibleAndClickable(signUpPageElements.SignUpUserNameTxtBox);
        clearText(signUpPageElements.SignUpUserNameTxtBox);
    }

    public void enterPassword(String password){
        Ele_Wait.waitElementToBeVisibleAndClickable(signUpPageElements.signUpPasswordTxtBox);
        setTextElementText(signUpPageElements.signUpPasswordTxtBox,password);
    }

    public void clearPassword(){
        Ele_Wait.waitElementToBeVisibleAndClickable(signUpPageElements.signUpPasswordTxtBox);
        clearText(signUpPageElements.signUpPasswordTxtBox);
    }

    public void submitSingUp(){
        Ele_Wait.waitElementToBeVisibleAndClickable(signUpPageElements.signUpSubmit);
        clickButton(signUpPageElements.signUpSubmit);
    }

    public void closeSignUpForm(){

        Ele_Wait.waitElementToBeVisibleAndClickable(signUpPageElements.signUpCloseBtn);
        clickButton(signUpPageElements.signUpCloseBtn);

    }
}
