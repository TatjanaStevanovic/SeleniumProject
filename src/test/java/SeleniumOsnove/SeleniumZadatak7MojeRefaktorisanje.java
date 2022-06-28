package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SeleniumZadatak7MojeRefaktorisanje {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F");

        String username="tanjuska013";
        WebElement emailTextBox= driver.findElement(By.id("usernameOrEmail"));
        emailTextBox.sendKeys(username);

        WebElement continueButton = driver.findElement(By.cssSelector(".button.form-button.is-primary"));
        continueButton.click();

        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("password"))));

        WebElement passwordTextbox = driver.findElement(By.id("password"));
        passwordTextbox.sendKeys("Sombor2022NF");
        continueButton.click();

        String expectedURL="https://wordpress.com/read";
        wdwait.until(ExpectedConditions.urlToBe(expectedURL));

        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);

        WebElement profileButton = driver.findElement(By.cssSelector(".gravatar.masterbar__item-me-gravatar"));
        profileButton.click();


    }
}
