package package1;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class eCommerce_tc_4_Hybrid extends BaseTestEcommerce {

    @Test
    public void FillForm() throws InterruptedException {

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Stephen Penn");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(2000);
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
//        driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[0]")).click();
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();  //use the same index twice because of a change on the UI


        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//     wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
        Thread.sleep(2000);
        List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        int count = productPrices.size();
        double totalSum = 0;
        for (int i = 0; i < count; i++) {

            String amountString = productPrices.get(i).getText(); //a string is provided $120.00 for example
            //start on the 1 index which is the second character, this takes $ away from string amountString
            Double price = Double.parseDouble(amountString.substring(1)); //this changes the price of the text to a double number
            totalSum = totalSum + price; //160.97 + 120 = 280.97


        }
        String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Double displayFormattedSum = getFormattedAmount(displaySum);
        Assert.assertEquals(totalSum, displayFormattedSum);
        WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        longPressAction(ele);

        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

        Thread.sleep(8000);
        Set<String> contexts = driver.getContextHandles();
        for (String contextName : contexts) {
            System.out.println(contextName);

        }

        driver.context("WEBVIEW_com.androidsample.generalstore");//chrome driver

        driver.findElement(By.name("q")).sendKeys("Stephen Penn");

        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        driver.context("NATIVE_APP");

    }



}