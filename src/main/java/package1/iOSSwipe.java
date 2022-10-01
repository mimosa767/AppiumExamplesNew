package package1;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class iOSSwipe extends iOSBaseTest {

    @Test
    public void IOSSwipeTest() {

//        driver.findElement(AppiumBy.accessibilityId("Steppers")).click();
//        WebElement ele = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == 'Increment'`][3]"));
        //Bundle ID
          Map<String, Object> params = new HashMap<>();
          params.put("bundleId", "com.apple.mobileslideshow");
//        params.put("element", ((RemoteWebElement) ele).getId());
//        params.put("duration", 5);
        driver.executeScript("mobile:launchApp", params);
        driver.findElement(AppiumBy.accessibilityId("All Photos")).click();
        List<WebElement> allPhotos = driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell"));
        System.out.println(allPhotos.size());
        driver.findElement(By.xpath("//XCUIElementTypeCell[1]")).click();
        for (int i=0; i < allPhotos.size(); i++) {
            System.out.println(driver.findElement(By.xpath("//XCUIElementTypeNavigationBar")).getAttribute("name"));
            Map<String, Object> params1 = new HashMap<>(); //hashmap for swiping
            params1.put("direction", "left"); //by default the swipe happens at the center of the screen which is what we want
            //        params1.put("element", ((RemoteWebElement) ele).getId());
            driver.executeScript("mobile:swipe", params1);

        }
        driver.navigate().back();
        driver.findElement(AppiumBy.accessibilityId("Albums")).click(); //clean up to put app back into the beginning state



    }
}
