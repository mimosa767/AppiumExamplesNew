package androidPackage;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

public class FormPage extends AndroidActions {

    AndroidDriver driver;

    public FormPage (AndroidDriver driver) {

            super(driver); //call parent class constructor androidactions
            this.driver = driver;  //the current driver is equal to your local driver, now you can use it anywhere globally
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        }


    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    @AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
    private WebElement femaleOption;


    @AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
    private WebElement maleOption;

    @AndroidFindBy(id = "android:id/text1" )
    private WebElement countrySelection;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    public WebElement shopButton;

    public void setNameField(String name) {
        nameField.sendKeys(name);
        driver.hideKeyboard();
    }

    public void setGender (String gender) {

        if (gender.contains("female"))
            femaleOption.click();
        else
            maleOption.click();
    }

    public void setCountry(String country) {
        countrySelection.click();
        scrollToText(country);
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+country+"']")).click();

    }

    public ProdcutCatalogue submitForm() {
        shopButton.click();
        return new ProdcutCatalogue(driver);

    }

    public void setActivity() {
                    //adb shell dumpsys window | grep -E 'mCurrentFocus'
            Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity"); //you specify that you want to go directly to the app package and screen specified in the activity name
            driver.startActivity(activity);
    }


}
