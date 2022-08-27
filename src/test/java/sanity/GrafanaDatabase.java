package sanity;

import extentions.Verifications;
import jdk.jfr.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class GrafanaDatabase extends CommonOps {

    @Test(description = "Test 01: login database and verify header")
    @Description("Verify Login action while entering data from database")
    public void test01_login_from_database_and_verify_header(){
        WebFlows.loginFromDatabase();
        Verifications.verifyTextInElement(grafanaMain.MainHeader, "Welcome to Grafana");
    }
}
