package Package2;

import TestUtils.iOSBaseTest;
import org.testng.annotations.Test;

public class IOSBasics extends iOSBaseTest {

    @Test
    public void IOSBasicsTest() {

            //Xpath, classname, IOS, accessibility id, iosClassChain, IOSPredicateString, id

        homePage.selectAlertViews();
        alertViews.selectTextEntry();
        alertViews.setMessageField();
        alertViews.setOkButton();
        alertViews.setConfirmPopUp();
        String text = alertViews.getMessage();
        System.out.println(text);
        alertViews.setConfirmButton();


    }
}
