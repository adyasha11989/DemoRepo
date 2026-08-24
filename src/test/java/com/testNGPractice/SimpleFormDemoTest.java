package com.testNGPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.http.Message;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SimpleFormDemoTest extends BaseTest {

    @Test(groups ="smoke",dependsOnMethods = "radioButtonValidation")
    public void simpleFormDemo() throws InterruptedException {
        WebElement simpleFormDemoPage = driver.findElement(By.xpath("//a[text()='Simple Form Demo']"));
        simpleFormDemoPage.click();

        WebElement textBox = driver.findElement(By.cssSelector("input[id='user-message']"));
        textBox.sendKeys("testNG Learning");
        Thread.sleep(2000);

        WebElement getCheckedValue =driver.findElement(By.cssSelector("button[id='showInput']"));
        getCheckedValue.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        String actualMessage = message.getText();
        String expectedMessage ="testNG Learning";

        AssertionHelper helper = new AssertionHelper();
        helper.verifyTrue( message.isDisplayed(),"the message is not displayed","the message is displayed correctly");
        helper.verifyEqual(actualMessage,expectedMessage,"the message is not showing correct","the message is showing correct");

//        Assert.assertTrue(message.isDisplayed(),"the message is not displayed");
//        Assert.assertEquals(actualMessage,expectedMessage,"message is not showing correct");



    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testngExceptionCheck(){
        System.out.println(10/0);
    }




}
