package com.testNGPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

@Listeners(TestListener.class)
public class AjaxFormSubmit extends BaseTest {
    //adding comment for the new push demo

    @Test(dataProvider = "ajaxFormSubmit", dataProviderClass =TestDataProvider.class )
    public void ajaxFormSubmit(String Name, String Message) throws InterruptedException {
        WebElement ajaxFormSubmitPage = driver.findElement(By.xpath("//a[text()='Ajax Form Submit']"));
        ajaxFormSubmitPage.click();

        WebElement inputName = driver.findElement(By.cssSelector("input#title"));
        inputName.sendKeys(Name);

        WebElement message = driver.findElement(By.cssSelector("textarea[name='description']"));
        message.sendKeys(Message);
        WebElement submitButton = driver.findElement(By.xpath("//input[@id='btn-submit']"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click()",submitButton);
        submitButton.click();

        Thread.sleep(1000);
        submitButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[contains(text(),'Ajax Request is Processing!')]")));
        WebElement sucessMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#submit-control")));
        String actualSucessMessage =  sucessMessage.getText();
        String expectedSucessMessage ="Form submitted Successfully!";

        AssertionHelper helper = new AssertionHelper();
        helper.softVerifyEqual(actualSucessMessage,expectedSucessMessage,"the form submission is not working.","the form submission is working.");
        helper.assertAll();


    }

}
