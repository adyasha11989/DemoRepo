package com.testNGPractice;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AssertionHelper {
    //changes made from git hub
    SoftAssert softAssert;

    public AssertionHelper() {
        softAssert = new SoftAssert();
    }
   //Hard Assertion
    public void verifyEqual(Object actual, Object expected, String failMessage, String passMessage){
        Assert.assertEquals(actual,expected,failMessage);
        System.out.println(passMessage);
    }

    public void verifyNotEqual(Object actual, Object expected, String failMessage, String passMessage){
        Assert.assertNotEquals(actual,expected,failMessage);
        System.out.println(passMessage);

    }

    public  void  verifyTrue(boolean condition, String failMessage, String passMessage){
        Assert.assertTrue(condition,failMessage);
        System.out.println(passMessage);
    }


    public void verifyFalse(boolean condition, String failMessage, String passMessage){
        Assert.assertFalse(condition,failMessage);
        System.out.println(passMessage);
    }




    //Soft Assertion
     public void softVerifyEqual(Object actual,Object expected, String failMessage, String passMessage){
        softAssert.assertEquals(actual,expected,failMessage);
        if (actual.equals(expected)){
            System.out.println(passMessage);
        }

    }

    public void softVerifyNotEqual(Object actual,Object expected,String failMessage,String passMessage){
        softAssert.assertNotEquals(actual,expected,failMessage);
        if(!actual.equals(expected)){
            System.out.println(passMessage);
        }
    }

    public void softVerifyTrue(boolean condition, String failMessage,String passMessage){
        softAssert.assertTrue(condition,failMessage);
        if(condition){
            System.out.println(passMessage);
        }
    }

    public void softVerifyFalse(boolean condition, String failMessage, String passMessage){
        softAssert.assertFalse(condition,failMessage);
        if(!condition){
            System.out.println(passMessage);
        }
    }

    public void assertAll(){
        softAssert.assertAll();
    }




}
