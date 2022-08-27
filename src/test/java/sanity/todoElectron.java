package sanity;

import extentions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;

@Listeners(utilities.Listeners.class)
public class todoElectron extends CommonOps {

    @Test(description = "Test 01: Adding a new task and verify it's existence")
    @Description("This Test creates new task and verify its existence")
    public void test01_add_new_task_and_verify() throws InterruptedException {
        ElectronFlows.addTask("Learn Java");
        Thread.sleep(1000);
        ElectronFlows.addTask("Learn Ruby");
        Thread.sleep(1000);
        Verifications.verifyNumber(todoMain.Tasks_By_Name.size() , Integer.parseInt("2"));
    }

    @Test
    public void test02() throws InterruptedException {
        Thread.sleep(2000);
        ElectronFlows.addTask("Learn Python");

        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks() , 1);
    }

    @Test
    public void test03_add_task_and_color() throws InterruptedException {
        Thread.sleep(1500);
        ElectronFlows.addTask("Task red" , getData("red"));
        Thread.sleep(1500);
    }

}
