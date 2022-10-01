package iosPackage;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.IOSActions;

public class AlertViews extends IOSActions {

    IOSDriver driver;

    public AlertViews(IOSDriver driver) {

            super(driver); //call parent class constructor androidactions
            this.driver = driver;  //the current driver is equal to your local driver, now you can use it anywhere globally
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        }


    @iOSXCUITFindBy(accessibility = "Alert Views")
        private WebElement alertViews;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Text Entry'`]")
    private WebElement textEntry;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")
    private WebElement confirmPopUp;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell")
    private WebElement messageField;

    @iOSXCUITFindBy(accessibility = "OK")
    private WebElement okButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH[c]'A message'")
    private WebElement message;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Confirm'")
    private WebElement confirmButton;

        public void selectAlertViews()
        {
            alertViews.click();
        }

        public void selectTextEntry() {
            textEntry.click();
        }

        public void setConfirmPopUp() {
            confirmPopUp.click();
        }

        public void setMessageField () {
            messageField.sendKeys("Hello World");
        }

        public void setOkButton() {
            okButton.click();
        }

        public String getMessage () {
            message.getText();
            return null;
        }

        public void setConfirmButton () {
            confirmButton.click();
        }




}
