package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class differentWaits {
    public void differentWaits(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.testmuai.com/selenium-playground/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //pageload wait- wait for page loading time
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        //implicitly wait - applicable for all the webelements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement solutions = driver.findElement(By.xpath("//header[@id='chfw-header']//button[text()='Solutions ']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(solutions).pause(Duration.ofMillis(200)).perform();
        //Explicit wait for locating the Responsive testing option
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
        WebElement responsive_Testing = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='chfw-menu-item']//a//div//p[text()='Responsive Testing']")));
        responsive_Testing.click();

        //Verify the navigation is working or not
       String responsivePageUrl= driver.getCurrentUrl();
       String expectedUrl ="https://www.testmuai.com/responsive-test-online/";
       if (responsivePageUrl.equals(expectedUrl)){
           System.out.println("correct url:testcase is passed");
       }
       else {
           System.out.println("wrong url:testcase is fail");
       }
       driver.navigate().back();
       driver.quit();



    }
}
