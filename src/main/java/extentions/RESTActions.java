package extentions;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilities.CommonOps;

public class RESTActions extends CommonOps {

    @Step("GET Request")
    @Description("Get DATA from the server")
    public static Response GET(String resourceURL){
        httpRequest.header("Content-Type", "application/json"); // Configure the header as JSON

        response = httpRequest.get(resourceURL);
        //response.prettyPrint();

        return response;
    }

    @Step("parse JSON value")
    @Description("extract value from JSON")
    public static String parseJSON(Response response, String path){
        jPath = response.jsonPath();
        return jPath.get(path).toString();
    }

    @Step("POST Request")
    public static void POST(JSONObject JsonObject , String resourceURL){
        httpRequest.header("Content-Type", "application/json"); // Configure the header as JSON

        httpRequest.body(JsonObject.toJSONString()); // add the JSON to the request body

        response = httpRequest.post(resourceURL);

        response.prettyPrint(); // for debugging
    }

    @Step("PUT Request")
    public static void PUT(JSONObject JsonObject , String resourceURL){
        httpRequest.header("Content-Type", "application/json"); // Configure the header as JSON

        httpRequest.body(JsonObject.toJSONString()); // add the JSON to the request body

        response = httpRequest.put(resourceURL);

    }

    @Step("DELETE Request")
    public static void DELETE(JSONObject JsonObject , String resourceURL){
        httpRequest.header("Content-Type", "application/json"); // Configure the header as JSON)

        httpRequest.body(JsonObject.toJSONString());

        response = httpRequest.delete(resourceURL);

        response.prettyPrint();
    }

}
