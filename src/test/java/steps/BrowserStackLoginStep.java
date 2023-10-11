package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.BrowserStackLoginPage;

import java.io.IOException;

public class BrowserStackLoginStep {
    BrowserStackLoginPage browserStackLoginPage = new BrowserStackLoginPage();

    @Given("I am on BrowserStackDemo home page")
    public void iAmOnBrowserStackDemoHomePage() throws IOException, InterruptedException {
        browserStackLoginPage.iAmOnBrowserStackHomePage();
    }

    @When("I click {string} button on home page")
    public void iClickSignInButtonOnHomePage(String buttonName) throws InterruptedException {
        browserStackLoginPage.iClickOnSignInButton();
    }

    @And("I select Username on login page")
    public void iSelectUsernameOnLoginPage() throws IOException {
        browserStackLoginPage.iSelectUsername();
    }

    @And("I select Password on login page")
    public void iSelectPasswordOnLoginPage() throws IOException {
        browserStackLoginPage.iSelectPassword();
    }

    @And("I click Login button on login page")
    public void iClickLoginButtonOnLoginPage() throws InterruptedException {
        browserStackLoginPage.iClickOnLoginButton();
    }

    @Then("I verify that user is able to Login into the application with valid credential")
    public void iVerifyThatUserIsAbleToLoginIntoTheApplicationWithValidCredential() throws IOException {
        browserStackLoginPage.iVerifySuccessfullyLoggedInWithUsername();
    }

    @And("I select invalid Username on login page")
    public void iSelectInvalidUsernameOnLoginPage() throws IOException {
        browserStackLoginPage.iSelectInvalidUsername();
    }

    @And("I select invalid Password on login page")
    public void iSelectInvalidPasswordOnLoginPage() throws IOException {
        browserStackLoginPage.iSelectInvalidPassword();
    }

    @Then("I verify that error message {string} is displayed")
    public void iVerifyThatErrorMessageIsDisplayed(String expectedErrorMessage) {
        Assert.assertEquals(expectedErrorMessage, browserStackLoginPage.getActualErrorMessage());
    }
}
