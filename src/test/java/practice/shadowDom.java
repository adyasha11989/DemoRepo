package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class shadowDom {
    WebDriver driver;

    public shadowDom(WebDriver driver) {
        this.driver = driver;
    }
    public void shadowDom(){
        WebElement shadowDomPage = driver.findElement(By.xpath("//a[text()=' Shadow DOM']"));
    shadowDomPage.click();
    WebElement shadowHost = driver.findElement(By.xpath("//div[@class='w-6/12 smtablet:w-full']//shadow-signup-form"));
                SearchContext shadowRoot =  shadowHost.getShadowRoot();
          WebElement userName = shadowRoot.findElement(By.cssSelector("input[name='username']"));
          userName.sendKeys("User Name");






    }



}
