package pageobjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LeftMenuPage {

    @FindBy(how = How.CLASS_NAME , using = "css-5n5dhy")
    public WebElement Nav_Button;

    @FindBy(how = How.XPATH , using = "//a[@href='/admin/users']")
    public WebElement ServerShield_Button;

    @FindBy(how = How.XPATH , using = "//button[@id='react-aria4200550870-1']")
    public WebElement Search_Dashboard;

    @FindBy(how = How.XPATH , using = "//a[@href='/dashboards']")
    public WebElement Dashboards;

    @FindBy(how = How.XPATH , using = "//a[@href='/explore']")
    public WebElement Explore;

    @FindBy(how = How.XPATH , using = "//div/a[@href='/alerting/list']")
    public WebElement Alerting;

    @FindBy(how = How.XPATH , using = "//div/a[@href='/datasources']")
    public WebElement Datasources;

    @FindBy(how = How.XPATH , using = "//div/a[@href='/profile']")
    public WebElement Profile;

    @FindBy(how = How.XPATH , using = "//div/a[@href='#']")
    public WebElement Help;
}
