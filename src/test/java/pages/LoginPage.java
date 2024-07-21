package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy (className = "login-website-logo")
    WebElement websiteLogo;
    @FindBy (className = "sign-in-heading")
    WebElement headingText;
    @FindBy (css = "form.login-form div:first-of-type >label")
    WebElement userNameLabel;
    @FindBy (css = "form.login-form div:last-of-type >label")
    WebElement passwordLabel;
    @FindBy (className = "login-button")
    WebElement loginButton;
    @FindBy (css = "form.login-form div:first-of-type >input")
    WebElement userNameInputEl;
    @FindBy (css = "form.login-form div:last-of-type >input")
    WebElement passwordInputEl;
    @FindBy (className = "error-message")
    WebElement errorMsgEl;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement getWebsiteLogo(){
        return websiteLogo;
    }

    public String getHeadingText(){
        return headingText.getText();
    }

    public String getUsernameLabelText(){
        return userNameLabel.getText();
    }

    public String getpasswordLabelText(){
        return passwordLabel.getText();
    }

    public WebElement getLoginButton(){
        return loginButton;
    }

    public String getErrorMsg(){
        return errorMsgEl.getText();
    }

    public void getUserNameInput(String username){
        userNameInputEl.sendKeys(username);
        loginButton.click();
    }
    public void getPasswordInput(String password){
        passwordInputEl.sendKeys(password);
        loginButton.click();
    }
    public void getLogin(String username, String password){
        userNameInputEl.sendKeys(username);
        passwordInputEl.sendKeys(password);
        loginButton.click();
    }
//    public String getCurrentUrl(){
//        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
//        wait.until(ExpectedConditions.urlToBe(expectedUrl));
//        return expectedUrl;
//    }
}
