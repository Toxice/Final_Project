package pageobjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {

    @FindBy(how = How.CLASS_NAME , using = "css-1aanzv4")
    public WebElement MainHeader;

    @FindBy(how = How.CLASS_NAME , using = "css-152opwo")
    public List<WebElement> progressSteps;

}
