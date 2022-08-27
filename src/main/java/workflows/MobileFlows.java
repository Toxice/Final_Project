package workflows;

import extentions.MobileActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class MobileFlows extends CommonOps {

    @Step("Business Flow: Fill Form Calculate Mortgage")
    public static void calculateMortgage(String Amount, String Term, String Rate){
        // calculates the mortgage by the given parameters
        MobileActions.updateText(mortgageMain.amount_Input, "1000");
        MobileActions.updateText(mortgageMain.term_Input, "3");
        MobileActions.updateText(mortgageMain.rate_Input, "4");
        MobileActions.Tap(mortgageMain.calculate_Button);
    }

}
