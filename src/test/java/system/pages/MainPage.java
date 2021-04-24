package system.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import system.helpers.DriverManager;
import static system.pages.URL.MAIN_PAGE;

public class MainPage {

    /*
     Representation
     */

    private WebDriver driver;
    private WebDriverWait wait;

    private By siteLogo = By.cssSelector(".logo > h1");
    private By searchInput = By.id("search-input");
    private By buttonSearch = By.cssSelector("button[qa-automation=\"home-search-button\"]");

    /*
     Services
     */

    public MainPage() {
        driver = DriverManager.getDriver();
        wait = DriverManager.getDriverWait();
    }

    public void accessPage(){
        driver.get(MAIN_PAGE);
        wait.until(ExpectedConditions.visibilityOfElementLocated(siteLogo));
        driver.manage().window().maximize();
    }

    public void clickSearchBar(){
        WebElement searchBar = this.driver.findElement(searchInput);
        searchBar.click();
    }

    public void searchInput(String product){
        WebElement searchBar = this.driver.findElement(searchInput);
        searchBar.sendKeys(product);
    }

    public void clickButtonSearch(){
        WebElement searchButton = this.driver.findElement(buttonSearch);
        searchButton.click();
    }
}
