package sanity;

import extentions.Verifications;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.APIFlows;

@Listeners(utilities.Listeners.class)
public class GrafanaAPI extends CommonOps {

    @Test(description = "Test 01: get Team's name")
    @Description("This Test verifies team property")
    public void test01_verify_team(){
        try {
            Verifications.verifyText(APIFlows.getTeamProperty("teams[0].name"), "admin");

        } catch (AssertionError e) { Assert.fail("Wrong Expected value: " + e);}
    }

    @Test(description = "Test 02: create a new team")
    @Description("This Test creates a new team")
    public void test02_create_team_and_verify(){
        APIFlows.createTeam("BoniGarcia" , "Bonbon@bmail.com");
        try {
            Verifications.verifyText(APIFlows.getTeamProperty("teams[0].name"), "BoniGarcia");
        } catch (AssertionError e) { Assert.fail("wrong expected value: " + e);}
    }

//    @Test
//    public void test03_get_team_by_id(){
//        System.out.println("team's id is: " +  APIFlows.getTeamProperty("teams[1].id"));
//    }

    @Test(description = "Test 03: update existing team")
    @Description("This Test updates existing team")
    public void test03_update_team(){
        String id =  APIFlows.getTeamProperty("teams[0].id");

        APIFlows.updateTeam("BibiNetanyahu" , "Bibi@gmail.com" , id);

        Verifications.verifyText(APIFlows.getTeamProperty("teams[0].name") , "BibiNetanyahu");
    }

    @Test(description = "Test 03: delete existing team")
    @Description("This Test deletes existing team")
    public void test04_delete_team(){
        String id = APIFlows.getTeamProperty("teams[0].id");

        APIFlows.deleteTeam(id);
        Verifications.verifyText(APIFlows.getTeamProperty("totalCount") , "1"); // verify 1 existing team
    }
}
