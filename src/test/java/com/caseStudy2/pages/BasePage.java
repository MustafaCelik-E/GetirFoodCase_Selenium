package com.caseStudy2.pages;

import com.caseStudy2.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "(//*[@data-testid='icon' and @name='hamburger'])[1]")
    public WebElement menuOptions;

    @FindBy(xpath = "//a[contains(text(),'Adreslerim')]")
    public WebElement addresses;

    @FindBy(xpath = "//a[contains(text(),'Çıkış yap')]")
    public WebElement logout;

    @FindBy(xpath = "//div/input[@placeholder='Yemek veya restoran ara']")
    public WebElement searchbox;



    public void navigateToModule(String module) {
        String moduleLocator = "//a[contains(text(),'"+ module +"')]";

        Driver.get().findElement(By.xpath(moduleLocator)).click();
    }


}
