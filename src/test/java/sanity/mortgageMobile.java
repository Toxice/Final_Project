package sanity;

import extentions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;


@Listeners(utilities.Listeners.class)
public class mortgageMobile extends CommonOps {

    @Test(description = "Test01 - Calculate Mortgage")
    @Description("this test verifies given mortgage values to give a true value")
    public void test01_calculate_mortgage(){
        MobileFlows.calculateMortgage("1000", "3", "4");
        Verifications.verifyTextInElement(mortgageMain.Repayment, "£30.03");
        //Verifications.verifyTextInElement(mortgageMain.Interest, "£3.33");
    }
}
