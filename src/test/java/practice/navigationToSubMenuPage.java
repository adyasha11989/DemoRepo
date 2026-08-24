package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.latest.network.model.DataReceived;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class navigationToSubMenuPage   {
    WebDriver driver;
    public navigationToSubMenuPage(WebDriver driver) throws FileNotFoundException {
        this.driver=driver;
  }

  public void navigationToSubMenuPage() throws IOException {
        WebElement bookaDemoButton = driver.findElement(By.xpath("(//button[text()='Book a Demo'])[1]"));
        highLightUsingJavaScript.highlightProcess(bookaDemoButton,driver);

        WebElement solution = driver.findElement(By.xpath("//header[@id='chfw-header']//button[text()='Solutions ']"));
        highLightUsingJavaScript.drawBorder(solution,driver);
        screenSortUtility.takeScreenSort(driver,"dashboard_solution");

  }

}
