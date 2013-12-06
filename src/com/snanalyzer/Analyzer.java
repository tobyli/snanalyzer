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

            UserType realTarget = (UserType)new UserType(result.get(e)).clone();
            UserType target = new UserType(realTarget);
            //System.out.print(realTarget.friends.size());
            target = new Mingle(target, result.keySet(), result).randomMingle(0);
            //System.out.printf(" %d\n", realTarget.friends.size());
            Deanonymizer deanonymizer = new Deanonymizer(target, result, realTarget);
            if(deanonymizer.deanonymize2())
                trueCounter++;
            else
                falseCounter++;
            totalCounter++;
        }
        System.out.printf("True: %d\nFalse: %d\nTotal: %d\n",trueCounter, falseCounter, totalCounter);

    }
}
