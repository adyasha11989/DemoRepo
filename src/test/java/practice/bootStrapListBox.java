package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class bootStrapListBox {
    public void bootStrapListBox() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.testmuai.com/selenium-playground/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement bootStrapListBox = driver.findElement(By.cssSelector(".container__selenium ul li:nth-child(5) a"));
        bootStrapListBox.click();

        WebElement searchBox1 = driver.findElement(By.xpath("(//div[@id='listhead']//input[@name='SearchDualList'])[1]"));
        searchBox1.click();
        //searchBox1.sendKeys("Myna");
        searchBox1.sendKeys("M");
        Thread.sleep(2000);
        searchBox1.sendKeys("y");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
        WebElement Mynamaki = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='list-group sp_list_group mb-20 mt-10']//li[text()='Mynamaki']")));
        Mynamaki.click();

        WebElement rightArrow = driver.findElement(By.xpath("(//div[@class='list-arrows w-2/12 text-center']//button[contains(@class,'block mx-auto border')])[2]"));
        rightArrow.click();
        WebElement MynamkiOn2ndList =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='list-group sp_list_group mb-20 mt-10']//li[@class='list-group-item active' and text()='Mynamaki']")));
        //verify it is added to the list or not
        String Actual = MynamkiOn2ndList.getText();
        String Expected= "Mynamaki";

        if (Actual.equals(Expected)){
            System.out.println("the value is added to the list sucessfully: testcase is passed");
        }
        else {
            System.out.println("the value is not added to the list sucessfully: testcase is failed");
        }

        driver.quit();
    }
}
