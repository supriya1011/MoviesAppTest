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
import pages.PopularPage;
import java.util.List;

public class PopularPageTest {
    WebDriver driver;
    LoginPage loginPage;
    PopularPage popularPage;
    HomePage homePage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\supri\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        popularPage = new PopularPage(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginPage.getLogin("rahul", "rahul@2021");
    }
    @Given("I want to check verify movies are display on popular page")
    public void testPopularPage(){
        homePage.clickOnPopularLink();
        List<WebElement> movies = popularPage.getPopularPageMoviesList();
        Assert.assertTrue(movies.size() > 0, "no movies are there");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
