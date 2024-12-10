package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElements extends PageBase{

    public LoginPageElements(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="loginusername")
    public WebElement loginUserNameTxtBox;

    @FindBy(id="loginpassword")
    public WebElement loginPasswordTxtBox;

    @FindBy(xpath = "//button[text()='Log in']")
    public WebElement loginSubmit;

    @FindBy(xpath = "//div[@id='logInModal']//button[text()='Close']")
    public WebElement loginCloseBtn;

    @FindBy(id="nameofuser")
    public WebElement loginUserName;

    @FindBy(id="logout2")
    public WebElement logoutBtn;

}
