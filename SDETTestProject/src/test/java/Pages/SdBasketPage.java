package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SdBasketPage {

    // page elements

    @FindBy(xpath = "//div[@id='header_container']//span[@class='title']")
    public WebElement lbl_page_header;

    @FindBy(xpath = "//a[@id='item_4_title_link']/div[@class='inventory_item_name']")
    public WebElement lbl_product_description_in_basket;

    @FindBy(xpath = "/html//button[@id='checkout']")
    public WebElement btn_checkout;

    @FindBy(xpath = "/html//input[@id='first-name']")
    public WebElement txt_firstname;

    @FindBy(xpath = "/html//input[@id='last-name']")
    public WebElement txt_lastname;

    @FindBy(xpath = "/html//input[@id='postal-code']")
    public WebElement txt_postalcode;

    @FindBy(xpath = "/html//input[@id='continue']")
    public WebElement btn_continue;

    protected WebDriver driver;

    public SdBasketPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    // page actions

    public void clickBtnCheckout() {
        btn_checkout.click();
    }

    public void clickTxtFirstName() {
        txt_firstname.click();
    }

    public void insertTxtFirstNameValue(String firstname) {
        txt_firstname.sendKeys(firstname);
    }

    public void clickTxtLastName() {
        txt_lastname.click();
    }

    public void insertTxtLastNameValue(String lastname) {
        txt_lastname.sendKeys(lastname);
    }

    public void clickTxtPostalCode() {
        txt_postalcode.click();
    }

    public void insertTxtPostalCode(String postal_code) {
        txt_postalcode.sendKeys(postal_code);
    }

    public void clickBtnContinue() {
        btn_continue.click();
    }

    public void checkHeaderTitleIsInformation() {
        lbl_page_header.getText().equals("CHECKOUT: YOUR INFORMATION");
    }

    public void checkHeaderTitleIsOverview() {
        lbl_page_header.getText().equals("CHECKOUT: OVERVIEW");
    }
}
