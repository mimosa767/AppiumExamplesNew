package Package2;

import androidPackage.CartPage;
import androidPackage.FormPage;
import androidPackage.ProdcutCatalogue;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestUtils.BaseTestEcommerce;

public class eCommerce_tc_4_Hybrid extends BaseTestEcommerce {

    @Test(dataProvider = "getData", groups = {"Smoke"})  //group your test
    public void FillForm(String name, String gender, String country) throws InterruptedException {

        FormPage formPage = new FormPage(driver);
        formPage.setNameField(name);
        formPage.setGender(gender);
        formPage.setCountry(country);
        formPage.submitForm();
        Thread.sleep(2000);

        ProdcutCatalogue prodcutCatalogue = new ProdcutCatalogue(driver); //create object for class
        prodcutCatalogue.addItemToCartByIndex(0);
        prodcutCatalogue.addItemToCartByIndex(0);
        CartPage cartPage = prodcutCatalogue.goToCartPage();


        double totalSum = cartPage.getProductsSum();
        double displayFormattedSum = cartPage.getTotalAmountDisiplayed();
        Assert.assertEquals(totalSum, displayFormattedSum);
        cartPage.acceptTermsConditons();
        cartPage.submitOrder();
        }

//        @BeforeMethod(alwaysRun=true)
//        public void preSetup() {
//        formPage.setActivity();
//        }

    @DataProvider
    public Object[][] getData() {



        return new Object[][] {{ "Stephen Penn", "female", "Argentina"}};
    }





    }

