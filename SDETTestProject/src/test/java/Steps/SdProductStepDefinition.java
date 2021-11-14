package Steps;

import Hooks.Hook;
import Pages.SdBasketPage;
import Pages.SdProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SdProductStepDefinition {

    private final SdProductPage productPage;
    private final SdBasketPage basketPage;

    Hook hook;

    public SdProductStepDefinition(Hook hook) {
        this.hook = hook;
        productPage = new SdProductPage(Hook.getDriver());
        basketPage = new SdBasketPage(Hook.getDriver());
    }

    @Given("I am on the product page")
    public void i_am_on_the_product_page() {
        productPage.lbl_title.isDisplayed();
    }

    @When("I click the add to cart button for a product")
    public void i_click_the_add_to_cart_button_for_a_product() {
        productPage.addBackPackToCart();
    }

    @And("I click the product basket icon")
    public void i_click_the_product_basket_icon() {
        productPage.clickIcnCart();
    }

    @Then("^I should see the (.*) product I added to the basket$")
    public void i_should_see_the_sauce_labs_backpack_product_i_added_to_the_basket(String basketProduct) {
        basketPage.lbl_product_description_in_basket.getText().equals(basketProduct);
    }
}
