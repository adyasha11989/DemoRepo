package com.testNGPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class BaseTest {

    protected WebDriver driver;


    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void browserLunch(@Optional("") String browser) throws IOException {
        FileInputStream input =new FileInputStream("C:\\Users\\adyashapanigrahi\\IdeaProjects\\Selenium\\AutomationLearning\\src\\main\\resources\\config.properties");
        Properties properties =new Properties();
        properties.load(input);

        String url =properties.getProperty("url");

        if (browser.isEmpty()){
            browser =properties.getProperty("browser");
        }

        if(browser.equals("chrome")){

            driver=new ChromeDriver();
        }
        else if (browser.equals("FireFox")){
            driver=new FirefoxDriver();

        }
        else   {
            driver=new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));



    }


    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();

    }



}
