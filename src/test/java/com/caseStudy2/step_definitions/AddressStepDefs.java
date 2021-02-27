package com.caseStudy2.step_definitions;

import com.caseStudy2.pages.AddressPage;
import com.caseStudy2.pages.HomePage;
import com.caseStudy2.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.Map;

import static org.junit.Assert.*;

public class AddressStepDefs {

    @Given("the user navigates to {string}")
    public void the_user_navigates_to (String module) {
        HomePage homePage = new HomePage();

        try {
            homePage.menuOptions.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex) {
            homePage.menuOptions.click();
        }

        homePage.navigateToModule(module);
    }

    @When("the user clicks the {string}")
    public void the_user_clicks_the(String addressType) {

        AddressPage addressPage = new AddressPage();

        if (addressType.equals(addressPage.addHomeAddressButton.getText())){
            addressPage.addHomeAddressButton.click();
        } else if (addressType.equals(addressPage.addOfficeAddressButton.getText())){
            addressPage.addOfficeAddressButton.click();
        }else if(addressType.equals(addressPage.addAnotherAddressButton.getText())){
            addressPage.addAnotherAddressButton.click();
        }
    }

    @When("the user writes {string} to search box and clicks first option")
    public void the_user_writes_to_search_box_and_clicks_first_option(String town) throws InterruptedException {
        AddressPage addressPage = new AddressPage();
        addressPage.addressSearchBox.sendKeys(town);
        addressPage.firstAddressResults.click();

        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        for (int i = 0; i < 2; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,250)");
        }
        Thread.sleep(2000);

        addressPage.useAddressButton.click();
    }

    @When("the user logs in using following credentials")
    public void the_user_logs_in_using_following_credentials(Map<String, String> addressInfo) throws InterruptedException {
        System.out.println(addressInfo);
        //  {addressTitle=office, address=Tanburi Ali Efendi Sok., building=Maya Residences,
        //  floor=16, aptNo=330, direction=Merkez}

        AddressPage addressPage = new AddressPage();

        addressPage.addressTitleBox.sendKeys(Keys.CONTROL + "a");
        addressPage.addressTitleBox.sendKeys(Keys.DELETE);
        addressPage.addressTitleBox.sendKeys(addressInfo.get("addressTitle"));
        addressPage.addressBox.sendKeys(addressInfo.get("address"));
        addressPage.buildingBox.sendKeys(addressInfo.get("building"));
        addressPage.floorBox.sendKeys(addressInfo.get("floor"));
        addressPage.aptNoBox.sendKeys(addressInfo.get("aptNo"));
        addressPage.directionBox.sendKeys(addressInfo.get("direction"));

        addressPage.saveButton.click();
        addressPage.yesButton.click();

    }

    @Then("the user should be able to see the address under {string}")
    public void the_user_should_be_able_to_see_the_address_under(String string) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("window.scrollBy(0,-250)");

        AddressPage addressPage = new AddressPage();
    }


}
