
import MailChimp.Registeruser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static junit.framework.TestCase.assertEquals;


public class CreateUserStepdefs {

    Registeruser generator = new Registeruser();


    private WebDriver drivers;


    @Before
    public void setUp(){


        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        drivers = new ChromeDriver(options);




    }

    @Given("The user is on the registration page")
    public void theUserIsOnTheRegistration() {
        drivers.get("https://login.mailchimp.com/signup/");
    }

    @When("User enters a valid Email {string}")
    public void userEntersAValidEmail(String email) {
        WebElement validEmail = drivers.findElement(By.id("email"));
        validEmail.sendKeys(email);

        }



    @And("User enters a valid Username {string}")
    public void userEntersAValidUsername(String username) {

        WebElement validname = drivers.findElement(By.id("new_username"));
        validname.sendKeys(username);
    }

    @And("User enters a valid password {string}")
    public void userEntersAValidPassword(String password) {
        WebElement validpassword =  drivers.findElement(By.id("new_password"));
        validpassword.sendKeys(password);
    }

    @And("User clicks on sign up")
    public void userClicksOnSignUp() {

        drivers.findElement(By.id("create-account-enabled")).submit();



    }



    @Then("User sucessfully creates an account")
    public void anAccountIsSuccesfulCreated() {

        String actual = getWait().getText();
        String expected = "Check your email";
            assertEquals(expected,actual);

    }

    private WebElement getWait() {
        WebDriverWait wait = new WebDriverWait(drivers, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("!margin-bottom--lv3")));
        return drivers.findElement(By.className("!margin-bottom--lv3"));
    }

    private WebElement getWaitsec() {
        WebDriverWait waitsec = new WebDriverWait(drivers, Duration.ofSeconds(10));
        waitsec.until(ExpectedConditions.visibilityOfElementLocated(By.className("invalid-error")));
        return drivers.findElement(By.className("invalid-error"));
    }

    private WebElement getWaitthird() {
        WebDriverWait waitthird = new WebDriverWait(drivers, Duration.ofSeconds(10));
        waitthird.until(ExpectedConditions.visibilityOfElementLocated(By.className("invalid-error")));
        return drivers.findElement(By.className("invalid-error"));
    }

    private WebElement getWaitforth() {
        WebDriverWait waitforth = new WebDriverWait(drivers, Duration.ofSeconds(10));
        waitforth.until(ExpectedConditions.visibilityOfElementLocated(By.className("invalid-error")));
        return drivers.findElement(By.className("invalid-error"));
    }




    @After
    public void tearDown() {drivers.quit();}

    @When("the user enters a username containing more than hundred letters")
    public void theUserEntersAUsernameContainingLettersOrMore() {

        WebElement novalidname = drivers.findElement(By.id("new_username"));
    novalidname.sendKeys(generator.generateRandomString(101));
    }

    @Then("an error occurs indicating that max number of letters for username is onehundred")
    public void anErrorOccursIndicatingThatMaxNumberOfLettersForUsernameIsOnehundred() {
        String actual = getWaitsec().getText();
        String expected = "Enter a value less than 100 characters long";

        assertEquals(expected,actual);
    }

    @When("User enters a valid Username that is already in use {string}")
    public void userEntersAValidUsernameThatIsAlreadyInUse(String username) {

        WebElement novalidname = drivers.findElement(By.id("new_username"));
        novalidname.sendKeys(username);
    }

    @Then("an error occurs indicating that the username is already in use")
    public void anErrorOccursIndicatingThatTheUsernameIsAlreadyInUse() {

        String actual = getWaitthird().getText();
        String expected = "Great minds think alike - someone already has this username. If it's you, log in.";

        assertEquals(expected,actual);
    }

    @Then("an error occurs due to leaving the email field empty")
    public void anErrorOccursDueToLeavingTheEmailFieldEmpty() {

        String actual = getWaitforth().getText();
        String expected = "An email address must contain a single @.";
        assertEquals(expected,actual);
    }

    @When("User enters a random Email")
    public void userEntersARandomEmail() {
        WebElement validEmail = drivers.findElement(By.id("email"));
        validEmail.sendKeys(generator.generateRandomEmail());
    }

    @And("User enters a random password")
    public void userEntersARandomPassword() {
        WebElement validpassword =  drivers.findElement(By.id("new_password"));
        validpassword.sendKeys(generator.generateRandomPassword());
    }
}
