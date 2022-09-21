package package1;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.remote.http.HttpClient;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBasics extends BaseTest {

    @Test
    public void AppiumTest() throws MalformedURLException {


        //Appium code -> Appium Server -> Mobile
//        AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
//                .withIPAddress("127.0.0.1").usingPort(4723).build(); //the configuration information needed to start appium locally programmatically
//        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 5 API 30");
        options.setApp("//users//spenn02//AppiumExamplesNew//application//ApiDemos-debug.apk");


        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

        //xpath, id, accessibilityId, classname, androidUIAutomator
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();

        driver.quit();  //quit application
//        service.stop(); //stop service
    }
}
