package AutomationExercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElements {

    WebDriver driver;

    @FindBy(xpath = "//*[@data-qa='login-email']")
    WebElement email;

    @FindBy(xpath = "//*[@data-qa='login-password']")
    WebElement password;

    @FindBy(xpath = "//*[@data-qa='login-button']")
    WebElement loginButton;

    @FindBy(xpath = "//p[@style='color: red;']")
    public WebElement passwordError;

    public LoginPageElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String setEmail) {
        email.sendKeys(setEmail);
    }

    public void enterPassword(String setPassword) {
        password.sendKeys(setPassword);
    }

    public void loginButtonClick() {
        loginButton.click();
    }
}
