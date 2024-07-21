package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import java.util.List;

public class HeaderSectionTest {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\supri\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginPage.getLogin("rahul", "rahul@2021");
    }

    @Given("I want to test Website-Logo")
    public void testHomePageWebsiteLogo(){
        Assert.assertTrue(homePage.getWebsiteLogo().isDisplayed(), "Navbar logo is not Displayed");
    }

    @And("I want to verify Nav-List")
    public void testNavList(){
        List<WebElement> navlist = homePage.getNavList();
        String[] expNavlist = {"Home", "Popular"};
        for (int i = 0; i < navlist.size(); i++){
            Assert.assertEquals(navlist.get(i).getText(), expNavlist[i], "NavItem Mismatched");
        }
    }

    @Given("I want to click popular section and check")
    public void testNavigateToPopularPage(){
        homePage.clickOnPopularLink();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qamoviesapp.ccbp.tech/popular", "URL doesn't matched");
    }

    @When("I want to click home section and check")
    public void testNavigateToHomePage(){
        homePage.clickOnHomeLink();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qamoviesapp.ccbp.tech/", "URL doesn't matched");
    }

//    @Then("I want to check account section and check")
//    public void testNavigateToAccountPage(){
//        homePage.clickOnAccountLink();
//        Assert.assertEquals(driver.getCurrentUrl(), "https://qamoviesapp.ccbp.tech/account", "URL doesn't matched");
//    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
