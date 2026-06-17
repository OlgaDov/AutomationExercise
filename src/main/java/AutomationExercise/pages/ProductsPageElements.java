package AutomationExercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsPageElements {
    WebDriver driver;

    @FindBy (name = "search")
    public WebElement searchFiled;

    @FindBy (id = "submit_search")
    public WebElement submitSearch;

    @FindBy (className = "single-products")
    public List<WebElement> resultItems;

    public ProductsPageElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterSearchKey(String setSearchKey) {
        searchFiled.clear();
        searchFiled.sendKeys(setSearchKey);
        submitSearch.click();
    }

    public List<String> getProductNames() {
        return resultItems.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
