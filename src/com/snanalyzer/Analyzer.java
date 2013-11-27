package com.snanalyzer;

import java.util.Map;

public class Analyzer {


    public static void main(String[] args) throws Exception{
	// write your code here
        int trueCounter = 0, falseCounter = 0, totalCounter = 0;
        Map<Integer,UserType> result = new UserParser("testData.txt").parse();
        int progressCounter = 0;
        for(Integer e: result.keySet()){
            progressCounter++;
            if(progressCounter % 100 == 0)
                System.out.printf("%d out of 3959\n", progressCounter);
            UserType target = result.get(e);
            target = new Mingle(target, result.keySet(), result).userMingle(3);
            Deanonymizer deanonymizer = new Deanonymizer(target, result);
            if(deanonymizer.deanonymize())
                trueCounter++;
            else
                falseCounter++;
            totalCounter++;
        }
        System.out.printf("True: %d\nFalse: %d\nTotal: %d\n",trueCounter, falseCounter, totalCounter);

    }
}
