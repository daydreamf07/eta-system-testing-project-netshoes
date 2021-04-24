package system.stepDefinitions;
import org.junit.jupiter.api.Assertions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import system.pages.SearchProdutsPage;


public class filterSearchResultsProducts_step{

    SearchProdutsPage searchProductsPage = new SearchProdutsPage();

    @Given("I click in {string} products")
    public void clickInSection(String section){
        searchProductsPage.clickInSectionTab(section);
    }

    @When("I am in {string} section")
    public void seeSectionDisplayed(String section){
        Assertions.assertEquals(searchProductsPage.getSectionName(), section);
    }
    









}