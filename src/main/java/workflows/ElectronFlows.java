package workflows;

import extentions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

public class ElectronFlows extends CommonOps {

    @Step("Business Flow: add new task")
    public static void addTask(String taskName){
        Wait.until(ExpectedConditions.visibilityOf(todoMain.createTask));
        UIActions.updateText(todoMain.createTask , taskName);
        UIActions.insertKey(todoMain.createTask , Keys.ENTER);
    }

    @Step("Business Flow: add new task with color")
    public static void addTask(String taskName , String colorNumber){
        Wait.until(ExpectedConditions.visibilityOf(todoMain.createTask));
        UIActions.updateText(todoMain.createTask , taskName);

        Wait.until(ExpectedConditions.elementToBeClickable(todoMain.colorButton));
        todoMain.colorButton.click();
        /*
        color code - mentioned in TestConfig.xml
        1 - red
        2 - orange
        3 - yellow
        4 - green
        5 - blue
        6 - purple
        7 - grey
         */

        todoMain.color.get(Integer.parseInt(colorNumber)).click(); // click on the wished color pattern
        todoMain.createTask.click();
        UIActions.insertKey(todoMain.createTask , Keys.ENTER);
    }

    @Step("Business Flow: get number of Tasks")
    public static int getNumberOfTasks(){
        return todoMain.Tasks_By_Location.size();
    }

    @Step("Delete current task")
    public static void deleteTask(WebElement Task){
        Wait.until(ExpectedConditions.elementToBeClickable(Task));
        Task.click();
    }

//    @Step("Business Flow: Pick a color")
//    public static void pickColorByNumber(List<WebElement> color, int colorNumber){
//        Wait.until(ExpectedConditions.elementToBeClickable(todoMain.colorButton));
//        todoMain.colorButton.click();
//        /*
//        1 - red
//        2 - orange
//        3 - yellow
//        4 - green
//        5 - blue
//        6 - purple
//        7 - grey
//         */
//
//        color.get(colorNumber).click(); // click on the wished color pattern
//    }
}
