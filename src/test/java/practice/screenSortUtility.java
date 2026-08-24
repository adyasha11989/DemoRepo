package practice;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class screenSortUtility {
    WebDriver driver;

    public screenSortUtility(WebDriver driver){
        this.driver=driver;
    }

    public static void takeScreenSort(WebDriver driver,String pageName) throws IOException {
     File folder = new File("./Screenshots");
     if (!folder.exists()){
         folder.mkdirs();
     }

     String timeStamp = new SimpleDateFormat("yyyymmdd_HHmmss").format(new Date());


        TakesScreenshot ts =(TakesScreenshot) driver;
       File source= ts.getScreenshotAs(OutputType.FILE);
       File destination = new File("./Screenshots/"+pageName+"_"+timeStamp + ".png");
       FileUtils.copyFile(source,destination);
        System.out.println("screen short taken sucessfully");
    }

}
