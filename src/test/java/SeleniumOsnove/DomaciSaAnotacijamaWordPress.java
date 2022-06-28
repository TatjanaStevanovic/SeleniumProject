package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.time.Instant;

public class DomaciSaAnotacijamaWordPress {

    WebDriver driver;
    private Instant wdwait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.navigate().to("https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F");

    }

    @Test
    public void test1() throws InterruptedException {
        String username = "tanjuska013";

        WebElement emailTextBox = driver.findElement(By.id("usernameOrEmail"));
        emailTextBox.sendKeys(username);
        WebElement continueButton = driver.findElement(By.cssSelector(".button.form-button.is-primary"));
        continueButton.click();
        Thread.sleep(2000);

        WebElement passwordTextbox = driver.findElement(By.id("password"));
        passwordTextbox.sendKeys("Sombor2022NF");
        continueButton.click();
    }
    @Test
    public void test2() throws InterruptedException {

        WebElement profileButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/a[1]/span/img"));
        profileButton.click();
        Thread.sleep(2000);


        WebElement logOutButton = driver.findElement(By.xpath("//*[@id=\"secondary\"]/ul/li[1]/div[2]/button/span"));
        Assert.assertTrue(logOutButton.isDisplayed());
    }

    @AfterMethod
    public void removeCookies() {
        driver.manage().deleteAllCookies();
    }


    @AfterClass

    public void tearDown() {
        driver.close();
        driver.quit();


    }
}