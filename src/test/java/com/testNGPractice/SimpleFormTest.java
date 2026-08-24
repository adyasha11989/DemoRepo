package com.testNGPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

@Listeners(TestListener.class)
public class SimpleFormTest extends BaseTest {

    @Test(dataProvider = "simpleForm", dataProviderClass = TestDataProvider.class)
    public void simpleFormTest(SimpleFormTestData data) throws InterruptedException {
        WebElement simpleFormDemoPage = driver.findElement(By.xpath("//a[text()='Simple Form Demo']"));
        simpleFormDemoPage.click();

        WebElement enterMessege =driver.findElement(By.xpath("//input[@id='user-message']"));
        enterMessege.sendKeys(data.messege);

        WebElement getCheckedValueButton =driver.findElement(By.xpath("//button[@id='showInput']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",getCheckedValueButton);
        Thread.sleep(1000);
        getCheckedValueButton.click();

      //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement yourMessage = driver.findElement(By.xpath("//p[@id='message']"));


       String actualYourMessege = yourMessage.getText();
       String expectedMessege = data.messege;
       //validation
       AssertionHelper helper = new AssertionHelper();
       helper.softVerifyEqual(actualYourMessege,expectedMessege,"the entered text is not showing correct","the entered text is showing correct");

      WebElement enterFirstValueField =driver.findElement(By.xpath("//input[@id='sum1']"));
      enterFirstValueField.sendKeys(String.valueOf(data.firstValue));
      WebElement enterSecondValueField = driver.findElement(By.xpath("//input[@id='sum2']"));
      enterSecondValueField.sendKeys(String.valueOf(data.secondValue));
      WebElement getSumButton =driver.findElement(By.xpath("//button[text()='Get Sum']"));
      getSumButton.click();
      Thread.sleep(1000);
      getSumButton.click();
      WebElement sumResult =driver.findElement(By.xpath("//p[@id='addmessage']"));
      String actualSumResult = sumResult.getText();
      //expected value-
        int value1 = data.firstValue;
        int value2 = data.secondValue;
        int sum = value1+value2;
        String expectedSumResult = String.valueOf(sum);

        //validation
        helper.softVerifyEqual(actualSumResult,expectedSumResult,"the addition is not working","the addition is working");
       helper.assertAll();
    }




}
