package Package2;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import TestUtils.BaseTestEcommerce;

public class eCommerce_tc_1new extends BaseTestEcommerce {

//        @BeforeMethod
//        public void preSetup() {
//            //adb shell dumpsys window | grep -E 'mCurrentFocus'
//            Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity"); //you specify that you want to go directly to the app package and screen specified in the activity name
//            driver.startActivity(activity);
//    }

    @Test
    public void FillForm_ErrorValidation() throws InterruptedException {

//        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Stephen Penn");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(2000);
        String toastMessage =  driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name"); //Toast messages inherently have an attribute called name that has the text of the toast
        Assert.assertEquals(toastMessage, "Please enter your name");
    }

    @Test
    public void FillForm_PositiveFlow() throws InterruptedException {

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Stephen Penn");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElements(By.xpath("(//android.widget.Toast)[1]")).size()<1);

    }


}
