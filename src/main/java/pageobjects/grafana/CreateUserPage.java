package pageobjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateUserPage {

    @FindBy(how = How.XPATH , using = "//input[@name='name']")
    public WebElement name;

    @FindBy(how = How.XPATH , using = "//input[@name='email']")
    public WebElement email;

    @FindBy(how = How.XPATH , using = "//input[@name='login']")
    public WebElement username;

    @FindBy(how = How.XPATH , using = "//input[@name='password']")
    public WebElement password;

    @FindBy(how = How.XPATH , using = "//button[@class='css-1sara2j-button']")
    public WebElement createButton;
}
