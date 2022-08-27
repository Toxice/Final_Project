package pageobjects.mortgage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class MainPage {
    private AppiumDriver mobileDriver;

    public MainPage(AppiumDriver mobileDriver){
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)), this); // Upper Block of 3 seconds
    }

    @AndroidFindBy(id = "etAmount")
    public AndroidElement amount_Input; //Amount

    @AndroidFindBy(id = "etTerm")
    public AndroidElement term_Input; //Term

    @AndroidFindBy(id = "etRate")
    public AndroidElement rate_Input; //Rate

    @AndroidFindBy(id = "add_schedule_text")
    public AndroidElement calculate_Button; //Calculate Button

    @AndroidFindBy(id = "tvRepayment")
    public AndroidElement Repayment; //Repayment

    @AndroidFindBy(id = "tvInterestOnly")
    public AndroidElement Interest; //Interest

}
