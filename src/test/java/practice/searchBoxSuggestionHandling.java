package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class searchBoxSuggestionHandling {
    WebDriver driver;
  public void searchBoxSuggestionHandling(){
      driver= new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().deleteAllCookies();
      driver.get("https://www.amazon.in/");
      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
      WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
      searchBox.sendKeys("iphone");

      List<WebElement> suggesationList = driver.findElements(By.xpath("//div[contains(@id,'sac-suggestion-row')]/div[@role='button']"));
       int suggestionSize = suggesationList.size();
      System.out.println(suggestionSize);
      for (int i =0; i<suggestionSize; i++){
          WebElement option= driver.findElements(By.xpath("//div[contains(@id,'sac-suggestion-row')]/div[@role='button']")).get(i);
          String text = option.getAttribute("aria-label");
          if (text.contains("17 pro max")){
              option.click();
              break;
          }
      }

  }
}
