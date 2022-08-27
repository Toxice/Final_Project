package extentions;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;

public class UIActions extends CommonOps {

    @Step("Click Element")
    public static void Click(WebElement element){ //Click
        Wait.until(ExpectedConditions.elementToBeClickable(element));
        // Wait until the element is clickable , and only then click it
        element.click();
    }

    @Step("Update Element Text")
    public static void updateText(WebElement element, String Text){
        Wait.until(ExpectedConditions.visibilityOf(element));
        // Wait until the element is visible , and only then send keys to it
        element.sendKeys(Text); // SendKeys
    }

    @Step("Update Element Text as Human")
    public static void updateTextAsHuman(WebElement element, String Text) throws InterruptedException {
        Wait.until(ExpectedConditions.visibilityOf(element));
        // Wait until the element is visible , and only then send keys to it
        for (char txt : Text.toCharArray())
        {
            Thread.sleep(500);
            element.sendKeys(txt + "");
        }
    }

    @Step("Submit Element")
    public static void Submit(WebElement element){ //Submit
        Wait.until(ExpectedConditions.elementToBeClickable(element));
        // Wait until the element is clickable , and only then click it
        element.submit();
    }

    @Step("Click DropDown")
    public static void updateDropDown(WebElement element , String Text){
        Wait.until(ExpectedConditions.visibilityOf(element));
        // Wait until the element is visible , and only then send keys to it
        Select dropDown = new Select(element);
        dropDown.selectByVisibleText(Text); //selectByVisibleText
    }

    @Step("Mouse Hover")
    public static void hoverElement(WebElement elementA , WebElement elementB){
        Wait.until(ExpectedConditions.visibilityOf(elementA));
        action.moveToElement(elementA).build().perform(); // Hover the first element
        action.moveToElement(elementB).click().build().perform(); // Click the second element
    }

    @Step("Mouse Hover")
    public static void hoverElement(WebElement elementA){
        Wait.until(ExpectedConditions.visibilityOf(elementA));
        action.moveToElement(elementA).click().build().perform();
    }

    @Step("Mouse Hover")
    public static void insertKey(WebElement element, Keys keys){
        Wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(keys);
    }

    @Step("Drag Element to a new location")
    public static void dragElement(WebElement elementA , WebElement elementB){
        Wait.until(ExpectedConditions.visibilityOf(elementA));
        action.moveToElement(elementA).click().build().perform();
        action.moveToElement(elementB).release().build().perform();
    }
}
