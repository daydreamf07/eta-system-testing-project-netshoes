package system.stepDefinitions;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import system.pages.MainPage;
import system.pages.SearchProdutsPage;

import java.util.List;
import java.util.Locale;

import static system.helpers.Constants.ERROR_MESSAGE_SUB_TITLE;
import static system.helpers.Constants.ERROR_MESSAGE_TITLE;

public class searchProductStepDefinition {

    private MainPage page = new MainPage();
    private SearchProdutsPage searchPage = new SearchProdutsPage();

    @After
    public void doSomethingAfter(Scenario scenario){
        page.closePage();
    }

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

    @Then("I verify that an error message informing there is no results for the searched product is displayed")
    public void verifyErrorMessage() {
        List<String> errorMessageList = searchPage.errorSearchMessage();
        Assertions.assertEquals(ERROR_MESSAGE_TITLE, errorMessageList.get(0).toLowerCase());
        Assertions.assertEquals(ERROR_MESSAGE_SUB_TITLE, errorMessageList.get(1).toLowerCase());
    }
}
