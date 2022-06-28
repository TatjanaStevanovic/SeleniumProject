package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumZadatak8 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F");

        Cookie kolacic = new Cookie("wordpress_logged_in","tanjuska013%7C1749071090%7C8nOsBYyioBSpJvSZ6Yg4wE7Z8Dd96oy9KayWWTU4VbN%7C6ab8f408e567ad604a03ec38e39989e13a71285e762495fb8a29eb55ca7b4fd0");
        driver.manage().addCookie(kolacic);
        driver.navigate().refresh();

        WebElement continueButton = driver.findElement(By.cssSelector(".button.is-primary"));
        continueButton.click();
    }
}





