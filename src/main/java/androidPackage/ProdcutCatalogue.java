package androidPackage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

import java.util.List;

public class ProdcutCatalogue extends AndroidActions {

    AndroidDriver driver;

    public ProdcutCatalogue(AndroidDriver driver) {

            super(driver); //call parent class constructor androidactions
            this.driver = driver;  //the current driver is equal to your local driver, now you can use it anywhere globally
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
    private List<WebElement> addToCart;

    @AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement cart;

    public void addItemToCartByIndex(int index) {
        addToCart.get(index).click();

    }

    public CartPage goToCartPage() throws InterruptedException {
        Thread.sleep(2000);
        cart.click();
        Thread.sleep(2000);
        return new CartPage(driver);
    }



}
