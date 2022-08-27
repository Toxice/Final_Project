package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import workflows.DesktopFlows;
import workflows.ElectronFlows;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Parameters;

public class CommonOps extends Base {

    public static String getData(String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("C:\\Users\\toxic\\IdeaProjects\\Final_Project\\Configuration\\TestConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
        catch (Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    public static void initBrowser(String browserType){
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if (browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else throw new RuntimeException("Invalid Browser Type");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(5 , TimeUnit.SECONDS);

        Wait = new WebDriverWait(driver , 5);
        driver.get(getData("url")); //driver.get("http://localhost:3000/");
        ManagePages.initGrafana(); // initialize the grafana web application
        action = new Actions(driver);

    }


    public static WebDriver initChromeDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }


    public static WebDriver initFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initIEDriver(){
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    public static void initMobile(){
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
        try {
            MobileDriver = new AndroidDriver(new URL(getData("AppiumServer")), dc);
        } catch (MalformedURLException e) {
            System.out.println("cannot connect to appium server..., see details: " + e);
        }

        MobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
        Wait = new WebDriverWait(MobileDriver , 5);
        ManagePages.initMortgage(); // initialize mortgage app
        // action = new Actions(driver);
    }

    public static void initAPI(){
        RestAssured.baseURI = getData("uri"); // Base URL
        httpRequest = RestAssured.given().auth().
                preemptive().basic(getData("username") , getData("password")); // Authentication
    }

    public static void initElectron(){
        System.setProperty("webdriver.chrome.driver" , getData("ElectronDriverPath"));
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary(getData("ElectronAppPath")); // configure the path of the App
        dc.setCapability("chromeOptions" , chromeOptions);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc); // not suitable for Selenium 4
        ManagePages.initTodoList();
        Wait = new WebDriverWait(driver , 10);
        action = new Actions(driver);
        }

        public static void initDesktop(){
           // dc.setCapability("app" , getData("AppID"));

            try {
                dc.setCapability("app" , getData("AppID"));
                driver = new WindowsDriver(new URL(getData("WindowsServer")) , dc);
                // driver = new WindowsDriver(new URL(getData("WindowsServer")) , dc);
            } catch (Exception e) {
                System.out.println("cannot connect to Appium server, see details: " + e);
            }
            driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
            Wait = new WebDriverWait(driver, Long.parseLong(getData("TimeOut")));

             ManagePages.initCalculator();
             }


    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName){
        Platform = PlatformName;
        switch (Platform)
        {
            case "web": initBrowser(getData("BrowserName"));
            break;

            case "mobile": initMobile();
            break;

            case "api": initAPI();
            break;

            case "electron": initElectron();
            break;

            case "desktop": initDesktop();
            break;

            default: throw new RuntimeException("Invalid Platform Name");
        }

        softAssert = new SoftAssert();

        screen = new Screen();

        // Calling the Database
        ManageDB.openConnection(getData("DBurl"), getData("DBusername") , getData("DBpassword"));
    }

    @AfterMethod
    public void refreshSession() {

        switch (Platform) {
            case "web":
                driver.get("http://localhost:3000/");
                break;

            case "mobile":
                // TODO MOBILE
                break;

            case "api":
                // TODO API
                break;

            case "electron":
                for (WebElement elem : todoMain.Tasks_By_Name) {
                    ElectronFlows.deleteTask(todoMain.deleteTaskButton);
                }
                break;

            case "windows":
                 DesktopFlows.emptyFieldResult();
                break;
        }
    }



    @BeforeMethod
    public void beforeMethod(Method method) throws Exception {
        if (!Platform.equalsIgnoreCase("api"))
        {
        MonteScreenRecorder.startRecord(method.getName());
    }}

    @AfterClass
    public void closeSession(){

        switch (Platform)
        {
            case "web":
            case "electron":
            case "desktop":
                driver.quit();
                break;

            case "mobile":
                MobileDriver.quit();
                break;

            case "api":
                // Not Required
                break;
        }
    }
}
