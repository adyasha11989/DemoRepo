package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.latest.network.model.DataReceived;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class browserInitiateUsingConfig {
   public WebDriver driver;

   public WebDriver initiateBrowser() throws IOException {
        Properties property = new Properties();
        FileInputStream input = new FileInputStream("C:\\Users\\adyashapanigrahi\\IdeaProjects\\Selenium\\AutomationLearning\\src\\main\\resources\\config.properties");
        property.load(input);
        String url = property.getProperty("url");
        String browser = property.getProperty("browser");

        if (browser.equals("chrome")){
            driver= new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.get(url);
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
            return driver;
        }
        else if (browser.equals("firefox")){
            driver = new FirefoxDriver();
            return driver;
        }
        else {
            driver= new EdgeDriver();
            return driver;
        }

    }

    public void closeBrowser(){
        driver.quit();
    }





}
