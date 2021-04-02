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

public class StepDefinitions {
    private WebDriver driver;

    private void waitUntil(WebDriver driver, By by){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    @Given("I navigate to a page mailchimp.com")
    public void iNavigateToAPageMailchimpCom() {
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Selenium\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.get("https:\\/\\/login.mailchimp.com\\/signup/");
        driver.manage().window().maximize();
        waitUntil(driver, By.cssSelector("#onetrust-accept-btn-handler"));
        /*WebElement cookies = driver.findElement(By.cssSelector("#onetrust-accept-btn-handler"));
        cookies.click();*/

    }
    @When("I write valid email as {string}")
    public void iWriteValidEmailAs(String email) {

        WebElement emailInput = driver.findElement(By.cssSelector("#email"));
        EmailInput testMail = new EmailInput();
        email =  testMail.insertEmail(email);
        emailInput.sendKeys(email);

    }


    @And("I write also available username as {string}")
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

    @Then("I can be {string} as a new user")
    public void iCanBeRegisteredAsANewUser(String registration) {
       // throw new io.cucumber.java.PendingException();
        WebElement signUpButton = driver.findElement(By.cssSelector("#create-account"));
        signUpButton.click();
        //login successful
        //https://login.mailchimp.com/signup/success/?username=4hw4iTm3hau7tXjV1q9fbPHUzm9ZdB6xx67wXMhbhjE2Fec7nyhIxQDVBlDN1Ihw4IqhBA47K1MIsidNjqtILc5Nmge7Cq6PckBx&userId=155511514&loginId=167178086

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
