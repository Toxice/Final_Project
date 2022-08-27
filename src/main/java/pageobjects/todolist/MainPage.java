package pageobjects.todolist;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Arrays;
import java.util.List;

public class MainPage {

    @FindBy(how = How.CLASS_NAME , using = "input_b5pqF")
    public WebElement createTask;

    @FindBy(how = How.CSS , using = "label[class='label_5i8SP']") // the tasks are defined bt their name in the DOM
    public List<WebElement> Tasks_By_Name;

    @FindBy(how = How.CSS , using = "div[class='taskWrapper_2u8dN']")
    public List<WebElement> Tasks_By_Location;

    @FindBy(how = How.CSS , using = "svg[class='destroy_19w1q']")
    public WebElement deleteTaskButton;

    @FindBy(how = How.CSS , using = "svg[class='downArrowIcon_3Zu5N']")
    public WebElement colorButton;

    @FindBy(how = How.CSS , using = "span[class='tag_21fhY']")
    public List<WebElement> color = Arrays.asList(new WebElement[7]);
}
