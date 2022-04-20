package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        // find usernameField and enter valid username
        WebElement usernameField = driver.findElement(By.xpath("//input[@name = 'username']"));
        usernameField.sendKeys("A123");
        // find passwordField and enter valid password
        WebElement passwordField = driver.findElement(By.xpath("//input[@name = 'password']"));
        passwordField.sendKeys("password@1");
        // find and click on ‘LOGIN’ button
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button'][1]"));
        loginButton.click();
        // Verify the ‘Accounts Overview’ text is display
        // it is from requirement
        String expectedTextDisplay = "Accounts Overview";
        // find and get actual text from webpage
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[@class='title']"));
        String actualTextDisplay = actualTextElement.getText();
        System.out.println(actualTextDisplay);
        // Verify expected and actual text message
        Assert.assertEquals("Expected Text is not displayed",expectedTextDisplay,actualTextDisplay);

    }
    @Test
    public void verifyTheErrorMessage(){
        // find usernameField and enter invalid username
        WebElement usernameField = driver.findElement(By.xpath("//input[@name = 'username']"));
        usernameField.sendKeys("AAAA");
        // find passwordField and enter invalid password
        WebElement passwordField = driver.findElement(By.xpath("//input[@name = 'password']"));
        passwordField.sendKeys("p@1");
        // find and click on ‘LOGIN’ button
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button'][1]"));
        loginButton.click();
        // Verify the error message ‘The username and password could not be verified.’
        // it is from requirement
        String expectedTextDisplay = "The username and password could not be verified.";
        // find and get actual text from webpage
        WebElement actualTextElement = driver.findElement(By.xpath("//p[@class='error']"));
        String actualTextDisplay = actualTextElement.getText();
        System.out.println(actualTextDisplay);

    }
    @Test
    public void userShouldLogOutSuccessfully(){
        // find usernameField and enter valid username
        WebElement usernameField = driver.findElement(By.xpath("//input[@name = 'username']"));
        usernameField.sendKeys("A123");
        // find passwordField and enter valid password
        WebElement passwordField = driver.findElement(By.xpath("//input[@name = 'password']"));
        passwordField.sendKeys("password@1");
        // find and click on ‘LOGIN’ button
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button'][1]"));
        loginButton.click();
        // find and click on ‘Log Out’ link
        WebElement logOutButton = driver.findElement(By.xpath("//a[text()='Log Out']"));
        logOutButton.click();
        // Verify the text ‘Customer Login’
        // it is from requirement
        String expectedText = "Customer Login";
        // find and get actual text from webpage
        WebElement actualTextElement = driver.findElement(By.tagName("h2"));
        String actualText  = actualTextElement.getText();
        System.out.println(actualText);
        // Verify expected and actual text
        Assert.assertEquals("'Customer Login' text can't be found",expectedText,actualText);

    }


    @After
    public void tearDown(){
        closeBrowser();
    }

}
