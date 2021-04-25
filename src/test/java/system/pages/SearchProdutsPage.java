package system.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    private Actions action;

    private By searchResultsLocator = By.cssSelector("a[class=\"item-card__description__product-name\"]>span");
    private By errorMessageOneLocator = By.cssSelector("div[class=\"divisor-bottom no-results\"]>.wrapper>h2");
    private By errorMessageTwoLocator = By.cssSelector("div[class=\"divisor-bottom no-results\"]>.wrapper>h3");
    private By searchSuggestionsListLocator = By.cssSelector("ul[data-suggestion-list]>li:nth-child(3)");
    private By suggestionProductsListLocator = By.cssSelector("div[class=\"top-results small\"]>a>figure>figcaption>span[class=\"name\"]");

    /*
     Services
     */

    public SearchProdutsPage() {
        driver = DriverManager.getDriver();
        wait = DriverManager.getDriverWait();
        action = new Actions(driver);
    }

    public List<String> searchResultList(){
        List<WebElement> searchResults = driver.findElements(searchResultsLocator);
        List<String> productsNameList = new ArrayList<String>();
        for(int i = 0; i < searchResults.size(); i++){
            productsNameList.add(searchResults.get(i).getText());
        }
        return productsNameList;
    }

    public List<String> errorSearchMessage(){
        WebElement errorMessageTitle = driver.findElement(errorMessageOneLocator);
        WebElement errorMessageSubTitle = driver.findElement(errorMessageTwoLocator);
        List<String> errorMessageList = new ArrayList<String>();
        errorMessageList.add(errorMessageTitle.getText());
        errorMessageList.add(errorMessageSubTitle.getText());
        return errorMessageList;
    }


    public List<List> hoverSuggestionList() throws InterruptedException {
        List<List> productsListsuggested = new ArrayList<List>();

        for(int i = 0; i < 5; i++){
            By searchSuggestionsListLocator = By.cssSelector("ul[data-suggestion-list]>li:nth-child("+(i+1)+")");
            this.wait.until(ExpectedConditions.visibilityOfElementLocated(searchSuggestionsListLocator));
            WebElement suggestions = driver.findElement(searchSuggestionsListLocator);
            action.moveToElement(suggestions).perform();
            Thread.sleep(5000);
            List<WebElement> products = driver.findElements(suggestionProductsListLocator);
            List<String> productsSuggested = new ArrayList<String>();
            for(int t = 0; t < products.size(); t++) {
                productsSuggested.add(products.get(t).getText());
            }
            productsListsuggested.add(productsSuggested);
        }

        return productsListsuggested;

    }

}
