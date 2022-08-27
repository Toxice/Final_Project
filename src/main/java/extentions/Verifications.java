package extentions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;

import java.util.List;

import static org.testng.Assert.*;

public class Verifications extends CommonOps {

    @Step("Verify Text")
    public static void verifyTextInElement(WebElement element, String expected){
        Wait.until(ExpectedConditions.visibilityOf(element));
        assertEquals(element.getText() , expected);
    }

    @Step("Verify Number of Elements")
    public static void verifyNumberOfElements(List<WebElement> rows , int expected){

        Wait.until(ExpectedConditions.visibilityOf(rows.get(rows.size() - 1))); // Wait until the last element in the list is visible
            assertEquals(rows.size() , expected);
    }

    @Step("Verify Visibility of Elements")
    public static void visibilityOfElements(List<WebElement> Elements){
        for (WebElement elem : Elements)
        {
            softAssert.assertTrue(elem.isDisplayed()); // Check if the element is displayed on the site
        }
        softAssert.assertAll();
    }

    @Step("Verify Element Visually")
    // Using Sikuli API
    public static void visualElement(String ExpectedImageName){
        try {
            screen.find("C:\\Users\\toxic\\IdeaProjects\\New_Try\\ImageRepository\\" + ExpectedImageName + ".png"); // compare given image to the actual one
        } catch (FindFailed e) {
            System.out.println("error comparing image file " + e);
            fail("error comparing image file " + e);
        }
    }

    @Step("Verify the existence of element")
    public static void existenceOfElement(List<WebElement> userNames){
        assertTrue(userNames.size() > 0);
    }

    @Step("Verify the in - existence of element")
    public static void nonExistenceOfElement(List<WebElement> userNames){
        assertFalse(userNames.size() < 0);
    }

    @Step("Verify actual text is correct")
    public static void verifyText(String actual, String expected){
        assertEquals(actual, expected);
    }

    @Step("Verify actual number is correct")
    public static void verifyNumber(int actual , int expected){
        assertEquals(actual , expected);
    }
}
