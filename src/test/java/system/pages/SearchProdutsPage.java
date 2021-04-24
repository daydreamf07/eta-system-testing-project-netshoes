package system.pages;

import system.helpers.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchProdutsPage {
    
    private WebDriver driver;
    private WebDriverWait wait;


    public SearchProdutsPage(){
        this.driver = DriverManager.getDriver();
        this.wait = DriverManager.getDriverWait();
    }

    public void clickInSectionTab(String sectionName){
        By section = By.xpath("//li[@class='swiper-slide swiper-slide-text swiper-slide-next']//a//div[contains(text(), '"+sectionName+"')]");
        WebElement sectionTab = this.driver.findElement(section);
        sectionTab.click();
    }

    public String getSectionName(){
        By section = By.cssSelector(".search-query");
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(section));
        WebElement sectionTitle = this.driver.findElement(section);
        return sectionTitle.getText(); 
    }

    


}
