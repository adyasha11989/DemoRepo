package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class tableDataTesting {
    WebDriver driver;

    public tableDataTesting(WebDriver driver) {
        this.driver = driver;
    }
// to print all the data of the table
  public void tableDataCheck() throws InterruptedException {
      WebElement tableDataSearch = driver.findElement(By.xpath("//a[text()='Table Data Search']"));
      tableDataSearch.click();
      List<WebElement> rows = driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));
      System.out.println("number of rows:"+rows.size());
      int rowSize = rows.size();
      List<WebElement> column = driver.findElements(By.xpath("//table[@id='task-table']/thead/tr/th"));
      int columnSize =column.size();
      System.out.println("number of column:"+column.size());

      for (int i=1;i<=rowSize;i++){
       for (int j=1;j<=columnSize;j++){
        WebElement cell    = driver.findElement(By.xpath("//table[@id='task-table']/tbody/tr["+ i +"]/td["+ j +"]"));
           System.out.print(cell.getText()+" ");
       }
          System.out.println();
      }


driver.navigate().back();
      Thread.sleep(2000);
    }

    public void tablePagination() throws InterruptedException {
        WebElement tableSortAndSearch = driver.findElement(By.xpath("//a[text()='Table Sort & Search']"));
        tableSortAndSearch.click();
        Thread.sleep(2000);

     List<WebElement> page = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a[contains(@class,'paginate_button ')]"));
        int numberOfPage= page.size();
        System.out.println(numberOfPage);


        for (int i=1;i<=numberOfPage;i++){
            Thread.sleep(1000);
            List<WebElement> rowPage1 = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
            for (WebElement page1Data:rowPage1){
                System.out.println(page1Data.getText());
            }
            WebElement nextButton = driver.findElement(By.xpath("//a[@id='example_next']"));
            String classValue = nextButton.getAttribute("class");
            if (classValue.equals("paginate_button next")){
                nextButton.click();

            }

            System.out.println();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='example']/tbody/tr")));



        }

  driver.navigate().refresh();
    }

    public void dataRetriveFromDynamicTable() throws InterruptedException {
        List<WebElement> page = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a[contains(@class,'paginate_button ')]"));
        int numberOfPage= page.size();
        System.out.println(numberOfPage);
        for (int i=1;i<=numberOfPage;i++){
            WebElement pagination = driver.findElement(By.xpath("//a[text()='"+i+"']"));
            pagination.click();

            List<WebElement> name = driver.findElements(By.xpath("//tr//td[text()='M. Silva']"));
            if (!name.isEmpty()){
                System.out.println("found the element");
                WebElement age = driver.findElement(By.xpath("//tr//td[text()='M. Silva']/following-sibling::td[3]"));
                System.out.println("age of M.Silva is:"+age.getText());
                break;
            }
        }
        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(1000);

    }





}
