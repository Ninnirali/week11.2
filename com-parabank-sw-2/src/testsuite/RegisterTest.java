package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.JsonOutput;
import org.w3c.dom.ls.LSOutput;

public class RegisterTest extends BaseTest {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay(){
        // Find and click on the ‘Register’ link
        WebElement registerLinkElement = driver.findElement(By.xpath("//a[text()='Register']"));
        registerLinkElement.click();
        // Verify the text ‘Signing up is easy!’
        // It is from requirement
        String actualText = "Signing up is easy!";
        // find and get text from expected text Element
        WebElement expectedTextElement = driver.findElement(By.xpath("//h1[text()='Signing up is easy!']"));
        String expectedText =  expectedTextElement.getText();
        System.out.println(expectedText);
        // Verify expected and actual text
        Assert.assertEquals("Text:'Signing up is easy!' is not displayed",expectedText,actualText);

    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        // find and click on the ‘Register’ link
        WebElement registerLinkElement = driver.findElement(By.xpath("//a[text()='Register']"));
        registerLinkElement.click();
        // find firstname field and enter First name
        WebElement firstNameField = driver.findElement(By.id("customer.firstName"));
        firstNameField.sendKeys("Alexa");
        // find last name field and enter last name
        WebElement lastNameField = driver.findElement(By.id("customer.lastName"));
        lastNameField.sendKeys("Smith");
        // find address field and enter address
        WebElement addressField = driver.findElement(By.id("customer.address.street"));
        addressField.sendKeys("13,London Road");
        // find city field and enter city
        WebElement cityField = driver.findElement(By.name("customer.address.city"));
        cityField.sendKeys("London");
        // find state field and enter state
        WebElement stateField = driver.findElement(By.id("customer.address.state"));
        stateField.sendKeys("Greater London");
        // find zip code field and enter zip code
        WebElement zipCodeField = driver.findElement(By.id("customer.address.zipCode"));
        zipCodeField.sendKeys("W13EC");
        // find phone field and enter phone
        WebElement phoneField = driver.findElement(By.id("customer.phoneNumber"));
        phoneField.sendKeys("07888996756");
        // find ssnField and enter SSN
        WebElement ssnField = driver.findElement(By.id("customer.ssn"));
        ssnField.sendKeys("QQ 123456 C");
        // find userNameField and enter userName
        WebElement usernameField = driver.findElement(By.id("customer.username"));
        usernameField.sendKeys("A123");
        // find passwordField  and enter password
        WebElement passwordField = driver.findElement(By.id("customer.password"));
        passwordField.sendKeys("password@1");
        // end confirm field and enter password again to confirm
        WebElement confirmPasswordField = driver.findElement(By.id("repeatedPassword"));
        confirmPasswordField.sendKeys("password@1");
        // find and click on REGISTER button
        WebElement registerButton = driver.findElement(By.xpath("(//input[@class='button'])[2]"));
        registerButton.click();
        // Verify the text 'Your account was created successfully. You are now logged in.’
        // It is from requirement
        String expectedTextMessage = "Your account was created successfully. You are now logged in.";
        // Find and Get actual text from the webpage
        WebElement actualTextElement = driver.findElement(By.xpath("//p[text()='Your account was created successfully. You are now logged in.']"));
        String actualTextMessage = actualTextElement.getText();
        System.out.println(actualTextMessage);
        // verify expected and actual text message
        Assert.assertEquals("Expected Text can't be found",expectedTextMessage,actualTextMessage);

    }



    @After
    public void tearDown(){
        closeBrowser();
    }
}
