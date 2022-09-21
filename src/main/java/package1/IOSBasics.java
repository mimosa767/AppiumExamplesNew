package package1;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class IOSBasics extends iOSBaseTest {

    @Test
    public void IOSBasicsTest() {

            //Xpath, classname, IOS, accessibility id, iosClassCHain, IOSPredicateString, id

        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
        //XPATH  - xml language - app source
//        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Text Entry']")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == 'Text Entry'`]")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).sendKeys("Hello World");
        driver.findElement(AppiumBy.accessibilityId("OK")).click();
        driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")).click(); //must be an exact match and its case sensitive
        String text = driver.findElement(AppiumBy.iOSNsPredicateString("name BEGINSWITH[c]'A message'")).getText();
        System.out.println(text);
        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Confirm'")).click();

        // driver.findElement(AppiumBy.iOSNsPredicateString("type == 'Confirm / Cancel' AND value == 'Confirm / Cancel'"));
//        driver.findElement(AppiumBy.iOSNsPredicateString("type == 'Confirm / Cancel' AND value BEGINSWITH[c] 'Confirm'")).click();
//        driver.findElement(AppiumBy.iOSNsPredicateString("type == 'Confirm / Cancel' AND value ENDSWITH[c] 'Cancel'"));
//        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Confirm'")).click();


    }
}
