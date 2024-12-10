package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePageElements extends PageBase{


    public HomePageElements(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

   @FindBy(id="signin2")
    public WebElement signUpBtn;

    @FindBy(id="login2")
    public WebElement loginBtn;


}
