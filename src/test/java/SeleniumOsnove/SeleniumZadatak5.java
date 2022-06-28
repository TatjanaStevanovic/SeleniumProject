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

public class SeleniumZadatak5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String youtube = "https://www.ctshop.rs/";
        driver.navigate().to(youtube);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement element = driver.findElement(By.xpath("/html/body/footer/div/section/div/div/div[2]/div[1]"));

        js.executeScript("arguments[0].scrollIntoView(true);", element);


        //Lokatori
        //Sinonim je Selektor
        //Po prioritetu lokatore treba gledati po:
        //ID - najstabilniji i jedinstven
        //Name
        //Class
        //CssSelector
        //Relative Xpath
        //Absolute Xpath

        WebElement idElement = driver.findElement(By.id("sharkskin-header-search-collapse"));
        WebElement nameElement = driver.findElement(By.name("google_esf"));
        WebElement classElement = driver.findElement(By.className("col-md-12"));
        WebElement cssElement = driver.findElement(By.cssSelector(".adsbygoogle.adsbygoogle-noablate"));
        WebElement elementXpathFull = driver.findElement(By.xpath("/html/body/footer/div/section/div"));
        WebElement elementXpathPartial = driver.findElement(By.xpath("//div/section/div"));

        String URL = "https://gigatron.rs/";
        driver.navigate().to(URL);

        Thread.sleep(5000);
        //Eksplicitni wait
        //Program ce cekati koliko mu mi zadamo sekundi (sta god da se desi cekace toliko)
        //Koristi se dok se PRAVI test
        //Kada vidimo da smo zavrsili test onda prebacujemo thread sleep u web driver wait

        WebElement button = driver.findElement(By.cssSelector(".btn.primary"));

        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wdwait.until(ExpectedConditions.elementToBeClickable(button));
        //Implicitni wait
        //Program ce cekati dok se ne ispuni zadat uslov (u ovom slucaju da dugme postane klikabilno)
        //i cekace najvise 10 sekundi, jer smo toliko zadali u objektu da ce najduze da se ceka
        //Ako program ne pronadje taj element, cekace 10 sekundi (koliko je maksimalno) i na kraju ce puci
        //Najcesci implicitni waiteri su elementToBeClickable i visibilityOf
        //prvi je da se ceka da element postane klikabilan
        //drugi je da se ceka da se element prikaze

        //Implicitni wait moze da skrati dosta vremena u testiranju
        //Primera radi: ako imamo 10 testova, u svakom testu imamo po 5 thread sleep-ova sa 2 sekunde
        //to znaci da cemo za tih 10 testova ukupno cekati 100 sekundi
        //ako koristimo implicit wait, to vreme cekanja moze da se smanji na ukupno 20 sekundi cekanja
        //Zakljucak: sto vise testova imamo to cemo vise vremena da ustedimo ako koristimo implicit wait

        button.click();


    }


    }






