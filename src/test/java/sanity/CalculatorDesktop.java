package sanity;

import extentions.Verifications;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlows;


@Listeners(utilities.Listeners.class)
public class CalculatorDesktop extends CommonOps {

    @Test
    public void test01_adding_one_to_eight() {
       DesktopFlows.calculateAddition(calcMain.btn_one , calcMain.btn_eight);
        Verifications.verifyTextInElement(calcMain.field_result , "Display is 9");
    }

    @Test
    public void test02_adding_five_to_six() {
        DesktopFlows.calculateAddition(calcMain.btn_five , calcMain.btn_six);
        Verifications.verifyTextInElement(calcMain.field_result , "Display is 11");
    }
}
