package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPageElements extends PageBase {

    public SignUpPageElements(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(id="sign-username")
    public WebElement SignUpUserNameTxtBox;

    @FindBy(id="sign-password")
    public WebElement signUpPasswordTxtBox;

    @FindBy(xpath = "//button[text()='Sign up']")
    public WebElement signUpSubmit;

    @FindBy(xpath = "//div[@id='signInModal']//button[text()='Close']")
    public WebElement signUpCloseBtn;

}
