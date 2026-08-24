package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class fileUpload {
    WebDriver driver;

    public fileUpload(WebDriver driver) {
        this.driver = driver;
    }

    public void fileUpload() throws InterruptedException {
        WebElement uploadFileDemo =driver.findElement(By.xpath("//a[text()='Upload File Demo']"));
        uploadFileDemo.click();

        WebElement chooseFile = driver.findElement(By.xpath("//input[@id='file']"));
        chooseFile.sendKeys("C:\\Users\\adyashapanigrahi\\Downloads\\Test Net AJ08 8,000 devices__LotQuote_WithZone__08042026.pdf");
       driver.navigate().back();
       Thread.sleep(1000);

    }

    public void fileDownload() throws InterruptedException {
        WebElement downloadFileDemoPage = driver.findElement(By.xpath("//a[text()='File Download']"));
        downloadFileDemoPage.click();
        WebElement textArea = driver.findElement(By.xpath("//textarea[@id='textbox']"));
        textArea.sendKeys("file download");
        WebElement generateButton = driver.findElement(By.xpath("//button[@id='create']"));
        generateButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement downloadButton =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Download']")));
        downloadButton.click();
        driver.navigate().back();
        Thread.sleep(1000);
    }

}
