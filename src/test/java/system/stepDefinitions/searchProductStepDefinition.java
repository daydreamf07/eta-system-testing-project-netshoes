package system.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import system.pages.MainPage;

public class searchProductStepDefinition {

    private MainPage page = new MainPage();

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

    @Then("I verify that the list of products related to the search is displayed")
    public void resultSearchlist() {
    }

}
