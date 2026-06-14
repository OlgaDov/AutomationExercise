package AutomationExercise;

import AutomationExercise.pages.HomePageElements;
import AutomationExercise.pages.LoginPageElements;
import AutomationExercise.utils.BasicFunctions;
import AutomationExercise.utils.EnvironmentConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {
    WebDriver driver;
    String baseURL;
    AutomationExercise.pages.LoginPageElements LoginPageElements;
    AutomationExercise.utils.BasicFunctions BasicFunctions;
    AutomationExercise.pages.HomePageElements HomePageElements;

    @BeforeMethod

    public void SetUp() {
        ChromeOptions opt = EnvironmentConfig.initializeChromeOptions();

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
        baseURL = EnvironmentConfig.getBaseURL();
        System.out.println(baseURL);

        LoginPageElements = new LoginPageElements(driver);
        BasicFunctions = new BasicFunctions(driver);
        HomePageElements = new HomePageElements(driver);
    }

    @AfterMethod

    public void captureScreenshotOnFailureAndTearDown(@NotNull ITestResult result) {
        if (!result.isSuccess()) {
            BasicFunctions.takeScreenshot(result.getName());
        }
        if (driver != null) {
            driver.quit();
        }
    }

    @Test

    public void testEmailLoginHappyPath() {
        driver.get(baseURL);

        BasicFunctions.waitElements(HomePageElements.consentButton);
        HomePageElements.consentButton.click();
        HomePageElements.signupLoginButton.click();
        LoginPageElements.enterEmail("olga.dovnar.v@gmail.com");
        LoginPageElements.enterPassword("AutomationExpressTest");
        LoginPageElements.loginButtonClick();

        BasicFunctions.waitElements(HomePageElements.loggedIn);

        Assert.assertTrue(
                HomePageElements.loggedIn.getText().contains("Logged in as"),
                "Expected 'Logged in as' text was not displayed"
        );

        Assert.assertEquals(HomePageElements.testUserName.getText(), "Olga");
    }



}
