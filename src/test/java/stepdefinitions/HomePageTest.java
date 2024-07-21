package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import java.util.List;


public class HomePageTest {
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


    @Given("I Want to verify Homepage Heading and Bottom heading also")
    public void testHomePageHeadingAndBottomHeading(){
        Assert.assertTrue(homePage.getHomePageHeading().isDisplayed(), "HomePage Main heading is not displayed");
        List<WebElement> headingel = homePage.getBottomHeading();
        String[] exHeading = {"Trending Now", "Originals"};
        for (int i = 0; i < 2; i++){
            Assert.assertEquals(headingel.get(i).getText(), exHeading[i], "HomePage Bottom heading is not matched");
        }
    }

    @When("I want to test Play-Button")
    public void testPlayButton(){
        Assert.assertTrue(homePage.getPlayButtonEl().isDisplayed(), "Play-Button is not displayed");
    }

    @And("I want to also check Trending-Now movies Section")
    public void testTrendingNowSection(){
        List<WebElement> trendingMovieEl = homePage.getTrendingNowMovieList();
        Assert.assertTrue(trendingMovieEl.size() > 0, "Trending Movies is not Displayed properly");
    }

    @But("I want to to check Originals movies Section")
    public void testOriginalsMoviesSection(){
        List<WebElement> originalsMovieMovieEl = homePage.getOriginalsMovieList();
        Assert.assertTrue(originalsMovieMovieEl.size() > 0, "Originals Movies is not Displayed properly");
    }

    @Then("I want to check ContactUs Section")
    public void testContactUsSection(){
        List<WebElement> contactUsEl = homePage.getContactUsSvg();
        for (int i = 0; i < 4; i++){
            Assert.assertTrue(contactUsEl.get(i).isDisplayed(), "Media-link is not Displayed on Contact-Us Section");
        }

        String contactUsText = homePage.getContactUsText();
        Assert.assertEquals(contactUsText, "Contact Us", "Contact Us Text does not matched");
    }


    @After
    public void tearDown(){
        driver.quit();
    }
}
