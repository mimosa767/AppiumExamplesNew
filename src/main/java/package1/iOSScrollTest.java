package package1;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class iOSScrollTest extends iOSBaseTest {

    @Test
    public void IOSScrollTestDemo() throws InterruptedException {

        WebElement ele = driver.findElement(AppiumBy.accessibilityId("Web View"));
        Map<String, Object> params = new HashMap<>(); //create hashmap class object
        params.put("direction", "down");
        params.put("element", ((RemoteWebElement)ele).getId());
        driver.executeScript("mobile:scroll", params);
        driver.findElement(AppiumBy.accessibilityId("Steppers")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name='UIKitCatalog']")).click();
        driver.findElement(AppiumBy.accessibilityId("Picker View")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.accessibilityId("Red color component value")).sendKeys("80");
        driver.findElement(AppiumBy.accessibilityId("Green color component value")).sendKeys("20");
        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Blue color component value'")).sendKeys("105");
        String number =  driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Blue color component value'")).getText();
        Assert.assertEquals(number, "105");
//        WebElement ele = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == 'Increment'`][3]"));
//        Map<String, Object> params = new HashMap<>();
//        params.put("element", ((RemoteWebElement) ele).getId());
//        params.put("duration", 5);
//        driver.executeScript("mobile:touchAndHold", params);



    }
}
