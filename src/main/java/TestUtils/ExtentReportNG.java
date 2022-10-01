package TestUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
    static ExtentReports extent;

    public static ExtentReports getReporterObject() {

            // ExtentReports, ExtentSparkReporter
            String path =  System.getProperty("user.dir")+"//reports//index.html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(path); //object is responsible for creating all configurations for your extent reports
            reporter.config().setReportName("Web Automation Results"); //report name
            reporter.config().setDocumentTitle("Test Results"); //html document title

            extent = new ExtentReports();
            extent.attachReporter(reporter); //the main class is given knowledge of the extent object
            extent.setSystemInfo("Tester", "Stephen Penn");
            return extent;
        }

}

