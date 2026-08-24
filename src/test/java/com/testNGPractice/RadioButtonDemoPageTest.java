package com.testNGPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class RadioButtonDemoPageTest extends BaseTest {
    @Test(groups ="regression")
    public void radioButtonValidation() throws InterruptedException {
        WebElement radioButtonDemoPage = driver.findElement(By.xpath("//a[text()='Radio Buttons Demo']"));
        radioButtonDemoPage.click();
        WebElement femaleRadioButton = driver.findElement(By.xpath("//input[@name='optradio' and @value='Female']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",femaleRadioButton);
        Thread.sleep(2000);

        WebElement getValueButton =driver.findElement(By.xpath("//button[@id='buttoncheck']"));
        js.executeScript("arguments[0].click()",getValueButton);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Female')]")));
        String actualSelectedValue = message.getText();
        String expectedValue = "Radio button 'Female' is checked";

        //use of soft Assertion

//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(actualSelectedValue,expectedValue,"the message is not showing correct");
//        System.out.println("Automation testing");
//        softAssert.assertTrue(femaleRadioButton.isSelected(),"the radio button selection is not working");
//        softAssert.assertTrue(message.isDisplayed(),"the radio button selection message is not showing ");
//        softAssert.assertAll();

        //use of Hard Assertion

        Assert.assertEquals(actualSelectedValue,expectedValue,"the message is not showing correct");
        System.out.println("Automation testing");
        Assert.assertTrue(femaleRadioButton.isSelected(),"radio button selection is not working");
        Assert.assertTrue(message.isDisplayed(),"the radio button selection message is not showing");
    }


    @Test
    public void radioButtonDisableCheck(){
        WebElement radioButtonDemoPage = driver.findElement(By.xpath("//a[text()='Radio Buttons Demo']"));
        radioButtonDemoPage.click();
        WebElement radioButton = driver.findElement(By.xpath("//input[@name='prop' and @value='RadioButton3']"));
        Assert.assertFalse(radioButton.isEnabled(),"radio Button is not disabled");

    }


     @Test(groups ="smoke")
    public void ageRadioButtonSelection() throws InterruptedException {
        WebElement radioButtonDemoPage = driver.findElement(By.xpath("//a[text()='Radio Buttons Demo']"));
        radioButtonDemoPage.click();
        WebElement radioButtonAge = driver.findElement(By.xpath("//input[@value='15 - 50']"));
        radioButtonAge.click();
        Thread.sleep(2000);

        WebElement getValuesButton = driver.findElement(By.xpath("//button[text()='Get values']"));
        getValuesButton.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement selectAge=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Age : ']/span")));
        String actualSelectedAge = selectAge.getText();
        String expectedAge ="15 - 50";

        AssertionHelper assertionHelper = new AssertionHelper();
        assertionHelper.softVerifyFalse(selectAge.isDisplayed(),"the selected Age value is not showing","the selected Age value is showing correctly");
        assertionHelper.softVerifyTrue(radioButtonAge.isSelected(),"the radio button is not selected","the radio button is selected");
        assertionHelper.softVerifyEqual(actualSelectedAge,expectedAge,"the age is not showing correct","the age is showing correct");
        assertionHelper.assertAll();

//        Assert.assertTrue(selectAge.isDisplayed(),"the selected Age value is not showing");
//        Assert.assertTrue(radioButtonAge.isSelected(),"the radioButtonAge is not selected");
//        Assert.assertEquals(actualSelectedAge,expectedAge,"it is not showing the selected age");

    }




}
