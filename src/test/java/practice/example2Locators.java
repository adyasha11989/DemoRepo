package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class example2Locators {
    public void locator() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.testmuai.com/selenium-playground/");
        driver.findElement(By.linkText("Ajax Form Submit")).click();
        driver.manage().window().maximize();
        //id locator
        driver.findElement(By.id("title")).sendKeys("Shivi");
        // name locator
        WebElement description = driver.findElement(By.name("description"));
        //description.sendKeys("description");
        System.out.println(description.isDisplayed());
        System.out.println(description.isEnabled());
        System.out.println("execution end");

        List<WebElement> list = driver.findElements(By.name("description"));
        System.out.println(list.size());

        for (WebElement des : list) {
            if (des.isDisplayed()) {
                des.sendKeys("description");
                break;
            }

        }
        // linkText
        driver.findElement(By.linkText("Platform")).click();
        if (driver.getCurrentUrl().equals("https://www.testmuai.com/feature/")) {
            System.out.println("test case is passed for Platform");
        } else
            System.out.println("test case is fail");

        driver.navigate().back();
        //partial link text
        driver.findElement(By.partialLinkText("Get Started")).click();
        if (driver.getCurrentUrl().equals("https://www.testmuai.com/register/"))
            System.out.println("test case is passed for Get Started");
        driver.navigate().back();

       //css selector by using id
       driver.findElement(By.cssSelector("#btn-submit")).click();

        Thread.sleep(4000);
        WebElement text = driver.findElement(By.id("submit-control"));
        String actual = text.getText();
        System.out.println("actual text:"+actual);
        if (actual.equals("Form submitted Successfully!")){
            System.out.println("test case is passed - for submission");
        }
        else {
            System.out.println("test case is failed- for submission");
        }

        //css selector using class name
        driver.findElement(By.cssSelector(".chfw-header_demo_btn")).click();

        driver.navigate().refresh();


    }
}

