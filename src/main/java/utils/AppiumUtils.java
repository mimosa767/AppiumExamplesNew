package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class AppiumUtils  {

    AppiumDriver driver;



    public Double getFormattedAmount(String amount){

        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }

    public void waitForElementToAppear(WebElement ele) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains((ele), "text", "Cart"));
    }

    public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException {

        File source = driver.getScreenshotAs(OutputType.FILE); //takes screenshot and puts it in a file output
        String destinationFile = System.getProperty("user.dir")+"//reports"+testCaseName+".png";
        FileUtils.copyFile(source, new File(destinationFile)); //copy screenshot and place it into destination file
        System.out.println("this is the destination file " +destinationFile);
        return destinationFile;
        //1. capture and place in folder //2. extent report pick file and attach to report
    }

    public AppiumDriverLocalService startAppiumServer() {

        AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build(); //the configuration information needed to start appium locally programmatically
        service.start();
        return  service;
    }

}
