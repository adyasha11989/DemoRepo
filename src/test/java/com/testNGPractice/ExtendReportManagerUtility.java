package com.testNGPractice;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportManagerUtility {
    private static ExtentReports extent;

    public static ExtentReports getReportsInstance(){
        if(extent==null){
            ExtentSparkReporter spark = new ExtentSparkReporter("./TestngReport/ExtentReport.html");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }

}
