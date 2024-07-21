package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {
    WebDriver driver;

    @FindBy (className = "avatar-button")
    WebElement accountBtn;
    @FindBy (className = "account-heading")
    WebElement heading;
    @FindBy (css = "p.membership-username")
    WebElement memberShipUsername;
    @FindBy (css = "p.membership-password")
    WebElement memberShipPassword;
    @FindBy (className = "plan-container")
    WebElement planContainter;
    @FindBy (css = "button.logout-button")
    WebElement logOutBtn;

    public AccountsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickOnAccountBtn(){
        accountBtn.click();
    }

    public WebElement getHeading(){
        return heading;
    }

    public String getMemberShipUsername(){
        String Original_String = memberShipUsername.getText();
        String subString = Original_String.substring(12);
        return subString;
    }

    public String getMemberShipPassword(){
        String Original_String = memberShipPassword.getText();
        String subString = Original_String.substring(11);
        return subString;
    }

    public WebElement getPlanContainter(){
        return planContainter;
    }

    public void getLogout(){
        logOutBtn.click();
    }
}
