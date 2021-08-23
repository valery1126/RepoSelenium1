package selenium;

import PageObjects.*;
import dataProviders.ProductProvider;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.Products;


public class TestPriceProduct extends BaseClass {

    /* PROYECTO
    * Verificar el precio de un producto en las distintas monedas.
     */

    @Test (dataProvider = "getProductsDataFromJson", dataProviderClass = ProductProvider.class)
    public void ChekPrice_Product(Products testData){
        ProductPage productPage = new ProductPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        HomePage homePage = new HomePage(driver);
        //Buscar el producto
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.search(testData.getName());
        String name = homePage.selectFirstProductAndGetName();
        Assert.assertTrue(productPage.isTitleDisplayed(name));
        //Dolar
        headerPage.clickOnCurrencyButton();
        headerPage.clickOnCurrencyDolarButton();
        Assert.assertTrue(productPage.checkPriceProduct(headerPage.getCurrency(),testData.getDolarsPrice()));
        //Euro
        headerPage.clickOnCurrencyButton();
        headerPage.clickOnCurrencyEuroButton();
        Assert.assertTrue(productPage.checkPriceProduct(headerPage.getCurrency(),testData.getEuroPrice()));
        //Pound Sterling
        headerPage.clickOnCurrencyButton();
        headerPage.clickOnCurrencyPoundButton();
        Assert.assertTrue(productPage.checkPriceProduct(headerPage.getCurrency(),testData.getPoundsPrice()));

    }

    @Test (dataProvider = "getProductsDataFromJson", dataProviderClass = ProductProvider.class)
    public void ChekPrice_Euro(Products testData){
        ProductPage productPage = new ProductPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        HomePage homePage = new HomePage(driver);
        //Buscar el producto
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.search(testData.getName());
        String name = homePage.selectFirstProductAndGetName();
        Assert.assertTrue(productPage.isTitleDisplayed(name));

        headerPage.clickOnCurrencyButton();
        headerPage.clickOnCurrencyEuroButton();

        Assert.assertTrue(productPage.checkPriceProduct(headerPage.getCurrency(),testData.getEuroPrice()));

    }
}
