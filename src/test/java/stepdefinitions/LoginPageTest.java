package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;

import java.time.Duration;


public class LoginPageTest {
    WebDriver driver;
    LoginPage loginPage;
    WebDriverWait wait;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\supri\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.get("https://qamoviesapp.ccbp.tech/login");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Test LoginPage UI

    @Given("I want to visit on login page and verify Website logo")
    public void  testWebsiteLogo(){
        WebElement logo = loginPage.getWebsiteLogo();
        Assert.assertTrue(logo.isDisplayed(), "Website Logo is not displayed");
    }

    @When("I want to verify Heading on form Login")
    public void testHeadingText(){
        String currentHeadingText = loginPage.getHeadingText();
        Assert.assertEquals(currentHeadingText,"Login", "Heading text doesn't matched");
    }

    @And("I want to verify UserName Label Text USERNAME")
    public void testUserNameLabelText(){
        String currentUserNameLabelText = loginPage.getUsernameLabelText();
        Assert.assertEquals(currentUserNameLabelText, "USERNAME", "username label text doesn't matched");
    }

    @But("I want to verify Password Label Text PASSWORD")
    public void testPassWordLabelText(){
        String currentPasswordLabelText = loginPage.getpasswordLabelText();
        Assert.assertEquals(currentPasswordLabelText, "PASSWORD", "password label text doesn't matched");
    }

    @Then("I want to verify login button")
    public void testLoginButton(){
        WebElement loginButton = loginPage.getLoginButton();
        Assert.assertTrue(loginButton.isDisplayed(), "Login Button is not displayed");
    }

    // Test LoginPage Functionality
    @Given("I want to login with empty input Field")
    public void testLoginFunctionalityWithEmptyInput(){
        loginPage.getLoginButton().click();
        Assert.assertEquals(loginPage.getErrorMsg(), "*Username or password is invalid", "Error-msg doesn't matched");
    }
    @When("I want to verify error-msg with empty username")
    public void testLoginFunctionalityWithEmptyUserName(){
        loginPage.getPasswordInput("rahul@2021");
        Assert.assertEquals(loginPage.getErrorMsg(), "*Username or password is invalid", "Error-msg for empty-user doesn't matched");
    }
    @And("I want to verify error-msg with empty password")
    public void testLoginFunctionalityWithEmptyPassword(){
        loginPage.getUserNameInput("rahul");
        Assert.assertEquals(loginPage.getErrorMsg(), "*Username or password is invalid", "Error-msg for empty-password doesn't matched");
    }
    @But("I want to test login with Invalid cred")
    public void testLoginFunctionalityWithInvalidCreds(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#usernameInput")));
        loginPage.getLogin("rahul", "rahul2021");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.error-message")));
        Assert.assertEquals(loginPage.getErrorMsg(), "*Username or password is invalid", "Error-msg for invalid-cred doesn't matched");
    }

    @Then("I want to test login with valid cred Successfully")
    public void testLoginFunctionalityWithValidCreds(){
        loginPage.getLogin("rahul", "rahul@2021");
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://qamoviesapp.ccbp.tech/", "URL doesn't matched");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
