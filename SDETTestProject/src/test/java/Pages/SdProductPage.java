package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SdProductPage {

    // page elements

    @FindBy(xpath = "//div[@id='header_container']//span[@class='title']")
    public WebElement lbl_title;

    @FindBy(xpath = "/html//button[@id='add-to-cart-sauce-labs-backpack']")
    public WebElement btn_slBackPack_add_to_cart;

    @FindBy(id = "shopping_cart_container")
    public WebElement icn_cart;

    protected WebDriver driver;

    public SdProductPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    // product page actions

    public void addBackPackToCart() {
        btn_slBackPack_add_to_cart.click();
    }

    public void clickIcnCart() {
        icn_cart.click();
    }
}
