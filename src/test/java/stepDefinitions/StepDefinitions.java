package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class StepDefinitions {
    private WebDriver driver;

    @Given("I navigate to a page mailchimp.com")
    public void iNavigateToAPageMailchimpCom() {
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Selenium\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.get("https:\\/\\/login.mailchimp.com\\/signup/");
        driver.manage().window().maximize();

    }
    @When("I write valid email as {string}")
    public void iWriteValidEmailAs(String email) {
        WebElement emailInput = driver.findElement(By.cssSelector("#email"));
        emailInput.sendKeys(email);
    }


    @And("I write also available username as {string}")
    public void iWriteAlsoAvailableUsernameAsUsername(String username) {
        WebElement usernameInput = driver.findElement(By.cssSelector("#new_username"));
        usernameInput.sendKeys(username);
    }

    @And("I choose correct password as {string}")
    public void iChooseCorrectPasswordAsPassword(String password) {
        WebElement passwordInput = driver.findElement(By.cssSelector("#new_password"));
        passwordInput.click();
        password = "HelloThere1*";
        passwordInput.sendKeys(password);
    }

    @Then("I can be {string} as a new user")
    public void iCanBeRegisteredAsANewUser(String registration) {
       // throw new io.cucumber.java.PendingException();
        WebElement signUpButton = driver.findElement(By.id("slot-preShell"));
        signUpButton.click();

    }


/*
    @When("I write valid email as {string}")
    public void iWrite(String email) {
        WebElement emailInput = driver.findElement(By.cssSelector("#email"));
        
        emailInput.sendKeys(email);
        //throw new io.cucumber.java.PendingException();


    }

    @And("I write also available username as {string}")
    public void iWriteAlso(String arg0) {

        throw new io.cucumber.java.PendingException();
    }


    @And("I choose correct password as {string}")
    public void iChooseCorrect(String arg0) {
        throw new io.cucumber.java.PendingException();
    }


    @Then("I can be {string} as a new user")
    public void iCanBeAsANewUser(String arg0) {
        throw new io.cucumber.java.PendingException();

    }

*/

}
