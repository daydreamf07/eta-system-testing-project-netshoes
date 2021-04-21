package system.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
    }

}
