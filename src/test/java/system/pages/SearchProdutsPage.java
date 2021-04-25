package system.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import system.helpers.DriverManager;

import java.util.ArrayList;
import java.util.List;

public class SearchProdutsPage {

    /*
     Representation
     */

    private WebDriver driver;
    private WebDriverWait wait;

    private By searchInput = By.id("search-input");
    private By searchResultsLocator = By.cssSelector("a[class=\"item-card__description__product-name\"]>span");

    /*
     Services
     */

    public SearchProdutsPage() {
        driver = DriverManager.getDriver();
        wait = DriverManager.getDriverWait();
    }

    public List<String> searchResultList(){
        List<WebElement> searchResults = driver.findElements(searchResultsLocator);
        List<String> productsNameList = new ArrayList<String>();
        for(int i = 0; i < searchResults.size(); i++){
            productsNameList.add(searchResults.get(i).getText());
        }
        return productsNameList;
    }
}
