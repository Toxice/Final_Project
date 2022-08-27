package pageobjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class UsersManagePage {

    @FindBy(how = How.CSS , using = "td[class='width-4 text-center link-td']")
    public List<WebElement> Users_Rows;

    @FindBy(how = How.CLASS_NAME , using = "css-1sara2j-button")
    public WebElement create_button;

    // Verification Elements

    @FindBy(how = How.XPATH , using = "//a[text()='admin1']")
    public WebElement userName;

    @FindBy(how = How.XPATH , using = "//a[text()='example1@gmail.com']")
    public WebElement userMail;

    @FindBy(how = How.XPATH , using = "//a[text()='example1']")
    public WebElement userUser;

    @FindBy(how = How.CSS , using = "input[class='css-yn255a-input-input']")
    public WebElement SearchBox;

}
