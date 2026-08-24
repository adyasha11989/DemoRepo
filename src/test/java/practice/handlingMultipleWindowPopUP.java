package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class handlingMultipleWindowPopUP {
    public void handlingMultipleWindowPopUp() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.testmuai.com/selenium-playground/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        WebElement windowPopUPModel = driver.findElement(By.xpath("//div[@class='container__selenium']//ul//li//a[text()='Window Popup Modal']"));
        windowPopUPModel.click();
        WebElement enterAnyUrl = driver.findElement(By.xpath("//div//input[@type='url' and @placeholder='e.g. www.google.com']"));
        enterAnyUrl.click();
        //usecase 1 - negative testing - on entering invalid input(url)
        enterAnyUrl.sendKeys("a");
        Thread.sleep(200);
        enterAnyUrl.sendKeys("b");
        Thread.sleep(200);
        enterAnyUrl.sendKeys("c");
        Thread.sleep(200);
        enterAnyUrl.sendKeys("d");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Open URL']/preceding-sibling::p[@class='text-red-10']")));
        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "Enter Valid URL";
        if (actualErrorMessage.equals(expectedErrorMessage)){
            System.out.println("invalid input usecase is working:testcase is passed");
        }
        else {
            System.out.println("invalid input usecase is not working:testcase is failed");
        }

        //usecase2 possitive testing - on entering valid url
        enterAnyUrl.clear();
        enterAnyUrl.sendKeys("https://www.facebook.com/");
        WebElement openUrlButton = driver.findElement(By.xpath("//a[text()='Open URL']"));
         openUrlButton.click();
         Set<String> handle=driver.getWindowHandles();
        System.out.println("Numbers of window presents:"+ handle.size());
                    Iterator<String> itr=handle.iterator();
                     String parent = itr.next();
                     String child =itr.next();
        System.out.println("parent id:"+ parent);
        System.out.println("child id:"+ child);
        driver.switchTo().window(child);
        driver.manage().window().maximize();
        String actualChildUrl=driver.getCurrentUrl();
        String expectedChildUrl="https://www.facebook.com/";
        if (actualChildUrl.equals(expectedChildUrl)){
            System.out.println("child window navigation is working fine:testcase is passed");
        }
        else {
            System.out.println("child window navigation is not working fine: testcase is failed");
        }
        driver.close();
        driver.switchTo().window(parent);
        Thread.sleep(2000);
        driver.close();
    }
}
