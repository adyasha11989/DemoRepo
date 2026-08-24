package com.testNGPractice;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.swing.table.AbstractTableModel;
import java.security.SecureRandom;
import java.time.Duration;


@Listeners(TestListener.class)
public class BootStrapModelsTest extends BaseTest {

    @Test(description = "Verification of the auto close Message")
    public void autoCloseMessage() throws InterruptedException {
        WebElement bootStrapAlertPage = driver.findElement(By.xpath("//a[text()='Bootstrap Alerts']"));
     bootStrapAlertPage.click();
        Thread.sleep(2000);

        WebElement autoCloseSuccessMessage = driver.findElement(By.xpath("//button[contains(text(),'Autoclosable Success')]"));
        autoCloseSuccessMessage.click();

     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
     WebElement message= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Autocloseable success message. Hide in 5 seconds.']")));
      String actualText = message.getText();
      String expectedText ="Autocloseable success message. Hide in 5 seconds.";
        System.out.println(actualText);
        AssertionHelper helper = new AssertionHelper();
        helper.softVerifyEqual(actualText,expectedText,"the sucess message is not showing.","the sucess message is showing");
        Boolean isInvisiableMessage = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[text()='Autocloseable success message. Hide in 5 seconds.']")));
        helper.softVerifyTrue(isInvisiableMessage,"message is still visible","message is not visible");
        helper.assertAll();

    }

@Test
public void normalSucessMessage() throws InterruptedException {
        WebElement bootStrapAlertPage = driver.findElement(By.xpath("//a[text()='Bootstrap Alerts']"));
        bootStrapAlertPage.click();
        Thread.sleep(2000);
     WebElement normalsucessMessage = driver.findElement(By.xpath("//button[text()='Normal Success Message']"));
     normalsucessMessage.click();

     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
     WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Normal success message. To close use the close button.']")));
     String actualMessage = message.getText();
     String expectedMessage ="Normal success message.To close use the close button.";

     AssertionHelper helper = new AssertionHelper();
     helper.verifyEqual(actualMessage,expectedMessage,"sucess message is not showing","sucess message is showing");
    }

@Test
    public void autoloseInfoMessage() throws InterruptedException {
        WebElement bootStrapAlertPage = driver.findElement(By.xpath("//a[text()='Bootstrap Alerts']"));
        bootStrapAlertPage.click();
        Thread.sleep(2000);

        WebElement autoClosableInfoButton = driver.findElement(By.xpath("//button[text()='Autoclosable Info Message']"));
        autoClosableInfoButton.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
         WebElement infoMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Autocloseable info message. Hide in 5 seconds.']")));
         String actualMessage = infoMessage.getText();
          String expectedMessage="Autocloseable info message. Hide in 5 seconds.";

          AssertionHelper helper = new AssertionHelper();
          helper.softVerifyEqual(actualMessage,expectedMessage,"message is not showing correct","message is showing correct");

          WebElement normalInfoMessageButton = driver.findElement(By.xpath("//button[text()='Normal Info Message']"));
          normalInfoMessageButton.click();
           WebElement normaInfoMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Normal info message.To close use the close button.']")));
           String actualInfoMessage = normaInfoMessage.getText();
           String expectedInfoMessage ="Normal info message.To close use the close button.";
           helper.softVerifyEqual(actualInfoMessage,expectedInfoMessage,"messege is not showing correct.","message is showing correct");
           helper.assertAll();



    }





}
