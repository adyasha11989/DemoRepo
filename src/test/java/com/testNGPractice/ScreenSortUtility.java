package com.testNGPractice;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenSortUtility {
    WebDriver driver;

    public ScreenSortUtility(WebDriver driver) {
        this.driver = driver;
    }

    public String takeScreenShort(String methodName) throws IOException {
        File folder = new File("./TestngScreenShort");
        if (!folder.exists()){
            folder.mkdirs();
        }

        String timeStamp = new SimpleDateFormat("YYmmdd_HHmmss").format(new Date());

        TakesScreenshot ts =(TakesScreenshot) driver;
        File source =ts.getScreenshotAs(OutputType.FILE);
        File destination = new File("./TestngScreenShort/"+methodName+"_"+timeStamp+".png");
        FileUtils.copyFile(source,destination);
        System.out.println("screenshort taken sucessfully"+destination.getAbsolutePath());
        return destination.getAbsolutePath();

    }

}
