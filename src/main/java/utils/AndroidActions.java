package utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class AndroidActions extends AppiumUtils {

    AndroidDriver driver;

    public AndroidActions (AndroidDriver driver) {


        this.driver = driver; //assign global driver to this driver

    }

    public void swipeAction(WebElement ele, String direction) {



        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)ele).getId(),
                "direction", direction,  //you have to swipe left or right
                "percent", 0.75 //how much will you swipe, this is swipe area space
        ));
    }
    public void longPressAction (WebElement ele) {
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(), "duration", 2000));
    }

    public void scrollToText(String text) {

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));

    }

    public void scrollToEndAction () {
        boolean canScrollMore;
        do
        {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(  //if more to scroll, it will scroll more
                    "left", 200, "top", 200, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
        }while (canScrollMore);
    }

}
