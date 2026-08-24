package com.testNGPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.security.PublicKey;
import java.time.Duration;

@Listeners(TestListener.class)
public class inputFormSubmit extends BaseTest {

    @Test(dataProvider = "testDataForm", dataProviderClass = TestDataProvider.class, description = "input form submission validaiton with multiple testdata")
    public void inputFormSumbittionValidation(String nameValue,String emailValue,String passwordValue,String companyValue,String webSiteValue,String countryValue,String cityValue,String address1Value, String address2Value,String stateValue, String zipcodeValue){
        WebElement inputFormSubmitPage = driver.findElement(By.xpath("//a[text()='Input Form Submit']"));
        inputFormSubmitPage.click();

        WebElement name = driver.findElement(By.cssSelector("input[name='name']"));
        name.sendKeys(nameValue);

        WebElement email = driver.findElement(By.cssSelector("input[id='inputEmail4']"));
        email.sendKeys(emailValue);

        WebElement password = driver.findElement(By.cssSelector("input[id='inputPassword4']"));
        password.sendKeys(passwordValue);

        WebElement company = driver.findElement(By.cssSelector("input[id='company']"));
        company.sendKeys(companyValue);

        WebElement webSite = driver.findElement(By.cssSelector("input[id='websitename']"));
        webSite.sendKeys(webSiteValue);

        WebElement country = driver.findElement(By.cssSelector("[name='country']"));
        Select select = new Select(country);
        select.selectByVisibleText(countryValue);

        WebElement city = driver.findElement(By.cssSelector("[id='inputCity']"));
        city.sendKeys(cityValue);

        WebElement address1 = driver.findElement(By.cssSelector("[id='inputAddress1']"));
        address1.sendKeys(address1Value);

        WebElement address2 = driver.findElement(By.cssSelector("[id='inputAddress2']"));
        address2.sendKeys(address2Value);

        WebElement state = driver.findElement(By.cssSelector("[id='inputState']"));
        state.sendKeys(stateValue);

        WebElement zipCode = driver.findElement(By.cssSelector("[id='inputZip']"));
        zipCode.sendKeys(zipcodeValue);

        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement formSubmittionMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Thanks for contacting us')]")));
        String actualSubmissionMessage = formSubmittionMessage.getText();
        String expectedSubmissionMessage = "Thanks for contacting us, we will get back to you shortly.";
        AssertionHelper helper = new AssertionHelper();

        helper.verifyEqual(actualSubmissionMessage,expectedSubmissionMessage,"the form submission is not working properly","the form submission is working properly");
    }

}
