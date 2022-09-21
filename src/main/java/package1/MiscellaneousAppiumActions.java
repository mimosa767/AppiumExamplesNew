package package1;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.ScreenOrientation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class MiscellaneousAppiumActions extends BaseTest {

    @Test
    public void Miscellaneous() throws MalformedURLException {




        //xpath, id, accessibilityId, classname, androidUIAutomator
        //tagName[@class='attribute']
        //App Package & App Activity
        //adb shell dumpsys window | grep -E 'mCurrentFocus' - MAC
        Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies"); //you specify that you want to go directly to the app package and screen specified in the activity name
        driver.startActivity(activity); //you tell the driver to start the application where specified above
//        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//       // driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
//        driver.findElement(new By.ByXPath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        DeviceRotation landScape = new DeviceRotation(0, 0, 90); //create object to rotate
        driver.rotate(landScape); //this steps does the  rotation
        driver.rotate(ScreenOrientation.PORTRAIT);
        //tagName[class='attribute'] -> //tagName
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click(); //we use the xpath and the index to click the second tagname
        String alertTitle =  driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings"); //compare string from app with expected
        //copy to clipboard - paste it to clipboard
        driver.setClipboardText("Stephen Wifi");
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click(); //use findelements and then choose which index you want to click
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME)); //press the home button of the phone
    }
}
