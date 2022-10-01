package androidPackage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

import java.util.List;

public class CartPage extends AndroidActions {

    AndroidDriver driver;

    public CartPage(AndroidDriver driver) {

        super(driver); //call parent class constructor androidactions
        this.driver = driver;  //the current driver is equal to your local driver, now you can use it anywhere globally
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    public List<WebElement> productList;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    public WebElement totalAmount;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    public WebElement terms;

    @AndroidFindBy(id = "android:id/button1")
    public WebElement acceptButton;

    @AndroidFindBy(className = "android.widget.CheckBox")
    public WebElement checkBox;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    public WebElement proceed;

    public List<WebElement> getProductList() {
        return productList;
    }

    public double getProductsSum() {

        int count = productList.size();
        double totalSum = 0;
        for (int i = 0; i < count; i++) {

            String amountString = productList.get(i).getText(); //a string is provided $120.00 for example
            //start on the 1 index which is the second character, this takes $ away from string amountString
            Double price = Double.parseDouble(amountString.substring(1)); //this changes the price of the text to a double number
            totalSum = totalSum + price; //160.97 + 120 = 280.97


        }
        return totalSum;
    }

    public Double getTotalAmountDisiplayed () {
        return getFormattedAmount(totalAmount.getText());
    }



    public void acceptTermsConditons () {
        longPressAction(terms);
        acceptButton.click();
    }

    public void submitOrder() {
        checkBox.click();
        proceed.click();
    }
}
