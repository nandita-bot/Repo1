package net.automation.pages;

import cucumber.api.DataTable;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
//import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import  org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class NewPage extends PageObject {
    Google google;
    @FindBy(xpath ="//input[@name=\"firstname\"]")
    WebElementFacade firstname;

    @FindBy(xpath ="//input[@id=\"lastname\"]")
     WebElementFacade lastname;
    @FindBy (xpath ="//input[@id=\"datepicker\"]")
    WebElementFacade date;

    @FindBy(xpath = "//select[@id='selenium_commands']")
WebElementFacade selenium;
    @FindBy(xpath ="//select[@id=\"continents\"]")
    WebElementFacade continent;
    @FindBy(xpath ="//select[@id=\"continentsmultiple\"]")
    WebElementFacade conmul;
    @FindBy(xpath="//button[@id='submit']")
    WebElementFacade btn;

    public void datafield (DataTable dataTable){
        List<Map<String,String>> data= dataTable.asMaps(String.class,String.class);
        System.out.print(data);
        String str =data.get(0).get("First Name");
        waitABit(5000);
        firstname.waitUntilVisible();
        firstname.sendKeys(str);
        String str1 =data.get(0).get("Last Name");
        lastname.sendKeys(str1);
        String str2=data.get(0).get("Date");
        date.sendKeys(str2);
    }

    public void gender (DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        System.out.print(data);
        String str4 = data.get(0).get("Sex");
        getDriver().findElement(By.xpath("//input[@name='sex' and @value='"+str4+"']")).click();
    }

        public void year (DataTable dataTable){
            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
            System.out.print(data);
            String str5 =data.get(0).get("Years of experience");
            getDriver().findElement(By.xpath("//input[@name='exp' and @value='"+str5+"']")).click();

    }
    public void prof (DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        System.out.print(data);
        String str6=data.get(0).get("Profession");
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//input[@name='profession' and @value='"+str6+"']")).click();
    }
    public void auto (DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        System.out.print(data);
        String str7=data.get(0).get("Tool");
     //   ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, 900)");
         Thread.sleep(4000);
withAction().click(getDriver().findElement(By.xpath("//input[@name='tool' and @value='"+str7+"']"))).perform();
    }

    public void Cont (DataTable dataTable){
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        String str8=data.get(0).get("Continents");
        Select s1=new Select(continent);
        s1.selectByVisibleText(str8);
         waitABit(5000);
         continent.waitUntilVisible();

    }
    public void contMul (DataTable dataTable){
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        System.out.print(data);
        conmul.waitUntilVisible();
        String str9=data.get(0).get("Continents-MultiSelect");
        Select s2=new Select(conmul);
        s2.selectByVisibleText(str9);
       // selenium.sendKeys(Keys.CONTROL,selenium.click());
        waitABit(5000);

    }
    public void selCont (DataTable dataTable){
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        String str10=data.get(0).get("Selenium commands");
        Select s3=new Select(selenium);
        s3.selectByVisibleText(str10);
        waitABit(5000);
        selenium.waitUntilVisible();

    }
    public void btns(){
        withAction().click(btn).perform();
        btn.waitUntilVisible();
    }
    public void seturl(){
        google.goToHomePage();
    }

}
