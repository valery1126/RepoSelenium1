import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MainEjemplo {

    public static void main(String[] args){

        String pathToDriver = MainEjemplo.class.getResource("/chromedriver.exe").getPath();
        System.setProperty("webdriver.chrome.driver", pathToDriver);

        WebDriver driver = new ChromeDriver();

        /*driver.get("https://demo.opencart.com/index.php?route=account/login");

        WebElement emailElement = driver.findElement(By.name("email"));
        emailElement.sendKeys("Hola@test.com");

        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys("asdfg");

        //WebElement loginButton = driver.findElement(By.xpath("//input[@type = 'submit']"));
        //loginButton.click();

        driver.findElement(By.xpath("//input[@type = 'submit']")).click();

        WebElement alertMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        Assert.assertTrue(alertMessage.isDisplayed());

        driver.close();
        driver.quit();*/

        driver.get("https://demo.opencart.com/");

        //Escribe el la barra de busqueda
       driver.findElement(By.name("search")).sendKeys("Macbook");


       driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();

       driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[2]/button[1]")).click();

        WebElement alertMessageSuccess = driver.findElement(By.xpath("//*[@id=\"product-search\"]/div[1]"));
        Assert.assertTrue(alertMessageSuccess.isDisplayed());

        driver.close();
        driver.quit();















    }

}
