package iosPackage;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.IOSActions;

public class HomePage extends IOSActions {

    IOSDriver driver;

    public HomePage(IOSDriver driver) {

            super(driver); //call parent class constructor androidactions
            this.driver = driver;  //the current driver is equal to your local driver, now you can use it anywhere globally
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        }

        @iOSXCUITFindBy(accessibility = "Alert Views")
        private WebElement alertViews;


        public void selectAlertViews()
        {
            alertViews.click();
        }
}
