package AutomationExercise.utils;

import org.openqa.selenium.chrome.ChromeOptions;

public class EnvironmentConfig {

    public static String getBaseURL() {
        // String env = System.getProperty("env");
        // when integrated with CI on real project, to use on different stages of development with different environment
        String env = System.getenv("ENV");
        if (env == null) {
            return "https://automationexercise.com/"; // default for running in local repo on dev env
        } else if (env.equals("local")) {
            return "https://automationexercise.com/";
        } else {
            throw new RuntimeException("Unsupported environment: " + env);
        }
    }

    public static ChromeOptions initializeChromeOptions() {
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-search-engine-choice-screen");
        // Uncomment to enable headless mode
        //opt.addArguments("--headless=new");
        return opt;
    }
}
