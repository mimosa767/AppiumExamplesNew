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

public class MobileBrowserBaseTest {

    public AndroidDriver driver;
    //public AppiumDriverLocalService service;

    @BeforeClass
    public void configureAppium() throws MalformedURLException {


          UiAutomator2Options capabilities = new UiAutomator2Options();
          capabilities.setDeviceName("appium1"); //deviceName
          capabilities.setChromedriverExecutable("//Users//spenn02//AppiumExamplesNew//application//chromedriver105");//chrome driver, hybrid app
          capabilities.setCapability("browserName", "Chrome");
          driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities); //create android driver object
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //set global implicit wait
    }

    public void dragDropAction(WebElement ele) {
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)ele).getId(),
                "endX", 651,
                "endY", 691
        ));
    }

    public Double getFormattedAmount(String amount ){
        Double price =  Double.parseDouble(amount.substring(1));
        return price;

    }


    @AfterClass
    public void tearDown() {

        driver.quit();  //quit application
//        service.stop(); //stop service
    }
}
