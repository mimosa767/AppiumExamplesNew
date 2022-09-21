package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends MobileBrowserBaseTest {

    @Test
    public void MobileBrowserTest() throws InterruptedException {

//        driver.get("http://google.com");
//        System.out.println(driver.getTitle());
//        driver.findElement(By.name("q")).sendKeys("Stephen Penn");
//        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
        driver.findElement(By.cssSelector("a[routerlink*='products']")).click();
        driver.executeScript("window.scrollBy(0, 1000)", ""); //scroll
        String text =  driver.findElement(By.cssSelector("a[href*='products/3']")).getText();
        Assert.assertEquals(text, "Devops");

        Thread.sleep(3000);


    }
}
