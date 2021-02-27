package com.caseStudy2.pages;

import com.caseStudy2.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(xpath="//span[contains(text(),'Getir şifresi ile devam et')]")
    public WebElement getirSifre;

    @FindBy(xpath="(//div/input[@placeholder='Telefon Numarası'])[2]")
    public WebElement mobilePhone;

    @FindBy(xpath="(//div/input[@placeholder='Şifre' and @name='password'])")
    public WebElement password;

    @FindBy(xpath = "(//button[contains(text(), 'Giriş yap')])[2]")
    public WebElement loginButton;

    @FindBy(xpath = "//span[contains(text(),'Hatalı telefon numarası veya şifre.')]")
    public WebElement errorMessage;



    public void login(String userNameStr, String passwordStr) {

        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("window.scrollBy(0,250)");

        getirSifre.click();
        mobilePhone.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        loginButton.click();
    }
}
