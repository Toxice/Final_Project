package utilities;

import java.sql.DriverManager;

public class ManageDB extends CommonOps {

    public static void openConnection(String databaseURL , String user , String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conSQL = DriverManager.getConnection(databaseURL , user , password);

            statementSQL = conSQL.createStatement();
        } catch (Exception e) {
            System.out.println("cannot connect to Database , please see details: " + e);
        }
    }

    public static void closeConnection(){
        try {
            conSQL.close();
        } catch (Exception e) {
            System.out.println("unable to close connection , please see details: " + e);
        }
    }
}
