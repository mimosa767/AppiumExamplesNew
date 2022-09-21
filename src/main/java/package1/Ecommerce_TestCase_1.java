package package1;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;


import java.net.MalformedURLException;

public class Ecommerce_TestCase_1 extends LocalDriverMethodEcommerce {

    public static void main (String [] args) throws MalformedURLException, InterruptedException {

        AndroidDriver driver = LocalDriverMethodEcommerce.capabilities();
        Thread.sleep(2000);
        //driver.findElementByXPath("//android.widget.TextView[@text='Afghanistan']").click();
        //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");
        //Thread.sleep(2000);
        Thread.sleep(2000);
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Stephen is here");
        Thread.sleep(2000);
        driver.hideKeyboard();
        Thread.sleep(1000);
        driver.findElement(new By.ByXPath("//android.widget.RadioButton[@text='Female']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("android:id/text1")).click();
        Thread.sleep(2000);
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\\\"Argentina\\\"));\""));
        driver.findElement(new By.ByXPath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(2000);
        driver.quit();

    }
}
