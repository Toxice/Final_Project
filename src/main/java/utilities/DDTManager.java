package utilities;

import org.testng.annotations.DataProvider;

public class DDTManager {

    @DataProvider(name = "DDT-provider")
    public static Object[][] getProvider(){
        return new Object[][]{
                {"admin", "exist"},
                {"mor", "not-exist"},
                {"david", "not-exist"}
        };
        }
    }

