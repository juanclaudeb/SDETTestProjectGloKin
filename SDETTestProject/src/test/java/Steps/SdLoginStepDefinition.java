package Steps;

import Hooks.Hook;
import Pages.SdLoginPage;
import Pages.SdProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SdLoginStepDefinition {

    private final SdLoginPage loginPage;
    private final SdProductPage productPage;

    Hook hook;

    public SdLoginStepDefinition(Hook hook) {
        this.hook = hook;
        loginPage = new SdLoginPage(Hook.getDriver());
        productPage = new SdProductPage(Hook.getDriver());
    }

    @Given("I am at the login page")
    public void i_am_at_the_login_page() {
        hook.getDriver().getCurrentUrl().equals("https://www.saucedemo.com/");
    }

    @And("I click the username textbox")
    public void i_click_the_username_textbox() {
        loginPage.clickTxtUsername();
    }

    @Then("^I insert the (.*) username$")
    public void i_insert_the_username(String username) {
        loginPage.insertTxtUsername(username);
    }

    @Then("I click the password textbox")
    public void i_click_the_password_textbox() {
        loginPage.clickTxtPassword();
    }

    @And("^I insert the (.*) password$")
    public void i_insert_the_password(String password) {
        loginPage.insertTxtPassword(password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickBtnLogin();
    }

    @Then("I should be navigated to the products page")
    public void i_should_be_navigated_to_the_products_page() {
        productPage.lbl_title.isDisplayed();
    }

    @Then("^I should see the following error returned (.*)$")
    public void i_should_receive_an_error_that_the_user_has_been_locked_out(String error) {
        loginPage.checkLockedOutErrorReturned(error);
    }
}
