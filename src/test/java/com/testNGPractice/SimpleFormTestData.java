package com.testNGPractice;

public class SimpleFormTestData {
    String messege;
    int firstValue;
    int secondValue;

    public SimpleFormTestData(String messege, int firstValue, int secondValue) {
        this.messege = messege;
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    @Override
    public String toString(){
        return "message:"+messege +"," +"first value:"+firstValue+","+"second value:"+secondValue;
    }

}
