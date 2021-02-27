package com.caseStudy2.step_definitions;

import com.caseStudy2.pages.HomePage;
import com.caseStudy2.pages.LoginPage;
import com.caseStudy2.utilities.ConfigurationReader;
import com.caseStudy2.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class LoginStepDefs {


    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("the user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String mobilePhone, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(mobilePhone, password);
    }


    @Then("the the user should be able to see {string} button")
    public void the_the_user_should_be_able_to_see_button(String logoutButton) throws InterruptedException {
        HomePage homePage = new HomePage();

        try {
            homePage.menuOptions.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex) {
            homePage.menuOptions.click();
        }

        assertTrue(homePage.logout.isDisplayed());

        // also assert the homepage title
        String expectedTitle = "Restoranlar | GetirYemek";
        assertEquals(expectedTitle, Driver.get().getTitle());

        // At the end of process logout from app
        homePage.logout.click();
    }


    @Then("the user should see {string} message")
    public void the_user_should_see_message(String actualErrorMessage) {

        LoginPage loginPage = new LoginPage();
        actualErrorMessage = loginPage.errorMessage.getText();

        String expectedErrorMessage = "Hatalı telefon numarası veya şifre.";

        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

}
