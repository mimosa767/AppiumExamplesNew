package ExtentReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators1 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./application/chromedriver105");
        WebDriver driver = new ChromeDriver();
        //global implicit wait for all elements up to 3 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("stephenalexanderpenn");
        Thread.sleep(1000);
        driver.findElement(By.name("inputPassword")).sendKeys("notthepassword");
        Thread.sleep(1000);
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(1000);
        //The Thread sleep is no longer needed after I put the global implicit wait above
        //Thread.sleep(3000);
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        Thread.sleep(1000);
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Stephen");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("penn@stephenpenn.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("penn@penngloballlc.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("678-662-0003");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//p[@class=\"infoMsg\"]")).getText());
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Penn");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[type*='Pass']")).sendKeys("rahulshettyacademy");
        Thread.sleep(1000);
        driver.findElement(By.id("chkboxOne")).click();
        Thread.sleep(1000);
        //driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
        driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();
        Thread.sleep(3000);


        driver.quit();

    }
}
