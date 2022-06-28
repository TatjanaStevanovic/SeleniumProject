package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumZadatak {
    WebDriver driver;
    WebDriverWait wdwait;


    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        wdwait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @BeforeMethod
    public void pageSetUp(){
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");

    }
    @Test
    public void test1() throws InterruptedException{

        WebElement practiceButton=driver.findElement(By.id("menu-item-20"));
        practiceButton.click();
        Thread.sleep(2000);

        WebElement loginPageButton=driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[2]/div[1]/div[1]/p/a"));
        loginPageButton.click();

        WebElement usernameButton= driver.findElement(By.id("username"));
        WebElement passwordButton= driver.findElement(By.id("password"));

        usernameButton.sendKeys("student");
        passwordButton.sendKeys("Password123");

        WebElement submitButton=driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement heading=driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[1]/h1"));
        Assert.assertEquals(heading.getText(),"Logged In Successfully");
        Assert.assertEquals(driver.getCurrentUrl(),"https://practicetestautomation.com/logged-in-successfully/");



    }


}
