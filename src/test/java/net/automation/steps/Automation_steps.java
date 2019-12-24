package net.automation.steps;

import com.typesafe.config.Config;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.automation.pages.NewPage;
import utilities.ConfigLoader;

public class Automation_steps {

    NewPage newpage;

    static Config config = ConfigLoader.load();

    @Given("^I am on the Registration Page$")
    public void iAmOnTheRegistrationPage()
    {
        newpage.openUrl(config.getString("webdriver.base.url"));
        newpage.getDriver().manage().window().maximize();


    }

    @And("^Fill all the details$")
    public void fillAllTheDetails(DataTable dataTable) throws InterruptedException {
        newpage.datafield(dataTable);
        newpage.gender(dataTable);
        newpage.year( dataTable);
        newpage.prof(dataTable);
        newpage.auto(dataTable);
        newpage.Cont(dataTable);
        newpage.contMul(dataTable);
        newpage.selCont(dataTable);
    }

    @Then("^Click on the submit button$")
    public void clickOnTheSubmitButton()  {
     newpage.btns();
    }
}

