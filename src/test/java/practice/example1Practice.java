package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class example1Practice {
    WebDriver driver;
    public void lunchChromeDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.testmuai.com/selenium-playground/");
        driver.findElement(By.linkText("Ajax Form Submit")).click();
        driver.manage().window().maximize();
    }

    void lunchFirefoxDriver(){
        driver = new FirefoxDriver();
        driver.get("https://www.google.com/");
        System.out.println("Firefox browser open sucessfully");
        System.out.println(driver.getTitle()); //to get title

        if (driver.getTitle().equals("Google")){
            System.out.println("correct title");
        }
        else {
            System.out.println("incorrect title");
        }
        System.out.println(driver.getCurrentUrl()); // to get current url
        //System.out.println(driver.getPageSource()); //methods to get pageSource
        driver.quit();// to quit the browser

    }



}
