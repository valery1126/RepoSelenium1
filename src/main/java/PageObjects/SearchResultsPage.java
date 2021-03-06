package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BaseClass {

    private static final String ERROR_MESSAGE_NO_RESULTS_DISPLAYED = "There is no product that matches the search criteria.";

    //elementos
    private By resultsSelector = By.cssSelector(".product-thumb");
    private By noResultsSelector = By.id("content");
    private By searchButton = By.xpath("//*[@id=\"search\"]/span/button");
    private By searchText = By.name("search");

    public SearchResultsPage(WebDriver driver){
        super.driver = driver;
    }
    public int getResultsCount(){
        return driver.findElements(resultsSelector).size();
    }
    public boolean isNoResultsVisible(){
        return driver.findElement(noResultsSelector).getAttribute("innerHTML").contains(ERROR_MESSAGE_NO_RESULTS_DISPLAYED);
    }

    public void search(String text){
        driver.findElement(searchText).sendKeys(text);
        driver.findElement(searchButton).click();
    }



}