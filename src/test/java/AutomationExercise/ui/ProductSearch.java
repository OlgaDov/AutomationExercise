package AutomationExercise.ui;

import AutomationExercise.pages.HomePageElements;
import AutomationExercise.pages.LoginPageElements;
import AutomationExercise.pages.ProductsPageElements;
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
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ProductSearch {

    WebDriver driver;
    String baseURL;

    AutomationExercise.pages.LoginPageElements LoginPageElements;
    AutomationExercise.utils.BasicFunctions BasicFunctions;
    AutomationExercise.pages.HomePageElements HomePageElements;
    AutomationExercise.pages.ProductsPageElements ProductsPageElements;

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
        ProductsPageElements = new ProductsPageElements(driver);
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

    public void testValidSearch() {
        driver.get(baseURL);

        BasicFunctions.waitElements(HomePageElements.consentButton);
        HomePageElements.consentButton.click();
        HomePageElements.products.click();

        ProductsPageElements.enterSearchKey("Dress");

        List<String> results = ProductsPageElements.getProductNames();

        Assert.assertFalse(results.isEmpty(),
                "No search results were returned.");
        SoftAssert softAssert = new SoftAssert();
        for (String productName : results) {
            System.out.println("NEW " + productName);
            softAssert.assertTrue(
                    productName.toLowerCase().contains("dress"),
                    "Unexpected product returned: " + productName
            );

        }
        softAssert.assertAll();
    }
}
