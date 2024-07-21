package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy (id = "search")
    WebElement searchInputEl;
    @FindBy (css = "ul.search-movies-container li")
    List<WebElement> moviesEl;
    @FindBy (className = "search-button")
    WebElement searchButton;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public List<WebElement> searchMovie(String name){
        searchInputEl.sendKeys(name);
        searchButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.search-movies-container li")));
        return moviesEl;
    }

    public void clearInput(){
        searchInputEl.clear();
    }
}
