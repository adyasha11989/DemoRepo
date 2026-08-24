package com.testNGPractice;

import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.List;

public class TestDataProvider {

    @DataProvider(name="testDataForm")
    public Object[][] formSubmissionData(){
        return new  Object[][]{
                {"Adyasha","ady123@gmail.com","pass1","nagarro","nagarroWebSite",
                        "Mexico","sambalpur","sambalpur","govindtola",
                        "Odisha","768005"},
                {"Shivi","shivi@gmail.com","pass2","TCS","TCSWebsite",
                        "India","Bhubanswer","IRC Village","Nayapally",
                        "Odisha","765002"}



        };
    }

    @DataProvider(name = "simpleForm")
    public Object[][] simpleForm(){
        return new Object[][]{
                {new SimpleFormTestData("Hello Selenium",8,8)},
                {new SimpleFormTestData("Hi Testing!How are you",14,8)}

        };
    }


    @DataProvider(name="ajaxFormSubmit")
    public Object[][] ajaxFormSumbit() throws IOException {
        String filePath ="C:\\Users\\adyashapanigrahi\\IdeaProjects\\Selenium\\AutomationLearning\\src\\test\\Resources\\TestData\\formData.csv";
      List<String[]> csvData = csvReaderUtility.csvReader(filePath);

      Object[][] data = new Object[csvData.size()][];

      for(int i=0;i<csvData.size();i++){
          data[i]= csvData.get(i);
      }

      return data;



    }





}
