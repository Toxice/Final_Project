package utilities;

import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageobjects.grafana.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Base {

    //General
    protected static WebDriverWait Wait;

    protected static Actions action;

    protected static Alert popup;

    protected static SoftAssert softAssert;

    protected static Screen screen;  //Sikuli API

    public static String Platform;

    //Web , Windows
    protected static WebDriver driver; // Suitable for Selenium and Electron


    //Mobile
    protected static AppiumDriver MobileDriver;


    // Mobile , Electron , Windows
     protected static DesiredCapabilities dc = new DesiredCapabilities();

    // REST API
    protected static RequestSpecification httpRequest;

    protected static Response response;

    protected static JSONObject params = new JSONObject();

    protected static JsonPath jPath;

    // DataBase
    protected static Connection conSQL;

    protected static Statement statementSQL;

    protected static ResultSet resultSQL;


    // Page Objects - Web
    protected static LoginPage grafanaLogin;

    protected static MainPage grafanaMain;

    protected static LeftMenuPage grafanaSideMenu;

    protected static ShieldPage grafanaServer;

    protected static UsersManagePage grafanaAdminPage;

    protected static CreateUserPage grafanaUserPage;

    protected static UserHandlerPage grafanaUserHandler;

    protected static LeftMenuPage grafanaLeftMenuPage;

    //Page Objects - Mobile
    protected static pageobjects.mortgage.MainPage mortgageMain;

    //Page Objects - Electron
    protected static pageobjects.todolist.MainPage todoMain;

    //Page Objects - Windows
    protected static pageobjects.calculator.MainPage calcMain;
}
