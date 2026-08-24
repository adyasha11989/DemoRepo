package com.testNGPractice;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import java.io.IOException;

public class TestListener implements ITestListener {

    private ExtentReports extent;
    private ExtentTest test;

    @Override
    public void onStart(ITestContext context){
        System.out.println("=====================Test execution started===================="+context.getName());
        extent= ExtendReportManagerUtility.getReportsInstance();
    }

@Override
    public void onTestStart(ITestResult result){
        String methodName = result.getMethod().getMethodName();
        String description = result.getMethod().getDescription();
        System.out.println("Test Started:" +methodName);
          test=  extent.createTest(methodName, description);

                 System.out.println("test data");
                  for (Object parameter: result.getParameters()){
                      test.info(parameter.toString());
                  }
    }

@Override
    public void onTestSuccess(ITestResult result){
        String methodName = result.getMethod().getMethodName();
        System.out.println("Test passed:" + methodName);
        long testStartTime = result.getStartMillis();
        long testEndTime = result.getEndMillis();
        long testExecutionTime = testEndTime-testStartTime;
      System.out.println("TestExecution Time:"+testExecutionTime+"ms");
                 test.pass("Test passed sucessfully");

    }

@Override
    public void onTestFailure(ITestResult result){
        String methodName = result.getMethod().getMethodName();
        System.out.println("Test failed: "+ methodName);
        long testExecutionStart = result.getStartMillis();
        long testExecutionEnd = result.getEndMillis();
        long testExecution = testExecutionEnd- testExecutionStart;
    System.out.println("Test Execution Time:"+testExecution);

    test.fail(result.getThrowable());
    System.out.println("Failure Reason:"+ result.getThrowable());

Object[] parameters=result.getParameters();

    System.out.println("Parameters:");

   for(Object parameter:parameters){
       System.out.println(parameter);
   }

    BaseTest testclass=  (BaseTest) result.getInstance();
    WebDriver driver  =   testclass.driver;
   ScreenSortUtility sc = new ScreenSortUtility(driver);
    try {
        String screenShortPath = sc.takeScreenShort(methodName);
        test.addScreenCaptureFromPath(screenShortPath);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }


}

@Override
    public void onTestSkipped(ITestResult result){
        System.out.println("Test skipped:"+ result.getMethod().getMethodName());
        test.skip("Test was skipped");
    }

    @Override
    public void onFinish(ITestContext context){
        System.out.println("======================Test execution Completed============================"+context.getName());

    extent.flush();
    }



}
