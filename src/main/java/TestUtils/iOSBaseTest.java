package TestUtils;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import iosPackage.AlertViews;
import iosPackage.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class iOSBaseTest {

    public IOSDriver driver;
    //public AppiumDriverLocalService service;
    public HomePage homePage;
    public AlertViews alertViews;

    @BeforeClass
    public void configureAppium() throws MalformedURLException {

        //         service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
//                .withIPAddress("127.0.0.1").usingPort(4723).build(); //the configuration information needed to start appium locally programmatically
//        service.start();
          XCUITestOptions capabilities = new XCUITestOptions();
          capabilities.setDeviceName("iPhone 12 Pro Max");
          capabilities.setApp("//Users//spenn02//Library//Developer//Xcode//DerivedData//UIKitCatalog-dcscrbzjvdllbrfgpxcwcuhkdgit//Build//Products//Debug-iphonesimulator//UIKitCatalog.app");
          capabilities.setPlatformVersion("14.5");
          //Appium - Webdriver agent -> iOS Apps
          capabilities.setWdaLaunchTimeout(Duration.ofSeconds(20));

          driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), capabilities);
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
          homePage = new HomePage(driver);
          alertViews = new AlertViews(driver);
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
