package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.AccountsPage;
import pages.LoginPage;

import java.time.Duration;

public class AccountPageTest {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    AccountsPage accountsPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\supri\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginPage = new LoginPage(driver);
        loginPage.getLogin("rahul", "rahul@2021");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        accountsPage = new AccountsPage(driver);
    }

    @Given("I want to visit on Account Page and test UI elements")
    public void testUIelementsOnAccountPage(){
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
        accountsPage.clickOnAccountBtn();
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/account"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://qamoviesapp.ccbp.tech/account", "Navigation to account page failed");
        wait.until(ExpectedConditions.visibilityOf(accountsPage.getHeading()));
        Assert.assertEquals(accountsPage.getHeading().getText(), "Account");
        Assert.assertEquals(accountsPage.getMemberShipUsername(), "rahul", "username element mis-match");
        Assert.assertEquals(accountsPage.getMemberShipPassword(), "**********", "password element mis-match");
        Assert.assertTrue(accountsPage.getPlanContainter().isDisplayed(), "plan-container is not displayed");
    }

    @When("I want to click on logout button it should be redirected to login-page")
    public void testAccountLogout(){
        accountsPage.getLogout();
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/login"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://qamoviesapp.ccbp.tech/login", "Logout-failed");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
