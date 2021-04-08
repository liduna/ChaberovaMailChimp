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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {
    private WebDriver driver;

    private void waitUntil(WebDriver driver, By by) {
        (new WebDriverWait(driver, 15)).until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }



    @Given("I navigate to a page mailchimp.com")
    public void i_navigate_to_a_page_mailchimp_com() {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https:\\/\\/login.mailchimp.com\\/signup/");

        waitUntil(driver, By.cssSelector("#onetrust-accept-btn-handler"));
    }

    @When("I write an email as {string}")
    public void i_write_an_email_as(String email) {
        WebElement userEmail = driver.findElement(By.cssSelector("#email"));
        EmailInput testMail = new EmailInput();
        email = testMail.insertEmail(email);
        userEmail.sendKeys(email);
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
    public void i_click_on_sign_up_button() {
        WebElement cookies = driver.findElement(By.cssSelector("#onetrust-accept-btn-handler"));
        if (cookies.isDisplayed()) cookies.click();

        WebElement signUpButton = driver.findElement(By.cssSelector("#create-account"));
        signUpButton.click();
    }


    @Then("I can see a correct {string} based on respective input")
    public void i_can_see_respective(String message) {


        if (driver.findElements(By.cssSelector(".invalid-error")).isEmpty()) {

          String confirmation = driver.findElement(By.cssSelector(".\\!margin-bottom--lv3")).getText();

            assertEquals(message, confirmation);

            System.out.println("The message displayed: "+ confirmation);

            driver.close();
        }

        else {
            String error = driver.findElement(By.cssSelector(".invalid-error")).getText();

            assertEquals(message, error);

            System.out.println("The message displayed: " + error);

            driver.close();
        }


    }




}









    

