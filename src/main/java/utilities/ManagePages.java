package utilities;

import org.openqa.selenium.support.PageFactory;
import pageobjects.grafana.ShieldPage;

public class ManagePages extends Base{

    public static void initGrafana(){
        grafanaLogin = PageFactory.initElements(driver , pageobjects.grafana.LoginPage.class);
        // initializing the login page

        grafanaMain = PageFactory.initElements(driver , pageobjects.grafana.MainPage.class);

        grafanaSideMenu = PageFactory.initElements(driver , pageobjects.grafana.LeftMenuPage.class);

        grafanaServer = PageFactory.initElements(driver , ShieldPage.class);

        grafanaAdminPage = PageFactory.initElements(driver , pageobjects.grafana.UsersManagePage.class);

        grafanaUserPage = PageFactory.initElements(driver , pageobjects.grafana.CreateUserPage.class);

        grafanaUserHandler = PageFactory.initElements(driver , pageobjects.grafana.UserHandlerPage.class);

        grafanaLeftMenuPage = PageFactory.initElements(driver , pageobjects.grafana.LeftMenuPage.class);
    }

    public static void initMortgage(){
        mortgageMain = new pageobjects.mortgage.MainPage(MobileDriver);
    }

    public static void initTodoList(){
        todoMain = PageFactory.initElements(driver , pageobjects.todolist.MainPage.class);
    }

    public static void initCalculator(){
       // calcMain = PageFactory.initElements(driver , pageobjects.calculator.MainPage.class);
       // calcMain = PageFactory.initElements(windowsDriver , pageobjects.calculator.MainPage.class);
       // calcMain = new pageobjects.calculator.MainPage(windowsDriver);

        calcMain = PageFactory.initElements(driver, pageobjects.calculator.MainPage.class);
    }
}
