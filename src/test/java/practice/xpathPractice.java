package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
//xpath and iframe handling
public class xpathPractice {
    public void xpathPractic() throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.testmuai.com/selenium-playground/");
        driver.findElement(By.xpath("//a[text()='Ajax Form Submit']")).click();
        driver.navigate().back();
        driver.findElement(By.xpath("//button[contains(text(),'Demo') and contains(@class,'header')]")).click();
        driver.navigate().refresh();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//button[@id='embeddedMessagingConversationButton']")).click();
        driver.switchTo().frame("embeddedMessagingFrame");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(@id,'headerCloseButton')]")).click();
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[text()='iFrame Demo']")).click();
        Thread.sleep(5000);
        List<WebElement> iframe = driver.findElements(By.tagName("iframe"));
        System.out.println(iframe.size());
        int count  =1;
        for (WebElement frame :iframe){
            System.out.println(frame.getAttribute("id"));
            count++;
        }

        //iframe handling
        WebElement frame = driver.findElement(By.id("iFrame1"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//div//div[text()='Your content.' and @class ='rsw-ce']")).sendKeys("Hello Iframe");
        driver.switchTo().defaultContent();

        WebElement frame2 = driver.findElement(By.cssSelector("#iFrame2"));
        driver.switchTo().frame(frame2);
        //driver.findElement(By.cssSelector("div#__docusaurus  button[class='DocSearch DocSearch-Button']")).click();
        driver.findElement(By.xpath("//div[@id='__docusaurus']/descendant::button[@class='DocSearch DocSearch-Button']")).click();
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("#docsearch-input")).sendKeys("ai testing");
        Thread.sleep(2000);
      WebElement firstsr=  driver.findElement(By.xpath("(//ul[@id='docsearch-list']/child::li[contains(@id,'docsearch-item-')])[1]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",firstsr);
      driver.switchTo().defaultContent();
      driver.navigate().back();

    }

}
