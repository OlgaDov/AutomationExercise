package AutomationExercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageElements {
    WebDriver driver;

    @FindBy(css = "a[href='/login']")
    public WebElement signupLoginButton;

    @FindBy(className="fc-button-label")
    public WebElement consentButton;

    @FindBy(xpath = "//i[contains(@class,'fa-user')]/parent::a")
    public WebElement loggedIn;

    @FindBy(xpath = "//i[contains(@class,'fa-user')]/parent::a/b")
    public WebElement testUserName;

    public HomePageElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
