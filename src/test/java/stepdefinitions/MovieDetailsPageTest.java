package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.PopularPage;

import java.time.Duration;

public class MovieDetailsPageTest {

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    PopularPage popularPage;
    WebDriverWait wait;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\supri\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginPage = new LoginPage(driver);
        loginPage.getLogin("rahul", "rahul@2021");
        popularPage = new PopularPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("I want to click on any movie on Home Page and get details of movie")
    public void tesUIelementsPresentInMovieDetailsPage(){
        wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageHeading()));
        homePage.clickOnAnyOfMovie(1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.movie-title")));
        Assert.assertEquals(homePage.getMovieTitle(), "Shang-Chi and the Legend of the Ten Rings", "movie title doesn't matched on MovieDetailPage");
        Assert.assertTrue(homePage.getMovieReviewList().size() > 2, "Movie review is not displayed");
        Assert.assertEquals(homePage.getMovieOverView(), "Shang-Chi must confront the past he thought he left behind when he is drawn into the web of the mysterious Ten Rings", "Movie-Overview doesn't matched");
        Assert.assertTrue(homePage.getPlayButtonForMovie().isDisplayed(), "PlayButton is not displayed");
        Assert.assertTrue(homePage.getMovieDetailCategoryList().size() > 3, "Movie details List are not displayed properly");
        Assert.assertTrue(homePage.getSimilarMovieContainer().isDisplayed(), "Similar Movie List is not displayed");
        Assert.assertTrue(homePage.getContactUsSvg().size() > 2, "Footer section are not properly display");
    }

    @Given("I want to click on any movie on Popular Page and get details of movie")
    public void testUielementMovieDetailsInPopularPage(){
        wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageHeading()));
        homePage.clickOnPopularLink();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.search-movies-container li")));
        popularPage.clickOfAnyMovie(4);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.movie-title")));
        Assert.assertEquals(homePage.getMovieTitle(), "The Amazing Spider-Man", "movie title doesn't matched on PopularMovieDetailPage");
        Assert.assertTrue(homePage.getMovieReviewList().size() > 2, "Movie review is not displayed");
        Assert.assertEquals(homePage.getMovieOverView(), "Peter Parker is an outcast high schooler abandoned by his parents as a boy, leaving him to be raised by his Uncle Ben and Aunt May.", "Movie-Overview doesn't matched");
        Assert.assertTrue(homePage.getPlayButtonForMovie().isDisplayed(), "PlayButton is not displayed");
        Assert.assertTrue(homePage.getMovieDetailCategoryList().size() > 3, "Movie details List are not displayed properly");
        Assert.assertTrue(homePage.getSimilarMovieContainer().isDisplayed(), "Similar Movie List is not displayed");
        Assert.assertTrue(homePage.getContactUsSvg().size() > 2, "Footer section are not properly display");
    }


    @After
    public void tearDown(){
        driver.quit();
    }
}
