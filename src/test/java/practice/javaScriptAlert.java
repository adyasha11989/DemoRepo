package practice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class javaScriptAlert {
    public void javaScriptAlert() throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.testmuai.com/selenium-playground/");
       // WebElement JavaScriptAlert = driver.findElement(By.cssSelector(".pt-10 a[href*='/javascript-alert-box-demo']"));
        WebElement clickmeAlt = driver.findElement(By.xpath("//li[@class='pt-10']//a[contains(text(),'Javascript Alerts')]"));
        clickmeAlt.click();

     WebElement jsclickme=   driver.findElement(By.xpath("//p[contains(text(),'JavaScript Alerts')]//button[contains(text(),'Click Me')]"));
        System.out.println(jsclickme.isDisplayed());
        System.out.println(jsclickme.isEnabled());
        Thread.sleep(4000);
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",jsclickme);
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
     String textclickme = alert.getText();
       System.out.println(textclickme);
       alert.accept();
       Thread.sleep(2000);

       driver.findElement(By.xpath("//p[text()='Confirm box:']/button[text()='Click Me']")).click();
       Alert alert2 = driver.switchTo().alert();
       String textmessage_alert2= alert2.getText();
        System.out.println(textmessage_alert2);
        alert2.dismiss();

       String Actual= driver.findElement(By.xpath("//div[@class='ml-10 py-20']/p[@id='confirm-demo']")).getText();
     if(Actual.equals("You pressed Cancel!")){
         System.out.println("alert dismiss is working- test case is passed");
     }
     else {
         System.out.println("alert is not working");
     }

      Thread.sleep(3000);
     driver.findElement(By.xpath("//p[text()='Prompt box:']//button[text()='Click Me']")).click();
     Thread.sleep(2000);
     Alert alert3 = driver.switchTo().alert();
        System.out.println(alert3.getText());
     alert3.sendKeys("Shiv");
     alert3.accept();

     String Actualtext2 = driver.findElement(By.xpath("//p[@id='prompt-demo']")).getText();
     if (Actualtext2.equals("You have entered 'Shiv' !")){
         System.out.println("test case pass: pop up recieve the text sucessfully");
     }
     else {
         System.out.println("test case is fail");
     }
    }
    void fileUpload() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.testmuai.com/selenium-playground/");
        WebElement fileUploadPage= driver.findElement(By.cssSelector("div ul[class^='list-disc'] li:nth-child(42) a"));
        fileUploadPage.click();
        WebElement chooseFileButton = driver.findElement(By.xpath("//div[@class='mt-30 rounded']//div/input[@id='file']"));
        Thread.sleep(2000);
        chooseFileButton.sendKeys("C:\\Users\\adyashapanigrahi\\OneDrive - Nagarro\\Desktop\\Module placement\\NEW TEXT 2\\a-f.pdf");
        String Actual = driver.findElement(By.cssSelector(" #file~#error")).getText();
        String Expected ="File Successfully Uploaded";
        if(Actual.equals(Expected)){
            System.out.println("File uploaded sucessfully: test case is passed");
        }
        else {
            System.out.println("File upload fail: test case is fail");
        }
    }



}
