package practice;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class testCalculatorForm {
    WebDriver driver;

    public testCalculatorForm(WebDriver driver){
        this.driver= driver;

    }

    //possitive usecase -verify with Possitive testdata
    public void calculatorAdditionVerification() throws IOException, InterruptedException {
        WebElement simpleFormDemo =driver.findElement(By.xpath("//li//a[text()='Simple Form Demo']"));
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
        WebElement simpleFormDemoLink= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li//a[text()='Simple Form Demo']")));

        simpleFormDemoLink.click();
        WebElement firstValueTextbox = driver.findElement(By.xpath("//input[@id='sum1']"));
        WebElement secondValueTextbox = driver.findElement(By.xpath("//input[@id='sum2']"));
        WebElement getSumButton = driver.findElement(By.xpath("//button[text()='Get Sum']"));



        firstValueTextbox.sendKeys("h");
        secondValueTextbox.sendKeys("k");
        getSumButton.click();
        WebElement value =  driver.findElement(By.xpath("//p[@id='addmessage']"));

        String actualValue = value.getText();
        String expectedValue= "16";
        if (actualValue.equals(expectedValue)){
            System.out.println("addition is working: testcase is passed");
        }
        else {
            highLightUsingJavaScript.drawBorder(value,driver);
            Thread.sleep(2000);
            screenSortUtility.takeScreenSort(driver,"additionfailure");
            System.out.println("addition is not working:testcase is failed");
            highLightUsingJavaScript.generateAlert(driver,"addition is not working properly");
            Thread.sleep(1000);
            Alert alert = driver.switchTo().alert();
            alert.accept();

        }
        driver.navigate().back();
        Thread.sleep(2000);

    }
    //negative usecase -Verify with negative testdata
    public void calculatorAdditionVerificationNegative() throws IOException {

        WebElement simpleFormDemo =driver.findElement(By.xpath("//li//a[text()='Simple Form Demo']"));
        simpleFormDemo.click();
        WebElement firstValueTextbox = driver.findElement(By.xpath("//input[@id='sum1']"));
        WebElement secondValueTextbox = driver.findElement(By.xpath("//input[@id='sum2']"));
        WebElement getSumButton = driver.findElement(By.xpath("//button[text()='Get Sum']"));

        firstValueTextbox.sendKeys("ljgd");
        secondValueTextbox.sendKeys("jwqr");
        getSumButton.click();
        WebElement value =  driver.findElement(By.xpath("//p[@id='addmessage']"));

        String actualMessage = value.getText();
        String expectedMessage = "Entered value is not a number";

        if(actualMessage.equals(expectedMessage)){
            System.out.println("it is showing correct error message:testcase is passed");
        }
        else {
            screenSortUtility.takeScreenSort(driver,"errorMessageFailur");
            System.out.println("it is showing incorrect error message:testcase is failed");
        }
      driver.navigate().back();
    }

    public void checkBoxTesting() throws InterruptedException {
        WebElement checkBoxDemo = driver.findElement(By.xpath("//li//a[text()='Checkbox Demo']"));
        highLightUsingJavaScript.clickJS(driver,checkBoxDemo);
        WebElement singleCheckBox = driver.findElement(By.xpath("//h2[contains(text(),'Single Checkbox')]/following-sibling::label/input"));
        singleCheckBox.click();

        //refreshing the page using javascript method
        highLightUsingJavaScript.refreshJavaScript(driver);

        //get the title of the page
      String title =  highLightUsingJavaScript.getTitleByJS(driver);
        System.out.println(title);

      // String page= highLightUsingJavaScript.getPageInnerText(driver);
       // System.out.println("page contain="+page);

        //to scroll down the page to button
        highLightUsingJavaScript.scrollDownJS(driver);

        WebElement option1 = driver.findElement(By.xpath("(//div[@class='mt-40']//h2[text()='Disabled Checkbox Demo']/following-sibling::div//label//input[@type='checkbox'])[1]"));
        highLightUsingJavaScript.scrollIntoView(driver,option1);
        highLightUsingJavaScript.clickJS(driver,option1);
        System.out.println("clicked sucessfully");
        highLightUsingJavaScript.scrollUp(driver);
        WebElement option3 = driver.findElement(By.xpath("//h2[text()='Disabled Checkbox Demo']/following-sibling::div//label[3]//input"));
        System.out.println(option3.isEnabled());
        Thread.sleep(2000);

        WebElement checkAllBtn = driver.findElement(By.xpath("//button[text()='Check All']"));
        checkAllBtn.click();

        WebElement option1MultipleCheckBOx = driver.findElement(By.xpath("//h2[text()='Multiple Checkbox Demo']/following-sibling::div//label[1]/input"));
        System.out.println(option1MultipleCheckBOx.isSelected());

        WebElement uncheckAllButton = driver.findElement(By.xpath("//button[text()='Uncheck All']"));
        System.out.println("uncheck all button status:"+ uncheckAllButton.isDisplayed());
        System.out.println("checked all button status:"+ checkAllBtn.isDisplayed());
        driver.navigate().back();
        Thread.sleep(1000);

    }







}
