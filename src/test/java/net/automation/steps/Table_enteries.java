package net.automation.steps;

import com.typesafe.config.Config;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.automation.pages.Table;
import utilities.ConfigLoader;


public class Table_enteries

{
    Table table;
    static Config config = ConfigLoader.load();
    @Given("^I am on the Table Enteries Page$")
    public void iAmOnTheTableEnteriesPage()  {
        table.openUrl(config.getString("Table_enteries"));
        table.getDriver().manage().window().maximize();

    }



    @Then("^Verify that we have equal number of enteries showing in the table$")
    public void verifyThatWeHaveEqualNumberOfEnteriesShowingInTheTable()
    {
        table.verify();
    }
}
