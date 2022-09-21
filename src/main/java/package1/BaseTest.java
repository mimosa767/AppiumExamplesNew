package package1;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public AndroidDriver driver;
    //public AppiumDriverLocalService service;

    @BeforeClass
    public void configureAppium() throws MalformedURLException {

        //         service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
//                .withIPAddress("127.0.0.1").usingPort(4723).build(); //the configuration information needed to start appium locally programmatically
//        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("appium1");
        options.setApp("//users//spenn02//AppiumExamplesNew//application//ApiDemos-debug.apk");
         driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void dragDropAction(WebElement ele) {
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)ele).getId(),
                "endX", 651,
                "endY", 691
        ));
    }

    public void swipeAction(WebElement ele, String direction) {

        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)ele).getId(),
                "direction", direction,  //you have to swipe left or right
                "percent", 0.75 //how much will you swipe, this is swipe area space
        ));
    }
    public void longPressAction (WebElement ele) {
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(), "duration", 2000));
    }

    public void scrollToEndAction () {
        boolean canScrollMore;
        do
        {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(  //if more to scroll, it will scroll more
                    "left", 200, "top", 200, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
        }while (canScrollMore);
    }

    @AfterClass
    public void tearDown() {

        driver.quit();  //quit application
//        service.stop(); //stop service
    }
}
