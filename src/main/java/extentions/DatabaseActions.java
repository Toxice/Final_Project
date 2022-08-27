package extentions;

import io.qameta.allure.Step;
import utilities.CommonOps;

import java.util.ArrayList;
import java.util.List;

public class DatabaseActions extends CommonOps {

    @Step("get credentials from database")
    public static List<String> getCredentials(String Query){
        List<String> Credentials = new ArrayList<>();
        try {
            resultSQL =  statementSQL.executeQuery(Query);
            resultSQL.next();
            Credentials.add(resultSQL.getString(1));
            Credentials.add(resultSQL.getString(2));
        } catch (Exception e) {
            System.out.println("error in getting credentials, see details: " + e);
        }
        return Credentials;
    }
}
