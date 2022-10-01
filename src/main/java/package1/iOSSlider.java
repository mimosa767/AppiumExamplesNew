package package1;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class iOSSlider extends iOSBaseTest {

    @Test
    public void IOSSliderTest() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Sliders")).click();
        Thread.sleep(2000);
        WebElement slider = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider"));
        slider.sendKeys("0%");
        System.out.println(slider.getAttribute("value"));
        Assert.assertEquals("1%", slider.getAttribute("value"));
        Thread.sleep(2000);
        slider.sendKeys("1%");

//        WebElement ele = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == 'Increment'`][3]"));
//        Map<String, Object> params = new HashMap<>();
//        params.put("element", ((RemoteWebElement) ele).getId());
//        params.put("duration", 5);
//        driver.executeScript("mobile:touchAndHold", params);



    }
}
