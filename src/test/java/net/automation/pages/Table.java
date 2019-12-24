package net.automation.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;

public class Table extends PageObject {
    @FindBy(xpath = "//div[text()='Showing 31 to 32 of 32 entries']")
    WebElementFacade Enteries;

    public void verify() {

        int count = 0;
        for (int i = 1; i <= 10; i++) {
            if (getDriver().findElement(By.xpath("//a[text()='Next']")).isEnabled()) {
                List<WebElement> list = getDriver().findElements(By.xpath("//tbody//tr[@role='row']"));
                System.out.println(list.size());
                count = count + list.size();
                for (int j = 1; j <= list.size(); j++) {
                    Iterator itr = list.iterator();
                    if (itr.hasNext()) {
                        getDriver().findElement(By.xpath("//a[text()='Next']")).click();
                        break;
                    }
                }
                if (count > 31)
                    break;
                continue;
            }
        }
        String str = Enteries.getText().replaceAll("Showing 31 to 32 of 32 entries", "32");
        int numbers = Integer.valueOf(str);
        System.out.println(numbers);
        Assert.assertEquals(32, numbers);
    }

}
