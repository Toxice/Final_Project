package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import java.io.File;

public class Listeners extends CommonOps implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("on test start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("on test success");


        if (!Platform.equalsIgnoreCase("api")) // if the platform name is not "api" then do the recording
        {
            // STOP RECORDING FILE
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                System.out.println("error occurred while trying to film a video, please see details: " + e);
            }

            // DELETE RECORDED FILE
            File file = new File("./test-recordings/" + iTestResult.getName() + ".avi");
            if (file.delete()) {
                System.out.println("File deleted successfully");
            } else {
                System.out.println("Failed to delete file");
            }
        }
    }

    @Override
    @Parameters({"PlatformName"})
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("on test failure");

//        if (!Platform.equalsIgnoreCase("api"))
            switch (Platform){
            // STOP RECORDING FILE
                case "web":
                case "mobile":
                case "electron":
                case "desktop":
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                saveScreenShot();
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("on test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("on test failed, but some has succeeded");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("on start");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("on end");
    }

    @Attachment(value = "Page Screen Shot", type = "image/png")
    public byte[] saveScreenShot() throws Exception {
        /*
            if the driver were initialized to web then use driver, if the driver were initialized to mobile then MobileDriver
        */

        if (Platform.equalsIgnoreCase("web"))
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        else if (Platform.equalsIgnoreCase("mobile"))
            return ((TakesScreenshot)MobileDriver).getScreenshotAs(OutputType.BYTES);
        else if (Platform.equalsIgnoreCase("desktop"))
            return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        else throw new Exception("no driver was initialized");
    }
}



