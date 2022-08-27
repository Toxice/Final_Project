package workflows;

import extentions.RESTActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class APIFlows extends CommonOps {

    @Step("Business Flow: getting the specified team's property")
    public static String getTeamProperty(String jPath){ // hardcoded
        response = RESTActions.GET("/api/teams/search");

        response.prettyPrint();

        return RESTActions.parseJSON(response , jPath);
    }

    @Step("Business Flow: create a new team")
    public static void createTeam(String name , String email){
        params.put("name", name); // add name
        params.put("email" , email);

        RESTActions.POST(params , "/api/teams");
    }

    @Step("Business Flow: update a new team")
    public static void updateTeam(String name , String email, String teamID){
        params.put("name" , name);
        params.put("email" , email);

        RESTActions.PUT(params , "/api/teams/" + teamID);

        response.prettyPrint();
    }

    @Step("Business Flow: delete an existing team")
    public static void deleteTeam(String teamID){
        RESTActions.DELETE(params , "/api/teams/" + teamID);
    }
}
