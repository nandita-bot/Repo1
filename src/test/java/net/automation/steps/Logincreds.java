package net.automation.steps;

import com.typesafe.config.Config;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.automation.pages.LoginPage;
import utilities.ConfigLoader;

public class Logincreds {
    LoginPage loginPage;

    static Config config = ConfigLoader.load();

    @Given("^I hit the Url$")
    public void iHitTheUrl() throws Throwable {
        loginPage.openUrl(config.getString("login_url"));
        loginPage.getDriver().manage().window().maximize();
    }


    @And("^Press Login button$")
    public void pressLoginButton()  {
      System.out.print("credentials are not matching");
    }


    @When("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterAnd(String arg0, String arg1)
    {
        loginPage.creden(arg0,arg1);

    }
}
