package selenium;

import PageObjects.BaseClass;
import PageObjects.SearchResultsPage;
import dataProviders.SearchProvider;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.SearchData;

public class TestSearch extends BaseClass {

    @Test
    //@Parameters({"searchCriteria", "expectedResult"})
    public void Validate_Search(){
        /*int results = Integer.parseInt(expectedResult);

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(searchCriteria, Keys.ENTER);

        Assert.assertTrue(driver.getCurrentUrl().contains("search="+searchCriteria));

        // Assert.assertEquals(results.size(), expectedResult,
        //        String.format("Expecting %s results, but got %s", expectedResult, results.size()));

        Assert.assertEquals(getResults(), results,
                "Expecting " + expectedResult + " results, but got " + getResults());*/

        String searchCriteria = "macbook";
        String expectedResult = "3";
        SearchResultsPage searchPage = new SearchResultsPage(driver);

        //RUN
        searchPage.search(searchCriteria);
        String results = String.valueOf(searchPage.getResultsCount());

       //VALIDATION
        Assert.assertEquals(results, expectedResult);

    }

    @Test
    public void Test_Empty_Results(){
        /*String searchCriteria = "Star Wars";
        int expectedResult = 0;

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(searchCriteria, Keys.ENTER);

        Assert.assertEquals(getResults(), expectedResult,
                "Expecting " + expectedResult + " results, but got " + getResults());*/

        String searchCriteria = "Star Wars";
        String expectedResult = "0";
        SearchResultsPage searchPage = new SearchResultsPage(driver);

        //RUN
        searchPage.search(searchCriteria);
        String results = String.valueOf(searchPage.getResultsCount());

        //VALIDATION
        Assert.assertEquals(results, expectedResult);



    }

    public int getResults(){
        return driver.findElements(By.cssSelector(".product-thumb")).size();
    }

    @Test (dataProvider = "getSearchDataFromJson", dataProviderClass = SearchProvider.class)
    public void Test_Search_WithData(SearchData testData){
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(testData.getSearchCriteria());

        driver.findElement(By.xpath("//div[@id='search']/span/button")).click();

        if(testData.getExpectedResults() > 0){
            Assert.assertEquals(searchResultsPage.getResultsCount(), testData.getExpectedResults());
        }
        else{
            Assert.assertTrue(searchResultsPage.isNoResultsVisible());
        }
    }

}