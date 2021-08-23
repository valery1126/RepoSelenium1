package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {
    private WebDriver driver;

    //Elementos
    private By myAccountLinkLocator = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]");
    private By loginButtonLocator = By.linkText("Login");
    private By registerButtonLocator = By.linkText("Register");
    private By shoppingCartLocator = By.linkText("Shopping Cart");
    private By currency = By.xpath("//*[@id=\"form-currency\"]/div/button/strong");
    private By currencyButton = By.xpath("//*[@id=\"form-currency\"]/div/button");
    private By currencyDolar = By.name("USD");
    private By currencyEuro = By.name("EUR");
    private By currencyPoundSterling = By.name("GBP");


    public HeaderPage(WebDriver _driver){
        this.driver = _driver;
    }

    public void clickOnMyAccount(){
        driver.findElement(myAccountLinkLocator).click();
    }
    public void clickOnLoginButton(){
        driver.findElement(loginButtonLocator).click();
    }
    public void clickOnRegisterButton(){
        driver.findElement(registerButtonLocator).click();
    }

    public void clickOnCartButton(){
        driver.findElement(shoppingCartLocator).click();
    }

    public void clickOnCurrencyButton(){
        driver.findElement(currencyButton).click();
    }

    public void clickOnCurrencyDolarButton(){
        driver.findElement(currencyDolar).click();
    }
    public void clickOnCurrencyEuroButton(){
        driver.findElement(currencyEuro).click();
    }
    public void clickOnCurrencyPoundButton(){
        driver.findElement(currencyPoundSterling).click();
    }

    public String getCurrency(){
        return driver.findElement(currency).getText();
    }


}
