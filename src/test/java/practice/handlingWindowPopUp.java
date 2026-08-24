package practice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class handlingWindowPopUp {
    public void handlingWindowPopUp(){
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.testmuai.com/selenium-playground/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       //navigating to the windowPopUpModel Page
        WebElement windowPopUpModal = driver.findElement(By.cssSelector(".container__selenium ul li:last-child a"));
        windowPopUpModal.click();

        //clicking on the follow On Twitter Button
        WebElement followOnTwitterButton =driver.findElement(By.xpath("//div[@class='mt-30 rounded flex justify-between smtablet:block']//a[text()='Follow On Twitter']"));
        //followOnTwitterButton.click();
       Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(followOnTwitterButton).keyUp(Keys.CONTROL).perform();
            Set<String> handler =  driver.getWindowHandles();
            //This confirms howmay windows are open
        System.out.println("numbers of window present:"+ handler.size());
               Iterator<String> itr=   handler.iterator();
                String parent = itr.next();
                String child= itr.next();
        System.out.println("Parent id:"+parent);
        System.out.println("Child id:"+child);

        driver.switchTo().window(child);
        String actualUrlChild =driver.getCurrentUrl();
        String expectedUrlChild="https://x.com/testmuai";
        if(actualUrlChild.equals(expectedUrlChild)){
            System.out.println("sucessfully switch to child window:testcase is passed");
        }
        else {
            System.out.println("not switch to child winddow:testcase is failed");
        }
        //child window
        WebElement searchButton = driver.findElement(By.xpath("//div[@class='bg-background/80 sticky top-0 z-20 h-[53px] items-center gap-3 px-2 backdrop-blur-md sm:flex hidden']//button[@type='button' and @aria-label='Search']"));
        searchButton.click();
        //checking the continueWithPhoneNumber button is clickable or not after clicking on search button
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
        WebElement continueWithPhoneNumber = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='jf-element text-text j8ug26k0 j-4t3tug12 j-53n1bs11']//p[text()='Continue with phone']")));
        //clicking on the continueWithPhoneNumber button
        continueWithPhoneNumber.click();
        //locating the phoneNumber filed and entering value
        WebElement phoneNumber = driver.findElement(By.xpath("//input[@id='jf-phone-input-phone']"));
        phoneNumber.sendKeys("6370912536");
        //locating the continueButton and clicking on the continue button
        WebElement continueButton = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        continueButton.click();
        //Verify the errorMessage is generating or not on entering invaild value and clicking on continue
        WebElement errorMessage =driver.findElement(By.xpath("//div[@class='jf-element text-text j-ppdyxm0 j-a8kd9c0 jn03q290 j-azowe50 jj43p6917']//p[text()='Please enter a valid value']"));
        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "Please enter a valid value";
        if(actualErrorMessage.equals(expectedErrorMessage)){
            System.out.println("it is showing proper error message incase of invalid entery:testcase is passed");
        }
        else {
            System.out.println("it is not showing proper error message incase of invalid entery:testcase is failed");
        }
        //closing the child browser
        driver.close();
        //switching to parent window
        driver.switchTo().window(parent);
        //Verifying the contorl is no the parent window or not
        String actualParentUrl = driver.getCurrentUrl();
        String ExpectedparentUrl= "https://www.testmuai.com/selenium-playground/window-popup-modal-demo/";
        if(actualParentUrl.equals(ExpectedparentUrl)){
            System.out.println("it is showing the parent url:testcase is passed");
        }
        else {
            System.out.println("it is not showing the parent url:testcase is failed");
        }
            //closing the parent window
      driver.quit();




    }
}
