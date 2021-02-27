package com.caseStudy2.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

public class AddressPage extends BasePage{

    @FindBy(xpath = "//span[contains(text(),'Ev adresi ekle')]")
    public WebElement addHomeAddressButton;

    @FindBy(xpath = "//span[contains(text(),'İş Adresi Ekle')]")
    public WebElement addOfficeAddressButton;

    @FindBy(xpath = "//span[contains(text(),'Diğer Adres Ekle')]")
    public WebElement addAnotherAddressButton;

    @FindBy(xpath = "//input[@placeholder='Örn. Etiler mh.']")
    public WebElement addressSearchBox;

    @FindBy(xpath = "(//div[@class='style__PartialText-asyidq-2 kdLcpU'])[1]")
    public WebElement firstAddressResults;

    @FindBy(xpath = "//button[contains(text(),'Bu adresi kullan')]")
    public WebElement useAddressButton;

    @FindBy(xpath = "//div/input[@placeholder='Başlık(Ev, işyeri)']")
    public WebElement addressTitleBox;

    @FindBy(xpath = "//div/input[@placeholder='Adres']")
    public WebElement addressBox;

    @FindBy(xpath = "//div/input[@placeholder='Bina']")
    public WebElement buildingBox;

    @FindBy(xpath = "//div/input[@placeholder='Kat']")
    public WebElement floorBox;

    @FindBy(xpath = "//div/input[@placeholder='Daire']")
    public WebElement aptNoBox;

    @FindBy(xpath = "//div/input[@placeholder='Adres Tarifi']")
    public WebElement directionBox;

    @FindBy(xpath = "//button[contains(text(), 'Kaydet')]")
    public WebElement saveButton;

    @FindBy(xpath = "//button[contains(text(), 'Evet')]")
    public WebElement yesButton;

    @FindBy(xpath = "//span[@class='style__Text-sc-1nwjacj-0 dpookf style__Text-o6db8r-1 style__AddressText-o6db8r-9 jyytZk']")
    public List<WebElement> savedAddressTitles;


}
