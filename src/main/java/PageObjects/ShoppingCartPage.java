package PageObjects;

import Selectors.HomePageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BaseClass{

    public String ProductNameLocator = "//table/tbody/tr/td/a[text()='<name>']";
    public By ProductQuantityLocator = By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[4]/div/input");
    public By CheckOut = By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a");
    private By QuantityMessageLocator = By.xpath("//*[@id=\"checkout-cart\"]/div[1]");


    public ShoppingCartPage(WebDriver _driver){
        this.driver = _driver;
    }

    public boolean isProductNameDisplayed(String name){
        return driver.findElement(By.xpath(ProductNameLocator.replace("<name>", name))).isDisplayed();
    }
    public int getProductQuantity(){
        return Integer.parseInt(driver.findElement(ProductQuantityLocator).getAttribute("value"));
    }

    public void clickOnCheckOutButton(){
        driver.findElement(CheckOut).click();
    }

    public String GetQuantityMessage(){
        return driver.findElement(QuantityMessageLocator).getText();
    }
}
