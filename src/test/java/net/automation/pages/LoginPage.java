package net.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

import java.util.concurrent.TimeUnit;

public class LoginPage extends PageObject {
     Google google;
    @FindBy(xpath="//input[@placeholder=\"Username\"]")
    WebElementFacade username;
    @FindBy(xpath="//input[@placeholder=\"Password\"]")
    WebElementFacade password;
    @FindBy(xpath ="//button[@id=\"btnLogin\"]")
    WebElementFacade login;
    @FindBy(xpath="//div[@id=\"invalidCredentials\"]//div//span[2]")
    WebElementFacade Incorrect;

    public String creden(String arg0, String arg1)
    {
        username.sendKeys(arg0);
        password.sendKeys(arg1);
        login.withTimeoutOf(10, TimeUnit.SECONDS).click();
        return Incorrect.getText();

    }
    public void  seturl() {
        google.goToHomePage();
    }
}

