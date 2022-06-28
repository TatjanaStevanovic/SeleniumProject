package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class TreciZadatak {
    public static void main(String[] args) throws InterruptedException {
        //Zadatak 1
        //Pokrenuti browser, otici na google, otvoriti jos 2 taba, u drugom otici na youtube,
        // u trecem otici na linkedin. Nakon toga zatvoriti sve tabove posebno.//

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        String google="https://www.google.com";
        driver.navigate().to(google);
        String youtube = "https://www.youtube.com";
        String linkedin="https://www.linkedin.com";

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        js.executeScript("window.open()");



        ArrayList<String> listaTabova = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(1));
        driver.navigate().to(youtube);
        driver.close();

        driver.switchTo().window(listaTabova.get(2));
        driver.navigate().to(linkedin);
        driver.close();


        Thread.sleep(5000);
        //Eksplicitni wait

        WebElement button = driver.findElement(By.cssSelector(".btn.primary"));

        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wdwait.until(ExpectedConditions.elementToBeClickable(button));
        //Implicitni wait

        button.click();


    }
}
