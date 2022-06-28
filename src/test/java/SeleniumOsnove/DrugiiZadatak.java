package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static org.openqa.selenium.Keys.ENTER;

public class DrugiiZadatak {
    public static void main(String[] args) throws InterruptedException {

        //Zadatak 3
        //Otvoriti browser, otici na google, pretraziti "itbootcamp", otvoriti prvi link i asertovati URL//

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://google.com");

        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("itbootcamp");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[5]/center/input[1]")).sendKeys(ENTER);
        Thread.sleep(2000);
        String ocekivaniNaslov = "Kursevi";
        String dobijeniNaslov = driver.findElement(By.xpath("/html/body/div[7]/div/div[10]/div/div[2]/div[2]/div/div/div[1]/div/table/tbody/tr[1]/td/div/h3/a")).getText();

        String ocekivaniURL = "https://itbootcamp.rs/kursevi/";
        String dobijeniURL = driver.getCurrentUrl();


        Assert.assertEquals(dobijeniNaslov,ocekivaniNaslov);
        Assert.assertEquals(dobijeniURL,ocekivaniURL);


    }
}
