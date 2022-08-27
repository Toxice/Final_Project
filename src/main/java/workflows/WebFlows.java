package workflows;

import extentions.DatabaseActions;
import extentions.UIActions;
import extentions.Verifications;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.util.List;

import static org.testng.Assert.*;

public class WebFlows extends CommonOps {

    @Step("Business Flow: Login")
    public static void login(String user , String password){
        UIActions.updateText(grafanaLogin.user , user);

        UIActions.updateText(grafanaLogin.password , password);

        UIActions.Click(grafanaLogin.loginButton);

        UIActions.Click(grafanaLogin.skipButton);
    }

    @Step("Business Flow: Login with credentials from database")
    public static void loginFromDatabase(){
        String Query = "SELECT name, password FROM employees WHERE id='3'";
        List<String> Credentials =  DatabaseActions.getCredentials(Query);

        UIActions.updateText(grafanaLogin.user , Credentials.get(0)); // Credentials with the 1'st value from the database table

        UIActions.updateText(grafanaLogin.password , Credentials.get(1)); // Credentials with the 2'nd value from the database table

        UIActions.Click(grafanaLogin.loginButton);

        UIActions.Click(grafanaLogin.skipButton);
    }

    @Step("Business Flow: Hover and Click on Element")
    public static void HoverAndClick(WebElement elemA , WebElement elemB){
        UIActions.hoverElement(elemA , elemB);
    }

    @Step("Business Flow: Create User")
    public static void CreateUser( String name , String email , String username , String password){
        UIActions.Click(grafanaAdminPage.create_button);
        UIActions.updateText(grafanaUserPage.name , name);
        UIActions.updateText(grafanaUserPage.email , email);
        UIActions.updateText(grafanaUserPage.username , username);
        UIActions.updateText(grafanaUserPage.password , password);
        UIActions.Click(grafanaUserPage.createButton);
    }

    @Step("Business Flow: Delete Last User")
    public static void DeleteLastUser(){
        UIActions.Click(grafanaAdminPage.Users_Rows.get(grafanaAdminPage.Users_Rows.size() - 1)); // The Last User
        UIActions.Click(grafanaUserHandler.DeleteUser);
        UIActions.Click(grafanaUserHandler.Confirm_Deletion);
        Wait.until(ExpectedConditions.visibilityOf(grafanaAdminPage.Users_Rows.get(0)));
    }

    @Step("Business Flow: Search and Verify User")
    public static void searchAndVerifyUser(String userName, String shouldExist) throws InterruptedException {
        UIActions.updateTextAsHuman(grafanaAdminPage.SearchBox , userName);
        if (shouldExist.equalsIgnoreCase("exist")) Verifications.existenceOfElement(grafanaAdminPage.Users_Rows);
        else if (shouldExist.equalsIgnoreCase("not-exist")) Verifications.nonExistenceOfElement(grafanaAdminPage.Users_Rows);
        else throw new RuntimeException(("Invalid String Option"));
        /*
        we send a string with "exist" or "not exist", for each term we have a scenario up here
         */
    }
}
