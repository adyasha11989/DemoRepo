package com.testNGPractice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class csvReaderUtility {

    public static List<String[]> csvReader(String filePath) throws IOException {

        List<String[]> data = new ArrayList<>();
        String over ="3";

        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;

        reader.readLine();

        while ((line=reader.readLine())!=null){
            String[] values = line.split(",");
            data.add(values);

        }
        reader.close();

       return data;

    }
}
