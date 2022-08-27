package pageobjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    @FindBy(how = How.NAME , using = "user")
    public WebElement user;

    @FindBy(how = How.ID , using = "current-password")
    public WebElement password;

    @FindBy(how = How.CSS , using = "button[type=submit]")
    public WebElement loginButton;

    @FindBy(how = How.CSS , using = "button[class=css-1kf0ycc-button]")
    public WebElement skipButton;


}
