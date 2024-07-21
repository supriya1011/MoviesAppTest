package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;

import java.util.List;

public class SearchPageTest {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    SearchPage searchPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\supri\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginPage.getLogin("rahul", "rahul@2021");
    }

    @Given("I want to search movie and check result")
    public void testSearchMovies(){
        homePage.clickOnSearchBtn();
        List<WebElement> movieList = searchPage.searchMovie("Spider-Man");
        Assert.assertTrue(movieList.size() == 3, "search-failed");
//        searchPage.clearInput();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
