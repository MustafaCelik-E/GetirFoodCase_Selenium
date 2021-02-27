package com.caseStudy2.pages;


import com.caseStudy2.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    public HomePage() {
        PageFactory.initElements(Driver.get(), this);
    }

}
