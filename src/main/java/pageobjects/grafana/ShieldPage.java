package pageobjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ShieldPage {

    @FindBy(how = How.XPATH , using = "//a[@href='/admin/users']")
    public WebElement Users;

    @FindBy(how = How.XPATH , using = "//a[@href='/admin/orgs']")
    public WebElement Orgs;

    @FindBy(how = How.XPATH , using = "//a[@href='/admin/settings']")
    public WebElement Settings;

    @FindBy(how = How.XPATH , using = "//a[@href='/admin/plugins']")
    public WebElement Plugins;

    @FindBy(how = How.XPATH , using = "//a[@href='/admin/licensing']")
    public WebElement Licensing;


}
