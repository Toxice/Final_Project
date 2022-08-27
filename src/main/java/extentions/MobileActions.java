package extentions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.time.Duration;

public class MobileActions extends CommonOps {

    @Step("Update Mobile Text")
    @Description("Sending text to a mobile element")
    public static void updateText(MobileElement mobileElement, String Text){
        Wait.until(ExpectedConditions.elementToBeClickable(mobileElement));
        mobileElement.sendKeys(Text);
    }

    @Step("Click Mobile Element")
    @Description("Clicking on a Mobile Element")
    public static void Click(MobileElement mobileElement){
        Wait.until(ExpectedConditions.elementToBeClickable(mobileElement));
        mobileElement.click();
    }

    @Step("tap on element")
    @Description("tapping on a given element")
    public static void Tap(MobileElement mobileElement){
        // Tap is based on Actions class of Selenium
        Wait.until(ExpectedConditions.elementToBeClickable(mobileElement));

        // TAP ACTION
        TouchAction Touchaction = new TouchAction(MobileDriver);
        Touchaction.tap((new TapOptions()).withElement(ElementOption.element(mobileElement))).perform();
    }


    /**
     * Performs swipe from the center of screen
     *
     * @param dir the direction of swipe
     * @version java-client: 7.3.0
     **/
    @Step("swipe")
    @Description("swiping screen")
    public void Swipe(Direction dir) {
        // Swipe is generated from Appium docs

        System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = driver.manage().window().getSize();

        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(MobileDriver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    @Step("Zoom on Element")
    @Description("Zoom on Element")
    public static void Zoom(MobileElement element){
        // Zoom is generated from Appium docs

        Wait.until(ExpectedConditions.visibilityOf(element));

        int x = element.getLocation().getX() + element.getSize().getWidth()/2;

        int y = element.getLocation().getY() + element.getSize().getHeight()/2;

        TouchAction Finger1 = new TouchAction(MobileDriver);
            Finger1.press(new ElementOption().withElement(element)
                    .withCoordinates(x, y-10))
                    .moveTo(new ElementOption()
                            .withElement(element)
                            .withCoordinates(x, y-100));

        TouchAction Finger2 = new TouchAction(MobileDriver);
            Finger2.press(new ElementOption()
                    .withElement(element)
                    .withCoordinates(x, y+10))
                    .moveTo(new ElementOption()
                            .withElement(element)
                            .withCoordinates(x, y+100));

        MultiTouchAction multitouchAction = new MultiTouchAction(MobileDriver);
        multitouchAction.add(Finger1).add(Finger2).perform();
    }

    @Step("Pinch on Element")
    @Description("Pinch on Element")
    public static void Pinch(MobileElement element){
        // Pinch is generated from Appium docs

        Wait.until(ExpectedConditions.visibilityOf(element));

        int x = element.getLocation().getX() + element.getSize().getWidth()/2;

        int y = element.getLocation().getY() + element.getSize().getHeight()/2;

        TouchAction Finger1 = new TouchAction(MobileDriver);
        Finger1.press(new ElementOption().withElement(element)
                        .withCoordinates(x, y-100))
                .moveTo(new ElementOption()
                        .withElement(element)
                        .withCoordinates(x, y-10));

        TouchAction Finger2 = new TouchAction(MobileDriver);
        Finger2.press(new ElementOption()
                        .withElement(element)
                        .withCoordinates(x, y+100))
                .moveTo(new ElementOption()
                        .withElement(element)
                        .withCoordinates(x, y+10));

        MultiTouchAction multitouchAction = new MultiTouchAction(MobileDriver);
        multitouchAction.add(Finger1).add(Finger2).perform();
    }


    public enum Direction {
        // Used in Swipe

        UP,
        DOWN,
        LEFT,
        RIGHT;
    }

}
