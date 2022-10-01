package TestUtils;

import androidPackage.FormPage;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseTestEcommerce {

    public AndroidDriver driver;

    public FormPage formPage;

    @BeforeClass(alwaysRun = true) //always run this class no matter what, bypass the group filter
    public void configureAppium() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//resources//data.properties");

        String ipAddress =  prop.getProperty("ipAddress") != null ? System.getProperty("ipAddress") : prop.getProperty("ipAddress");
        prop.load(fis);
        String port = prop.getProperty("port");



          UiAutomator2Options capabilities = new UiAutomator2Options();
          capabilities.setDeviceName("appium1");
          capabilities.setChromedriverExecutable("//Users//spenn02//AppiumExamplesNew//application//chromedriver");//chrome driver
          capabilities.setApp("//users//spenn02//AppiumExamplesNew//application//General-Store.apk");
          driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
          formPage = new FormPage(driver);
    }



    @AfterClass
    public void tearDown() {

        driver.quit();  //quit application
//        service.stop(); //stop service
    }
}
