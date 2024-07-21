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

public class PopularPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = "div.search-movies-container li")
    List<WebElement> popularPageMoviesList;

    public PopularPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public List<WebElement> getPopularPageMoviesList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.search-movies-container li")));
        return popularPageMoviesList;
    }

    public void clickOfAnyMovie(int index){
        popularPageMoviesList.get(index).click();
    }
}
