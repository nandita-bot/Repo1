package net.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.InputEvent;

public class DragDropPage extends PageObject {


    @FindBy(xpath = "//div[@id=\"todrag\"]//span[1]")
    WebElementFacade drag;
    @FindBy(xpath = "//div[@id=\"todrag\"]//span[2]")
    WebElementFacade drag1;

    public void DragDropItem() throws AWTException {
        Actions act = new Actions(getDriver());
        Point dragLoc = drag.getLocation();
        Robot robot = new Robot();
        robot.mouseMove(dragLoc.getX() + 50, dragLoc.getY() + 150);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        waitABit(1000);
        robot.mouseMove(590, 560);
        waitABit(2000);
        act.click().perform();
        try {
            robot.keyPress(InputEvent.BUTTON1_DOWN_MASK);
            robot.keyRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.keyPress(InputEvent.BUTTON2_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        } catch (Exception e) {
            waitABit(3000);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
        waitABit(5000);


        }

    }
