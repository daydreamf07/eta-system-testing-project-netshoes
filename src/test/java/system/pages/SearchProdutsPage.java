package system.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import system.helpers.DriverManager;

public class SearchProdutsPage {

    /*
     Representation
     */

    private WebDriver driver;
    private WebDriverWait wait;

    private By searchInput = By.id("search-input");
    private By buttonSearch = By.cssSelector("button[qa-automation=\"home-search-button\"]");

    /*
     Services
     */

    public SearchProdutsPage() {
        driver = DriverManager.getDriver();
        wait = DriverManager.getDriverWait();
    }
    


}
