package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumZadatak1 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.navigate().to("https://www.google.com");
        //driver.navigate().to("www.google.com");
        //Pogresan nacin unosa URL-a je bez 'https://
        //Zadatak 1
        //Otvoriti browser, otici na youtube, otici na google, povecati prozor, vratiti se nazad i odraditi refresh//



    }
}
