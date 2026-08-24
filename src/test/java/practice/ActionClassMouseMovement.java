package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionClassMouseMovement {
    public void hoverElement() throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.testmuai.com/selenium-playground/");
        //usecase 1- for platform
        WebElement platform = driver.findElement(By.xpath("//div[@class='chfw-resource-dropdown']/a[text()='Platform ']"));
        Actions action = new Actions(driver);
        action.moveToElement(platform).pause(Duration.ofMillis(400)).perform();

        WebElement agentTesting= driver.findElement(By.xpath("//ul[@class='chfw-header_inner chfw-header-icon chfw-menu-list']//a[@href='https://www.testmuai.com/agent-testing/']"));

        //System.out.println(agentTesting.isDisplayed());
        agentTesting.click();
        String agentTesting_Url= driver.getCurrentUrl();
        if (agentTesting_Url.equals("https://www.testmuai.com/agent-testing/")){
            System.out.println("hover function is working: test case is passed");
        }
        else {
            System.out.println("hover function is not working:test case is failed");
        }
        //navigate back to home page
        driver.navigate().back();

        //usecase 2 - for Resources
        WebElement resource_btn = driver.findElement(By.xpath("//div[@class='chfw-resource-dropdown']/button[text()='Resources ']"));
        action.moveToElement(resource_btn).pause(Duration.ofMillis(400)).perform();
        WebElement integration = driver.findElement(By.xpath("//p[@class='chfw-h3 chfw-menu-title' and text()='Integrations']"));
        integration.click();
       String actualtitle= driver.getTitle();
        String expectedTitle_integration = "Plugins and Integrations For Seamless Browser Compatibility Testing | TestMu AI (Formerly LambdaTest)";

        if (actualtitle.equals(expectedTitle_integration)){
            System.out.println("it is showing correct page:testcase is passed");
        }
        else {
            System.out.println("it is showing wrong page:testcase is failed");
        }
        driver.quit();

    }
}
