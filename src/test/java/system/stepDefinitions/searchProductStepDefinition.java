package system.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import system.pages.MainPage;
import system.pages.SearchProdutsPage;

import java.util.List;
import java.util.Locale;

public class searchProductStepDefinition {

    private MainPage page = new MainPage();
    private SearchProdutsPage searchPage = new SearchProdutsPage();

    @Given("I access the store's main page")
    public void accessMainPage() {
        page.accessPage();
    }

    @Given("I click on the search bar")
    public void clickSearchBar() {
        page.clickSearchBar();
    }

    @When("I type the product name {string}")
    public void searchByProduct(String product) {
        page.searchInput(product);
    }

    @When("I click on the search button")
    public void clickSearchButton() {
        page.clickButtonSearch();
    }

    @Then("I verify that the list of products related to the search of {string} is displayed")
    public void resultSearchlist(String product) {
        List<String> searchResult = searchPage.searchResultList();

        for(int i = 0; i < searchResult.size(); i++){
            String searchResultProduct = searchResult.get(i).toLowerCase();
            Assertions.assertTrue(searchResultProduct.contains(product.toLowerCase()));
        }
    }
}
