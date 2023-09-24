package Alpeeva_HW08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Alpeeva_HW08 {
    private WebDriver driver;

    @BeforeClass
    public void startSite() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @Test
    public void Test_1() throws InterruptedException {
        this.driver.get("https://www.google.com/?hl=en-US");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Accept all']"))).click();

        driver.findElement(By.name("q")).sendKeys("hillel it school");
        driver.findElement(By.name("btnK")).click();
        Thread.sleep(3000);

        List<WebElement> elements = driver.findElements(By.xpath("//a/h3"));
        for(int i=0; i< elements.size(); i++) {
            WebElement element = elements.get(i);
            if(i == 0) {
                Assert.assertEquals(element.getText(), "Hillel IT School", "Error");
            }
            else {
                System.out.println(element.getText());
            }
        }
    }

    @Test
    public void Test_2() throws InterruptedException {
        this.driver.get("https://www.google.com/?hl=en-US");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Accept all']"))).click();

        driver.findElement(By.name("q")).sendKeys("Linkedin test");
        driver.findElement(By.name("btnK")).click();

        Thread.sleep(3000);

        List<WebElement> elements = driver.findElements(By.xpath("//a/h3"));
        for(int i=0; i< elements.size(); i++) {
            WebElement element = elements.get(i);
            if(i == 0) {
                Assert.assertEquals(element.getText(), "Linkedin test", "Error");
            }
            else {
                System.out.println(element.getText());
            }
        }
    }

    @AfterClass
    public void quitChrome() {
        driver.close();
    }
}
