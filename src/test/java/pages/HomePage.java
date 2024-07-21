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

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy (className = "home-movie-heading")
    WebElement homePageHeading;
    @FindBy (className = "home-movie-play-button")
    WebElement playButtonEl;
    @FindBy (css = "div.home-bottom-container div h1")
    List<WebElement> bottomHeadingSection;
    @FindBy (css = "div.home-bottom-container>div:nth-child(1) div.react-slick-item")
    List<WebElement> trendingNowMovieList;
    @FindBy (css = "div.home-bottom-container>div:nth-child(2) div.react-slick-item")
    List<WebElement> originalsMovieList;
    @FindBy (css = "div.footer-icons-container svg")
    List<WebElement> contactUsSvg;
    @FindBy (className = "contact-us-paragraph")
    WebElement contactUsTextEl;
    @FindBy (css = "div.home-bottom-container>div:nth-child(1) button.slick-next")
    WebElement trendingNextButtonEl;
    @FindBy (css = "div.home-bottom-container>div:nth-child(2) button.slick-next")
    WebElement originalNextButtonEl;
    @FindBy (className = "website-logo")
    WebElement websiteLogo;
    @FindBy (css = "ul.nav-menu-list li")
    List<WebElement> navList;
    @FindBy (css = "a[href *= \"/\"]")
    WebElement homeNavLink;
    @FindBy (css = "a[href *= \"/popular\"]")
    WebElement popularNavLink;
    @FindBy (css = "div.search-account-container button:last-child")
    WebElement accountLink;
    @FindBy (className = "search-empty-button")
    WebElement searchBtn;
    @FindBy (className = "movie-title")
    WebElement movieTitle;
    @FindBy (css = "div.movie-review-container p")
    List<WebElement> movieReviewList;
    @FindBy (className = "movie-overview")
    WebElement movieOverview;
    @FindBy (className = "play-button")
    WebElement playButtonForMovie;
    @FindBy (css = "div.detailed-movie-categories-container>div")
    List<WebElement> movieDetailCategoryList;
    @FindBy (css = "div.similar-movies-container")
    WebElement similarMovieContainer;

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public WebElement getHomePageHeading(){
        return homePageHeading;
    }

    public List<WebElement> getBottomHeading(){
        return bottomHeadingSection;
    }

    public WebElement getPlayButtonEl(){
        return playButtonEl;
    }

    public List<WebElement> getTrendingNowMovieList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.home-bottom-container>div:nth-child(1) div.react-slick-item img")));
        return trendingNowMovieList;
    }

    public List<WebElement> getOriginalsMovieList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.home-bottom-container>div:nth-child(2) div.react-slick-item img")));
        return originalsMovieList;
    }

    public void getNextButtonClickForTrending(){
        for (int i = 0; i < 6; i++){
            trendingNextButtonEl.click();
        }
    }
    public void getNextButtonClickForOriginal(){
        for (int i = 0; i < 6; i++){
            originalNextButtonEl.click();
        }
    }

    public List<WebElement> getContactUsSvg(){
        return contactUsSvg;
    }

    public String getContactUsText(){
        return contactUsTextEl.getText();
    }

    public WebElement getWebsiteLogo(){
        return websiteLogo;
    }

    public void clickOnHomeLink(){
        homeNavLink.click();
    }

    public void clickOnPopularLink(){
        wait.until(ExpectedConditions.visibilityOf(popularNavLink));
        popularNavLink.click();
    }
    public void clickOnSearchBtn(){
        wait.until(ExpectedConditions.visibilityOf(searchBtn));
        searchBtn.click();
    }
    public void clickOnAccountLink(){
        accountLink.click();
    }

    public List<WebElement> getNavList(){
        return navList;
    }

    public void clickOnAnyOfMovie(int index){
        trendingNowMovieList.get(index).click();
    }

    public String getMovieTitle(){
        return movieTitle.getText();
    }

    public List<WebElement> getMovieReviewList(){
        return movieReviewList;
    }

    public String getMovieOverView(){
        return movieOverview.getText();
    }
    public WebElement getPlayButtonForMovie(){
        return playButtonForMovie;
    }
    public List<WebElement> getMovieDetailCategoryList(){
        return movieDetailCategoryList;
    }
    public WebElement getSimilarMovieContainer(){
        return similarMovieContainer;
    }
}
