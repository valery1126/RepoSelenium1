package selenium;

import PageObjects.*;
import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestAccount extends BaseClass {

    @Description("Validate test login was successful")
    @Test(description = "Test Login Success")
    public void Test_Login_Successful(){
        HeaderPage headerPage = new HeaderPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        String username = "juan.piedra@ucreativa.com";
        String password = "asdf";

        //Go To Login Page
        headerPage.clickOnMyAccount();
        headerPage.clickOnLoginButton();

        /*
        EJEMPLO DE LISTAS Y WEBELEMENTS SOLOS
        WebElement WishList = driver.findElement(By.linkText("Wish List"));
        ArrayList<> WishListList = driver.findElements(By.linkText("Wish List"));
        */

        //Llenar formulario
        loginPage.EnterEmail(username);
        loginPage.EnterPassword(password);
        loginPage.ClickSubmitButton();

        WebElement logOutButton = driver.findElement(By.linkText("Logout"));
        Assert.assertTrue(logOutButton.isDisplayed());
    }

    @Description("Validate that the login is working with non valid credentials")
    @Test(description = "Test Login Not Success")
    public void Test_Login_Unsuccessful(){

        LoginPage loginPage = new LoginPage(driver);
        String username = "juan.piedra@ucreativa.com";
        String password = "asdfasdf";
        String expectedMessage = "warning: no match for e-mail address and/or password.";

        loginPage.GoTo();
        loginPage.login(username, password);

        WebElement alertMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        Assert.assertEquals(expectedMessage.toLowerCase(), alertMessage.getText().toLowerCase().trim());
    }

    @Test
    public void Test_Create_New_Account(){
        //SETUP
        String firstName = "Juan";
        String lastName = "Piedra";
        String email = "juan@piedra.com";
        String telephone = "11111";
        String password = "asdf";
        String expectedMessage = "Your Account Has Been Created!";
        RegisterPage registerPage = new RegisterPage(driver);

        //RUN
        registerPage.GoTo();
        registerPage.FillForm(firstName, lastName, email, telephone, password);

        //VALIDATION
        Assert.assertEquals(registerPage.GetConfirmationMessage(), expectedMessage);
    }

    /* PROYECTO
    * Validacion de email existente.
     */
    @Test
    public void Test_Create_New_Account_CheckEmail(){
        //SETUP
        String firstName = "Juan";
        String lastName = "Piedra";
        String email = "juan@piedra.com";
        String telephone = "11111";
        String password = "asdf";
        String expectedMessage = "Warning: E-Mail Address is already registered!";
        RegisterPage registerPage = new RegisterPage(driver);

        //RUN
        registerPage.GoTo();
        registerPage.FillForm(firstName, lastName, email, telephone, password);

        //VALIDATION
        Assert.assertEquals(registerPage.GetEmailMessage(), expectedMessage);
    }

    /* PROYECTO
     * Creacion de cuentas con el email random.
     */
    @Test
    public void Test_Create_New_Account_EmailRandom(){
        //SETUP
        String firstName = "Ana";
        String lastName = "Mora";
        String email = Utils.generateRandomEmail(5);
        String telephone = "88888888";
        String password = "asdf1234";
        String expectedMessage = "Your Account Has Been Created!";
        RegisterPage registerPage = new RegisterPage(driver);

        //RUN
        registerPage.GoTo();
        registerPage.FillForm(firstName, lastName, email, telephone, password);

        //VALIDATION
        Assert.assertEquals(registerPage.GetConfirmationMessage(), expectedMessage);
    }



}