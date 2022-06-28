package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SeleniumZadatak7 {

    public static void main(String[] args) throws InterruptedException {

        //Zadatak 1 - Napraviti automatski test koji ce se ulogovati na wordpress i proveriti da li je korisnik ulogovan


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F");

        String username="tanjuska013";
        WebElement emailTextBox=driver.findElement(By.xpath("//*[@id=\"usernameOrEmail\"]"));
        emailTextBox.sendKeys(username);

        WebElement continueButton =driver.findElement(By.xpath("//*[@id=\"primary\"]/div/main/div/div/form/div[1]/div[2]/button"));
        continueButton.click();
        Thread.sleep(2000);

        WebElement passwordTextBox= driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordTextBox.sendKeys("Sombor2022NF");

        WebElement loginButton= driver.findElement(By.xpath("//*[@id=\"primary\"]/div/main/div/div/form/div[1]/div[2]/button"));
        loginButton.click();
        Thread.sleep(5000);

        String expectedURL="https://wordpress.com/read";
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);

        WebElement profileButton=driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/a[1]/span/img"));
        profileButton.click();
        Thread.sleep(2000);

        WebElement logOutButton= driver.findElement(By.xpath("//*[@id=\"secondary\"]/ul/li[1]/div[2]/button/span"));
        Assert.assertTrue(logOutButton.isDisplayed());


        String actualUsername = driver.findElement(By.xpath("//*[@id=\"secondary\"]/ul/li[1]/div[1]/h2")).getText();
        Assert.assertEquals(actualUsername,username);














}
}
