package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BaseClass{

    //elementos
    public String ProductTitleSelector = "//h1[text()='<name>']";
    public By ProductQuantityInputSelector = By.id("input-quantity");
    public By AddButtonSelector = By.id("button-cart");
    public By AlertSuccess = By.cssSelector(".alert-success");
    public By PriceProduct = By.xpath("//*[@id=\"content\"]/div[1]/div[2]/ul[2]/li[1]/h2");

    public ProductPage(WebDriver _driver){ this.driver = _driver; }

    public boolean isTitleDisplayed(String name){
        return driver.findElement(By.xpath(ProductTitleSelector.replace("<name>", name))).isDisplayed();
    }

    public void SetQuantity(int quantity){
        driver.findElement(ProductQuantityInputSelector).clear();
        driver.findElement(ProductQuantityInputSelector).sendKeys("" + quantity);
    }

    public void clickAddButton(){
        driver.findElement(AddButtonSelector).click();
    }

    public boolean isAlertSuccessDisplayed(){
        return driver.findElement(AlertSuccess).isDisplayed();
    }

    public String getPriceProduct(){
        return driver.findElement(PriceProduct).getText();
    }


    public boolean checkPriceProduct(String currency, double price){

        String priceProduct = "";
        String pricePage = this.getPriceProduct();
        boolean check = false;

        switch (currency){
            case "€":
                priceProduct = price + "€";
                if (priceProduct.contains(pricePage)){
                    check = true;
                }
                break;
            case "$":
                priceProduct = "$"+price;
                if (priceProduct.equalsIgnoreCase(pricePage)){
                    check = true;
                }
                break;
            case "£":
                priceProduct = "£"+price;
                if (priceProduct.contains(pricePage)){
                    check = true;
                }
                break;
        }

        return check;
    }



}
