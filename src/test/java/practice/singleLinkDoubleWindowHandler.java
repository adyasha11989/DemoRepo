package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class singleLinkDoubleWindowHandler {
    public void singleLinkDoubleWindowHandler() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.testmuai.com/selenium-playground/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
       //navagating to the window pop up model page
        WebElement windowPopUPModel = driver.findElement(By.xpath("//div[@class='container__selenium']//ul//li//a[text()='Window Popup Modal']"));
        windowPopUPModel.click();
        //scrolling the page
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,440)");
        //waiting till the followTwitterAndFaceBook button to be visible after the scrolling
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement followTwitterAndFaceBook = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='mt-30 rounded']//a[text()='Follow Twitter & Facebook']")));
        //clicking on the followTwitterAndFaceBook button
        followTwitterAndFaceBook.click();
        //storing all the window's id on in set with getWindowHandales methods
            Set<String> handler= driver.getWindowHandles();
            //checking numbers of window present
        System.out.println("numbers of window present:"+handler.size());
        //storing the parent window id
        String parent = driver.getWindowHandle();
        //display the parent window id
        System.out.println("parent window id:"+parent);

        String firstChild = "";
        String secondChild ="";

        for(String window:handler){
            if (!window.equals(parent)){
                driver.switchTo().window(window);
                if (driver.getCurrentUrl().contains("facebook")){
                    System.out.println("facebook url found");
                    firstChild = driver.getWindowHandle();
                }
                if (driver.getCurrentUrl().equals("https://x.com/testmuai")){
                    System.out.println("x.com testmui found");
                    secondChild =driver.getWindowHandle();

                }
            }
        }
        System.out.println("first child:"+firstChild);
        System.out.println("second child:"+secondChild);

        //switching to 1st child
        driver.switchTo().window(firstChild);
        driver.manage().window().maximize();
        String firstChildUrl = driver.getCurrentUrl();
        System.out.println(firstChildUrl);
        //finding the email text box
        WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement emailAddress= wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name='email'])[1]")));
        //enter email address in the email text box
        emailAddress.sendKeys("adyasha.panigrahi@gecurrent.com");
        //getting the value what is entered the email text box
        System.out.println(emailAddress.getAttribute("value"));
        //locating the password textbox
        WebElement password = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name='pass'])[1]")));
        //entering the password
        password.sendKeys("abcd1234");
        //getting the value what is entered in the password field
        System.out.println(password.getAttribute("value"));
        //locating the loginButton
        WebElement loginButton = driver.findElement(By.xpath("//div[@class='x1c436fg']//div[@aria-label='Log in to Facebook']"));
       //clicking on login button
        loginButton.click();
        //waitin for sometime for page load
        Thread.sleep(2000);
        //getting the actual and current url of the firstChildWindow
        String actualFaceBookUrl = driver.getCurrentUrl();
        //declaring the expected url of the firstChildWindow
        String expectedFaceBookUrl = "https://www.facebook.com/login/device-based/regular/login/?login_attempt=1";
        //Verifying actual and expected are same or not
        if (actualFaceBookUrl.equals(expectedFaceBookUrl)){
            System.out.println("login navigation is working:testcase is passed");
        }
        else {
            System.out.println("login navigation is not working:testcase is failed");
        }
        //closing the firstChildWindow
        driver.close();
        //switching to secondChildWindow
        driver.switchTo().window(secondChild);
        driver.manage().window().maximize();
        //getting the actual and current url
        String actualSecondChildUrl = driver.getCurrentUrl();
       //declaring the expected url of the secondChildWindow
        String expectedSecondChildUrl ="https://x.com/testmuai";
        //Verifying the actual and expected url of the secondChildWindow
        if (actualSecondChildUrl.equals(expectedSecondChildUrl)){
            System.out.println("second child url is showing correct:testcase is passed");
        }
        else {
            System.out.println("second child url is not showing correct:testcase is failed");
        }
        //closing the secondChildWindow
        driver.close();
        //switching to parent window
        driver.switchTo().window(parent);
        //Verifying the actual and expected url of the parentWindow
        String actualParentUrl = driver.getCurrentUrl();
        String expectedParentUrl = "https://www.testmuai.com/selenium-playground/window-popup-modal-demo/";
        if(actualParentUrl.equals(expectedParentUrl)){
            System.out.println("the parent navigation is working:testcase is passed");
        }
        else {
            System.out.println("the parent navigation is not working:testcase is failed");
        }
        //closing the parentWindow
        driver.close();

    }
}
