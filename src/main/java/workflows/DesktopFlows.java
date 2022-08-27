package workflows;

import extentions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

public class DesktopFlows extends CommonOps {

    @Step("Business Flow: Calculation of Addition")
    public static void calculateAddition(WebElement numberA , WebElement numberB){
        UIActions.Click(calcMain.btn_clear);
        UIActions.Click(numberA);
        UIActions.Click(calcMain.btn_plus);
        UIActions.Click(numberB);
        UIActions.Click(calcMain.btn_equals);
    }

    @Step("Business Flow: Empty Field Result")
    public static void emptyFieldResult(){
        UIActions.Click(calcMain.btn_clear);
    }
}
