package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class example3Dropdown {
    public void dropdown(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.testmuai.com/selenium-playground/");
        driver.findElement(By.linkText("Select Dropdown List")).click();
        WebElement dropdown = driver.findElement(By.id("select-demo"));
        Select select = new Select(dropdown);
        select.selectByValue("Saturday");
        WebElement multipleDropdown = driver.findElement(By.name("States"));
        Select multipleSelect = new Select(multipleDropdown);
        multipleSelect.selectByValue("New York");
        List<WebElement> selectedlist = multipleSelect.getAllSelectedOptions();
        for (WebElement options:selectedlist){
            System.out.println(options.getText());
            System.out.println(selectedlist.size());
        }

        driver.findElement(By.id("printMe")).click();
        System.out.println("button clicked");

        WebElement text = driver.findElement(By.xpath("//span[@class='genderbutton']"));
        String actual = text.getText();
        System.out.println("actual is:"+actual);
        if (actual.equals("New York")) {
            System.out.println("test case is passed");
        }
        else {
            System.out.println("test case is fail");
        }
        System.out.println(multipleSelect.isMultiple());

         multipleSelect.deselectByValue("New York");

//         multipleSelect.selectByVisibleText("Pennsylvania");
//         multipleSelect.selectByVisibleText("Washington");
//
//        List<WebElement> selectedOptions = multipleSelect.getAllSelectedOptions();
//        for (WebElement options:selectedOptions){
//            System.out.println(options.getText());
//            System.out.println(selectedOptions.size());
//        }
//
//        WebElement getLastSelected = driver.findElement(By.id("printAll"));
//        getLastSelected.click();
//     String text1 =   driver.findElement(By.xpath("//span[@class='groupradiobutton block break-words']")).getText();
//        System.out.println(text1);

        // multi selection of dropdown by using action class-
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL)
                .click(driver.findElement(By.xpath("//option[@value='Texas']")))
                .click(driver.findElement(By.xpath("//option[@value='Washington']")))
                .keyUp(Keys.CONTROL)
                .perform();
            driver.findElement(By.id("printAll")).click();


    }
}
