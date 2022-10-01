package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportDemo {

    ExtentReports extent;

    @BeforeTest
    public void config () {

        // ExtentReports, ExtentSparkReporter
        String path =  System.getProperty("user.dir")+"//reports//index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path); //object is responsible for creating all configurations for your extent reports
        reporter.config().setReportName("Web Automation Results"); //report name
        reporter.config().setDocumentTitle("Test Results"); //html document title

        extent = new ExtentReports();
        extent.attachReporter(reporter); //the main class is given knowledge of the extent object
        extent.setSystemInfo("Tester", "Stephen Penn");
    }

    @Test
    public void initialDemo() {

        ExtentTest test = extent.createTest("Initial Demo");
        System.setProperty("webdriver.chrome.driver", "./application/chromedriver105");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com");
        Assert.assertTrue(true);
        System.out.println(driver.getTitle());
        String s = null;
        extent.getReport();
        extent.flush(); //this is necessary for the report to be generated
        driver.close();
    }

}


