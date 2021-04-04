package stepDefinitions;

import common.EmailInput;
import common.UserNameGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {
    private WebDriver driver;

    private void waitUntilClickable(WebDriver driver, By by) {
        (new WebDriverWait(driver, 15)).until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();


    }

    @Given("I navigate to a page mailchimp.com")
    public void i_navigate_to_a_page_mailchimp_com() {
        System.setProperty("webdriver.edge.driver", "C:\\Program Files\\Selenium\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https:\\/\\/login.mailchimp.com\\/signup/");
        //driver.manage().window().maximize();

        waitUntilClickable(driver, By.cssSelector("#onetrust-accept-btn-handler"));
    }


    @When("I write an email as {string}")
    public void i_write_an_email_as(String email) {
        WebElement emailInput = driver.findElement(By.cssSelector("#email"));
        EmailInput testMail = new EmailInput();
        email = testMail.insertEmail(email);
        emailInput.sendKeys(email);
    }


    @And("I write also a username as {string}")
    public void i_write_also_a_username_as(String username) {
        WebElement usernameInput = driver.findElement(By.cssSelector("#new_username"));
        UserNameGenerator testUser = new UserNameGenerator();
        username = testUser.generateUserName(username);
        usernameInput.sendKeys(username);
    }


    @And("I choose correct password as {string}")
    public void i_choose_correct_password_as(String password) {
        WebElement passwordInput = driver.findElement(By.cssSelector("#new_password"));
        passwordInput.click();
        password = "HelloThere1*";
        passwordInput.sendKeys(password);
    }


    @And("I click on signUp button")
    public void i_can_click_on_sign_up_button() {
        WebElement cookies = driver.findElement(By.cssSelector("#onetrust-accept-btn-handler"));
        if (cookies.isDisplayed()) cookies.click();

        WebElement signUpButton = driver.findElement(By.cssSelector("#create-account"));
        signUpButton.click();
    }


    @Then("I can see respective {string}")
    public void i_can_see_respective_based_on_valid(String message) {


        if  (message.equals("Signup successful")){

            WebElement confirmation = driver.findElement(By.cssSelector(".\\!margin-bottom--lv3"));
            message = confirmation.getText();
            assertEquals("Check your email", message);

            System.out.println(message);
        }
       else if (message.equals("No Email failure")){

            WebElement noEmail = driver.findElement(By.cssSelector(".line:nth-child(1) .invalid-error"));
            message = noEmail.getText();
            assertEquals("Please enter a value", message);

            System.out.println(message);

        }
        else if (message.equals("Long username failure")){

            // can not find element identifier on page due to an error.
            WebElement noEmail = driver.findElement(By.cssSelector("#new_username"));
            message = noEmail.getText();
            assertEquals("Enter a value less than 100 characters long", message);

            System.out.println(message);
        }
        else if (message.equals("Username taken failure")){


            // can not find element identifier on page due to an error.

            WebElement usernameTaken = driver.findElement(By.cssSelector(".line:nth-child(1) .invalid-error"));
            message = usernameTaken.getText();
            assertEquals("Another user with" +
                    "this username already exists. Maybe it's your evil twin. Spooky.", message);

            System.out.println(message);
        }


    }


/*

    @Given("I navigate to a page mailchimp.com")
    public void iNavigateToAPageMailchimpCom() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https:\\/\\/login.mailchimp.com\\/signup/");
        //driver.manage().window().maximize();

        waitUntil(driver, By.cssSelector("#onetrust-accept-btn-handler"));

    }

    @When("I write an email as {string}")
    public void iWriteValidEmailAs(String email) {

        WebElement emailInput = driver.findElement(By.cssSelector("#email"));
        EmailInput testMail = new EmailInput();
        email = testMail.insertEmail(email);
        emailInput.sendKeys(email);

    }


    @And("I write also a username as {string}")
    public void iWriteAlsoAvailableUsernameAsUsername(String username) {
        WebElement usernameInput = driver.findElement(By.cssSelector("#new_username"));
        UserNameGenerator testUser = new UserNameGenerator();
        username = testUser.generateUserName(username);
        usernameInput.sendKeys(username);

    }

    @And("I choose correct password as {string}")
    public void iChooseCorrectPasswordAsPassword(String password) {
        WebElement passwordInput = driver.findElement(By.cssSelector("#new_password"));
        passwordInput.click();
        password = "HelloThere1*";
        passwordInput.sendKeys(password);
    }

    @Then("I can click on signUp button")

    public void iCanClickSignUp() {

        WebElement cookies = driver.findElement(By.cssSelector("#onetrust-accept-btn-handler"));
        if (cookies.isDisplayed()) cookies.click();

        WebElement signUpButton = driver.findElement(By.cssSelector("#create-account"));
        signUpButton.click();

    }

  /*  @And("I see a respective {string} based on an {string}")
    public void iSeeAMessage(String message) {


        WebElement confirmationMessage = driver.findElement(By.className("!margin-bottom--lv3"));
        WebElement errorMessage = driver.findElement(By.className("padding--lv3"));


        MessageIdentifier identifier = new MessageIdentifier();
        message = identifier.identifyMessage(confirmationMessage.getText());


        boolean isSignedUp = true;
        boolean isNotSignedUp = false;

        assertEquals(isSignedUp, confirmationMessage.isDisplayed());
        assertEquals(isNotSignedUp, errorMessage.isDisplayed());




        /*assertEquals("Check your email",confirmationMessage.getText());

        System.out.println(confirmationMessage.getText());*/
        //driver.close();*/


/*
        
    }*/

}
    

