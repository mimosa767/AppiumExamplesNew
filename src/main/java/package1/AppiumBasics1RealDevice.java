package package1;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AppiumBasics1RealDevice extends BaseTestRealDevice {

    @Test
    public void WifiSetting() throws MalformedURLException, InterruptedException {




        //xpath, id, accessibilityId, classname, androidUIAutomator
        //tagName[@class='attribute']
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        Thread.sleep(2000);
       // driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        driver.findElement(new By.ByXPath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        //tagName[class='attribute'] -> //tagName
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click(); //we use the xpath and the index to click the second tagname
        String alertTitle =  driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings"); //compare string from app with expected
        driver.findElement(By.id("android:id/edit")).sendKeys("Stephen Wifi");
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click(); //use findelements and then choose which index you want to click




    }
}
