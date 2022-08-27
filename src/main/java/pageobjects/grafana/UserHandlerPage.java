package pageobjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserHandlerPage {

    @FindBy(how = How.XPATH , using = "//div/button[@class='css-mk7eo3-button']")
    public WebElement DeleteUser;

    @FindBy(how = How.XPATH , using = "//button[@aria-label='Confirm Modal Danger Button']")
    public WebElement Confirm_Deletion;
}
