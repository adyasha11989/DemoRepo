package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class calenderHandling {
    WebDriver driver;
    public calenderHandling(WebDriver driver){
        this.driver= driver;
    }
    public void testCalanderHandling() throws InterruptedException {
        WebElement dataPickerPage = driver.findElement(By.xpath("//a[text()='JQuery Date Picker']"));
        highLightUsingJavaScript.clickJS(driver, dataPickerPage);
        Thread.sleep(1000);
        WebElement input = driver.findElement(By.xpath("//input[@id='from']"));
        input.click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
        WebElement calanderTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ui-datepicker-div']/table")));
        String date = "11/Oct/2028";
        String dateArr[] = date.split("/");
        String selectedDate = dateArr[0];
        String month = dateArr[1];
        String year = dateArr[2];

      // selection of year through clicking on next button
        while (true) {
            WebElement currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
            String currentYearText =currentYear.getText();
            if (currentYearText.equals(year)){
                break;
            }
            driver.findElement(By.xpath("//a[@data-handler='next' and @title='Next']")).click();
        }

        //selection of month using select class as month is a dropdown
        WebElement Selmonth = driver.findElement(By.xpath("//select[@data-handler='selectMonth']"));
        Select seclect = new Select(Selmonth);
        seclect.selectByVisibleText(month);

        //selection of data in iteration format
        Boolean flag = false;
        String text;
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr"));
        try {

            for (int i = 1; i <= rows.size(); i++) {
                for (int j = 1; j <= 7; j++) {


                    WebElement dateSelected = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[" + i + "]/td[" + j + "]"));
                    text = dateSelected.getText();


                    if (text.equals(selectedDate)) {
                        dateSelected.click();
                        flag = true;
                        break;
                    }
                    System.out.println(text);


                    if (flag) {
                        break;
                    }

                }


            }
        }
        catch (NoSuchElementException e){
            System.out.println("please enter a valid date");
        }
        Thread.sleep(2000);
        driver.navigate().refresh();
    }

    public void handleCalenderJS() throws InterruptedException {
        //selection of date-month-year using JavaScript executator
        WebElement input = driver.findElement(By.xpath("//input[@id='from']"));
        input.click();
        Thread.sleep(1000);
        highLightUsingJavaScript.selectDateByJS(driver,input,"10/15/2022");
        WebElement outsideArea = driver.findElement(By.tagName("body"));
        outsideArea.click();
        driver.navigate().back();
        Thread.sleep(1000);

    }

}
