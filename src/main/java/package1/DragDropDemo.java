package package1;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragDropDemo extends BaseTest {
    @Test
    public void DragDropTest() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        Thread.sleep(1000);
        WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        dragDropAction(source);
        Thread.sleep(2000);

        String result = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(result, "Dropped!");
//            driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']")).click();
//        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));")); //use google engine, create object of uiscrollable and send selector as an argument, scrollintoview method scrolls until it finds text
        Thread.sleep(2000);

    }
}
