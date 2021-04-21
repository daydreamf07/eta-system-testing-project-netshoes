package system.stepDefinitions;

import io.cucumber.java.en.Given;
import system.pages.MainPage;

public class searchProductStepDefinition {

    private MainPage page;

    @Given("The client access the store's main page")
    public void accessMainPage() {
        page = new MainPage();
        page.accessPage();
    }

}
