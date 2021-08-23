package selenium;

import PageObjects.*;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTests extends BaseClass {
    @Description("Validate that add to cart is working")
    @Test
    public void Test_Add_To_Cart_Functionality(){
        /**
         * opciones de navegación
         * 1. search
         * 2. home add to cart  *****
         * 3. home -> Product Page -> add to cart
         * 4. contruir la URL
         * */
        int quantity = 5;

        HeaderPage headerPage = new HeaderPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        String name = homePage.selectFirstProductAndGetName();
        Assert.assertTrue(productPage.isTitleDisplayed(name));
        productPage.SetQuantity(quantity);
        productPage.clickAddButton();
        Assert.assertTrue(productPage.isAlertSuccessDisplayed());
        headerPage.clickOnCartButton();
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Assert.assertTrue(shoppingCartPage.isProductNameDisplayed(name), "Title was not displayed");
        Assert.assertEquals(shoppingCartPage.getProductQuantity(), quantity, "Quantity is not matching");

    }
    /* PROYECTO
    * Buscar producto y agregarlo al carrito
    * */
    @Description("Validate that add to cart is working when I search the product")
    @Test
    public void Test_Add_To_Cart_SearchProduct(){

        int quantity = 2;

        HeaderPage headerPage = new HeaderPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        searchResultsPage.search("iPhone");
        String name = homePage.selectFirstProductAndGetName();
        Assert.assertTrue(productPage.isTitleDisplayed(name));

        productPage.SetQuantity(quantity);
        productPage.clickAddButton();
        Assert.assertTrue(productPage.isAlertSuccessDisplayed());

        headerPage.clickOnCartButton();
        String expectedMessage = "Products marked with *** are not available in the desired quantity or not in stock!";
        shoppingCartPage.clickOnCheckOutButton();

        //VALIDATION
        if (shoppingCartPage.GetQuantityMessage().contains(expectedMessage)){
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }
        //Assert.assertEquals(shoppingCartPage.GetQuantityMessage(), expectedMessage);

    }

}