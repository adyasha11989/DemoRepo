package practice;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class actionsClassMethods {
    WebDriver driver;

    public actionsClassMethods(WebDriver driver) {
        this.driver = driver;
    }
    public void actionsClassMethods() throws InterruptedException {
        WebElement fileDownload = driver.findElement(By.xpath("//a[text()='File Download']"));
        Actions actions = new Actions(driver);
        actions.click(fileDownload).perform();


       //double click
        WebElement textAreaTextBox = driver.findElement(By.xpath("//textarea[@id='textbox']"));
        actions.doubleClick(textAreaTextBox).perform();

        //mousehover
        WebElement resourcesBtn = driver.findElement(By.xpath("//button[text()='Resources ']"));
        actions.moveToElement(resourcesBtn).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement carrersOption=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Careers']/ancestor::a")));
        carrersOption.click();

        driver.navigate().back();
        driver.navigate().back();
        Thread.sleep(1000);

        //right click
        WebElement contextMenuPage = driver.findElement(By.xpath("//a[text()=' Context Menu']"));
        contextMenuPage.click();
        WebElement contextMenuButton = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(contextMenuButton).perform();
        //check alert is present or not
        if (isAlertPrestnt()){
            Alert alert =driver.switchTo().alert();
            System.out.println("alert text:"+ alert.getText());
            alert.accept();
        }
        else {
            System.out.println("no alert found");
        }
        driver.navigate().back();
        Thread.sleep(1000);
        WebElement shadowDomPage = driver.findElement(By.xpath("//a[text()=' Shadow DOM']"));
        shadowDomPage.click();


        WebElement shadowHostDiv =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='shadow_host']")));

                SearchContext shadowRoot =  shadowHostDiv.getShadowRoot();//here we are creating the shadwRoot instance with the help of getShadowRoot() method.

                WebElement name = shadowRoot.findElement(By.cssSelector("input[placeholder='Name']"));

            wait.until(ExpectedConditions.elementToBeClickable(name));

            name.sendKeys("Shiv");
            WebElement range = shadowRoot.findElement(By.cssSelector("input[type='range']"));
            actions.clickAndHold(range).moveByOffset(80,0).release().perform();
             driver.navigate().back();
             Thread.sleep(1000);

             WebElement dragAndDropLink = driver.findElement(By.xpath("//a[text()='Drag and Drop']"));
             dragAndDropLink.click();

             WebElement dropBox1 = driver.findElement(By.xpath("//span[text()='Draggable 1']"));
             WebElement dropHere = driver.findElement(By.xpath("//div[@id='mydropzone']"));
             actions.dragAndDrop(dropBox1,dropHere).perform();

             driver.navigate().back();
             Thread.sleep(1000);
             //slider moving using dragAndDropBy
             WebElement dragAndDropSlider = driver.findElement(By.xpath("//a[text()='Drag & Drop Sliders']"));
             dragAndDropSlider.click();
            //dragAndDropBy()
             WebElement slider = driver.findElement(By.xpath("//div[@id='slider1']//input[@type='range']"));
             actions.dragAndDropBy(slider,80,0).perform();

             driver.navigate().back();
             Thread.sleep(1000);
             //Keybords operations using Actions class
             WebElement simpleFormDemoPage= driver.findElement(By.xpath("//a[text()='Simple Form Demo']"));
             simpleFormDemoPage.click();

             WebElement firstValueInputBox =driver.findElement(By.xpath("//input[@id='sum1']"));
             //click on the textbox
             actions.click(firstValueInputBox)
                     //type the value
                     .sendKeys("82")
                     //select the entered value
                     .keyDown(Keys.CONTROL)
                     .sendKeys("a")
                     .keyUp(Keys.CONTROL)
                     //copy the entered value
                     .keyDown(Keys.CONTROL)
                     .sendKeys("c")
                     .keyUp(Keys.CONTROL)
                     //move to next text box
                     .sendKeys(Keys.TAB)
                     //past the copied value on textbox2
                     .keyDown(Keys.CONTROL)
                     .sendKeys("v")
                     .keyUp(Keys.CONTROL)
                     //execute the actions
                     .perform();
             WebElement getSumButton = driver.findElement(By.xpath("//button[text()='Get Sum']"));
            actions.click(getSumButton).perform();

            String actualSum = driver.findElement(By.xpath("//p[@id='addmessage']")).getText();
            if (actualSum.equals("164")){
                System.out.println(" the addition is working:test case is passed");
            }
            else {
                System.out.println("the addition is not working: test case is failed");
            }
            driver.navigate().back();
            Thread.sleep(1000);


    }

    //utility methods to check alert is present or not
    public  boolean isAlertPrestnt(){

        try{
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
            wait.until(ExpectedConditions.alertIsPresent());
            return true;
        }
        catch (TimeoutException e){
            System.out.println("no alert present");
            return false;
        }

    }



}
