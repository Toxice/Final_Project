package sanity;

import extentions.UIActions;
import extentions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class GrafanaWeb extends CommonOps {

    @Test(description = "Test1 - Verify Header")
    @Description("Test Verifies Login and Header")
    public void test01_verify_main_header() {
        WebFlows.login("admin", "admin");
        Verifications.verifyTextInElement(grafanaMain.MainHeader, "Welcome to Grafana");
    }

    @Test(description = "Test2 - Verify Default User")
    @Description("Test Verifies Default User")
    public void test02_verify_default_user() {
        UIActions.hoverElement(grafanaSideMenu.ServerShield_Button, grafanaServer.Users);
//        WebFlows.HoverAndClick(grafanaSideMenu.ServerShield_Button, grafanaServer.Users);
        Verifications.verifyNumberOfElements(grafanaAdminPage.Users_Rows, 1);
    }

    @Test(description = "Test3 - Verify New User")
    @Description("Test Verifies New User Created")
    public void test03_create_user() {
        UIActions.hoverElement(grafanaSideMenu.ServerShield_Button, grafanaServer.Users);
//        WebFlows.HoverAndClick(grafanaSideMenu.ServerShield_Button, grafanaServer.Users);
        WebFlows.CreateUser("admin1", "example1@gmail.com", "example1", "admin1");
        Verifications.verifyNumberOfElements(grafanaAdminPage.Users_Rows ,2);
    }

    @Test(description = "Test4 - Verify User Deletion")
    @Description("Test Verifies New User Has Been Deleted")
    public void test04_delete_user(){
        UIActions.hoverElement(grafanaSideMenu.ServerShield_Button , grafanaServer.Users);
//        WebFlows.HoverAndClick(grafanaSideMenu.ServerShield_Button , grafanaServer.Users);
        WebFlows.DeleteLastUser();
        Verifications.verifyNumberOfElements(grafanaAdminPage.Users_Rows, 1);
    }

    @Test(description = "Test5 - Verify Progress Steps")
    @Description("Test Verifies Existence of The Steps")
    public void test05_verify_progress_steps(){
        Verifications.visibilityOfElements(grafanaMain.progressSteps);
    }


    @Test(description = "Test6 - Verify Grafana Avatar Icon")
    @Description("Test Verifies Existence of the Avatar Icon")
    public void test06_verify_avatar_icon(){
        Verifications.visualElement("NewAvatar");
    }

    @Test(dataProvider = "DDT-provider" , dataProviderClass = utilities.DDTManager.class)
    @Description("Test Searches For Users In The Search Box")
    public void test07_search_users(String userName, String shouldExist) throws InterruptedException {
        UIActions.hoverElement(grafanaSideMenu.ServerShield_Button , grafanaServer.Users);
//        WebFlows.HoverAndClick(grafanaSideMenu.ServerShield_Button , grafanaServer.Users);
        WebFlows.searchAndVerifyUser(userName , shouldExist);
    }
    }
