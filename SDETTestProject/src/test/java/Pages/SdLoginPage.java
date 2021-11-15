package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SdLoginPage {

    // page elements

    @FindBy(css = "input#user-name")
    public WebElement txt_username;

    @FindBy(css = "input#password")
    public WebElement txt_password;

    @FindBy(css = "input#login-button")
    public WebElement btn_login;

    @FindBy(xpath = "//div[@id='login_button_container']//form//h3")
    public WebElement lbl_error;

    protected WebDriver driver;

    public SdLoginPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    // page actions

    public void clickTxtUsername() {
        txt_username.click();
    }

    public void insertTxtUsername(String username) {
        txt_username.sendKeys(username);
    }

    public void clickTxtPassword() {
        txt_password.click();
    }

    public void insertTxtPassword(String password) {
        txt_password.sendKeys(password);
    }

    public void clickBtnLogin() {
        btn_login.click();
    }

    public void checkLockedOutErrorReturned(String error) {
        lbl_error.getText().equals(error);
    }
}
