package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class dragAndDrop {
    public void dragAndDrop() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.testmuai.com/selenium-playground/");
        WebElement dragAndDrop = driver.findElement(By.cssSelector("ul[class='list-disc pl-10 pb-30 grid grid-cols-4 w-full gap-10 mt-30 smtablet:grid-cols-1'] li:nth-child(14) a"));
        //navigating to the dragAndDrop page
        dragAndDrop.click();
        //performing drag and drop for the usecase 1
        WebElement draggable1 = driver.findElement(By.xpath("//div[@id='todrag']/child::span[text()='Draggable 1']"));
        WebElement draggable2 = driver.findElement(By.xpath("//div[@id='todrag']/child::span[text()='Draggable 2']"));
        WebElement dropHere = driver.findElement(By.xpath("//div[@id='mydropzone']"));
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.clickAndHold(draggable1).moveToElement(dropHere).release().build().perform();
        action.clickAndHold(draggable2).moveToElement(dropHere).release().build().perform();
        Thread.sleep(2000);
        //checking the files are dragged and drop properly or not
        WebElement droppedItemList1 = driver.findElement(By.xpath("//div[@id='droppedlist']/child::span[text()='Draggable 1']"));
        String Actualtext_1 = droppedItemList1.getText();
        String Expectedtext_1= "Draggable 1";
        if (Actualtext_1.equals(Expectedtext_1)){
            System.out.println("the draggable1 is dropped sucessfully:testcase is passed");
        }
        else {
            System.out.println("the draggable1 is not dropped sucessfully:testcase is failed");
        }

        WebElement droppdedIteamList2 = driver.findElement(By.xpath("//div[@id='droppedlist']/child::span[text()='Draggable 2']"));
        String Actualtext_2 =droppdedIteamList2.getText();
        String Expectedtext_2 = "Draggable 2";
        if (Actualtext_2.equals(Expectedtext_2)){
            System.out.println("the draggable2 is dropped sucessfully:testcase is passed");
        }
        else {
            System.out.println("the draggable2 is not dropped sucessfully:testcase is failed");
        }

        //drag and drop for usecase 2
        WebElement dragMeToTarget = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHere_us2 = driver.findElement(By.xpath("//div[@id='droppable']"));
        action.clickAndHold(dragMeToTarget).moveToElement(dropHere_us2).release().build().perform();
        //Verify the dragMeToTarget dropped or not
        WebElement droppHere_check = driver.findElement(By.xpath("//div[@id='droppable']/p"));
        String Actualtext_3 =droppHere_check.getText();
        String Expectedtext_3= "Dropped!";
        if (Actualtext_3.equals(Expectedtext_3)){
            System.out.println("the drag to me is dropped sucessfully: testcase is passed");
        }
        else {
            System.out.println("the drag to me is not dropped sucessfully: testcase is failed");
        }
       //closing the browser
        driver.quit();
    }
}
