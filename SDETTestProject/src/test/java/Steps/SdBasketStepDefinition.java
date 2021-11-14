package Steps;

import Hooks.Hook;
import Pages.SdBasketPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SdBasketStepDefinition {

    private final SdBasketPage basketPage;

    Hook hook;

    public SdBasketStepDefinition(Hook hook) {
        this.hook = hook;
        basketPage = new SdBasketPage(Hook.getDriver());
    }

    @Given("I am at the checkout page")
    public void i_am_at_the_checkout_page() {
        basketPage.lbl_page_header.isDisplayed();
    }

    @When("I click the checkout button")
    public void i_click_the_checkout_button() {
        basketPage.clickBtnCheckout();
    }

    @Then("I should be navigated to the information page")
    public void i_should_be_navigated_to_the_information_page() {
        basketPage.checkHeaderTitleIsInformation();
    }

    @And("I click the First Name text box")
    public void i_click_the_first_name_text_box() {
        basketPage.clickTxtFirstName();
    }

    @And("^I insert the (.*) firstname$")
    public void i_insert_the_test_first_name_firstname(String firstname) {
        basketPage.insertTxtFirstNameValue(firstname);
    }

    @And("I click the Last Name text box")
    public void i_click_the_last_name_text_box() {
        basketPage.clickTxtLastName();
    }

    @And("^I insert the (.*) lastname$")
    public void i_insert_the_test_last_name_lastname(String lastname) {
        basketPage.insertTxtLastNameValue(lastname);
    }

    @And("I click the Zip\\/Postal Code textbox")
    public void i_click_the_zip_postal_code_textbox() {
        basketPage.clickTxtPostalCode();
    }

    @And("^I insert the (.*) zip\\/postal code$")
    public void i_insert_the_test_postal_code_zip_postal_code(String postal_code) {
        basketPage.insertTxtPostalCode(postal_code);
    }

    @When("I click the continue button")
    public void i_click_the_continue_button() {
        basketPage.clickBtnContinue();
    }

    @Then("I should be navigated to the checkout overview page")
    public void i_should_be_navigated_to_the_checkout_overview_page() {
        basketPage.checkHeaderTitleIsOverview();
    }
}
